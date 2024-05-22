package groowt.intellij.wvc.lexer

import com.intellij.lexer.LexerBase
import com.intellij.psi.tree.IElementType
import com.intellij.util.text.CharSequenceReader
import groowt.intellij.wvc.psi.mapAntlrTypeToIElementType
import groowt.view.component.web.antlr.SimplePairCounter
import groowt.view.component.web.antlr.WebViewComponentsLexer
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.Lexer
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.misc.IntegerStack
import java.util.concurrent.atomic.AtomicInteger

class WvcLexer(private val lexer: WebViewComponentsLexer = WebViewComponentsLexer()) : LexerBase() {

    private var buffer: CharSequence? = null
    private var endOffset: Int? = null
    private var currentState: WvcLexerState? = null
    private val stateCounter = AtomicInteger()
    private val idToState: MutableMap<Int, WvcLexerState> = HashMap()
    private val stateToId: MutableMap<WvcLexerState, Int> = HashMap()
    private var currentToken: Token? = null

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        this.buffer = buffer
        this.endOffset = endOffset

        val reader = CharSequenceReader(buffer)
        val input = CharStreams.fromReader(reader)
        input.seek(startOffset)
        lexer.inputStream = input

        if (startOffset == 0 && initialState == 0) {
            applyState(getInitialState())
        } else {
            applyState(getStateForId(initialState))
        }

        advance()
    }

    override fun getState(): Int {
        val state = currentState ?: getInitialState()
        if (!stateToId.containsKey(state)) {
            val id = stateCounter.getAndIncrement()
            stateToId[state] = id
            idToState[id] = state
        }
        return stateToId[state] ?: throw IllegalStateException("There is no id cached for state: $state")
    }

    override fun getTokenType(): IElementType? {
        if (currentToken == null) {
            throw IllegalStateException("Cannot getTokenType() when currentToken (antlr token) is null.")
        }
        return currentToken?.run {
            if (type == Token.EOF) {
                null
            } else {
                mapAntlrTypeToIElementType(type)
            }
        }
    }

    override fun getTokenStart(): Int = currentToken!!.startIndex

    override fun getTokenEnd(): Int = currentToken!!.stopIndex + 1

    override fun advance() {
        currentState = getLexerState()
        currentToken = lexer.nextToken()
    }

    override fun getBufferSequence() = buffer!!

    override fun getBufferEnd() = endOffset!!

    private fun applyState(state: WvcLexerState) {
        lexer._mode = state.mode
        lexer._modeStack.run {
            clear()
            addAll(state.modeStack)
        }

        lexer.curlies = state.curlies.apply { setLexer(lexer) }
        lexer.parentheses = state.parentheses.apply { setLexer(lexer) }

        lexer.isCanPreamble = state.canPreamble
        lexer.isInPreamble = state.inPreamble
        lexer.isInConstructor = state.inConstructor
    }

    private fun getStateForId(id: Int): WvcLexerState {
        return idToState[id] ?: throw IllegalStateException("No cached state for id $id")
    }

    private fun getInitialState(): WvcLexerState {
        return WvcLexerState(
            mode = Lexer.DEFAULT_MODE,
            modeStack = IntegerStack(),
            curlies = SimplePairCounter(),
            parentheses = SimplePairCounter(),
            canPreamble = true,
            inPreamble = false,
            inConstructor = false
        )
    }

    private fun getLexerState(): WvcLexerState {
        return WvcLexerState(
            lexer._mode,
            lexer._modeStack,
            lexer.curlies,
            lexer.parentheses,
            lexer.isCanPreamble,
            lexer.isInPreamble,
            lexer.isInConstructor
        )
    }

}
