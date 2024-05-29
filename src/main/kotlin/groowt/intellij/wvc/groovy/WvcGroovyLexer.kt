package groowt.intellij.wvc.groovy

import com.intellij.lexer.LexerBase
import com.intellij.psi.tree.IElementType
import groowt.intellij.wvc.lexer.WvcLexer
import groowt.intellij.wvc.lexer.getDefaultWvcLexer
import groowt.intellij.wvc.lexer.type.WvcGroovyTokenType
import org.jetbrains.plugins.groovy.lang.lexer.GroovyLexer

class WvcGroovyLexer : LexerBase() {

    private val groovyLexer: GroovyLexer = GroovyLexer()
    private val wvcLexer: WvcLexer = getDefaultWvcLexer()
    private var inGroovy = false
    private var lastWvcState: Int = 0
    private var lastGroovyState: Int = 0

    private lateinit var myBuffer: CharSequence
    private var myBufferEnd: Int = 0

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        myBuffer = buffer
        lastWvcState = initialState
        myBufferEnd = endOffset
        wvcLexer.start(buffer, startOffset, endOffset, initialState)
    }

    override fun getState(): Int = if (inGroovy) groovyLexer.state else wvcLexer.state

    override fun getTokenType(): IElementType? {
        if (!inGroovy && wvcLexer.tokenType is WvcGroovyTokenType) {
            inGroovy = true
            lastWvcState = wvcLexer.state
            groovyLexer.start(bufferSequence, wvcLexer.tokenStart, wvcLexer.tokenEnd, lastGroovyState)
        } else if (inGroovy && groovyLexer.tokenType == null) {
            inGroovy = false
            lastGroovyState = groovyLexer.state
            wvcLexer.start(bufferSequence, currentPosition.offset, myBufferEnd, lastWvcState)
        }
        return if (inGroovy) groovyLexer.tokenType else wvcLexer.tokenType
    }

    override fun getTokenStart(): Int = if (inGroovy) groovyLexer.tokenStart else wvcLexer.tokenStart

    override fun getTokenEnd(): Int = if (inGroovy) groovyLexer.tokenEnd else wvcLexer.tokenEnd

    override fun advance() {
        if (inGroovy) {
            groovyLexer.advance()
        } else {
            wvcLexer.advance()
        }
    }

    override fun getBufferSequence(): CharSequence = myBuffer

    override fun getBufferEnd(): Int = myBufferEnd

}
