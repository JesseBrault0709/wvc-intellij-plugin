package groowt.intellij.wvc.lexer

import groowt.view.component.web.antlr.PairCounter
import groowt.view.component.web.antlr.WebViewComponentsLexer
import org.antlr.intellij.adaptor.lexer.ANTLRLexerState
import org.antlr.v4.runtime.Lexer
import org.antlr.v4.runtime.misc.IntegerStack
import java.util.*

@Suppress("EqualsOrHashCode")
class WvcLexerState(
    mode: Int,
    modeStack: IntegerStack?,
    private val curlies: PairCounter,
    private val parentheses: PairCounter,
    private val canPreamble: Boolean,
    private val inPreamble: Boolean,
    private val inConstructor: Boolean
) : ANTLRLexerState(mode, modeStack) {

    override fun apply(lexer: Lexer) {
        super.apply(lexer)
        if (lexer is WebViewComponentsLexer) {
            lexer.curlies = curlies
            lexer.curlies.setLexer(lexer)

            lexer.parentheses = parentheses
            lexer.parentheses.setLexer(lexer)

            lexer.isCanPreamble = canPreamble
            lexer.isInPreamble = inPreamble
            lexer.isInConstructor = inConstructor
        } else {
            throw IllegalArgumentException("Cannot use WvcLexerState with a non-WebViewComponentsLexer")
        }
    }

    override fun hashCodeImpl(): Int =
        Objects.hash(mode, modeStack, curlies, parentheses, canPreamble, inPreamble, inConstructor)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is WvcLexerState) return false
        return mode == other.mode
                && modeStack.contentEquals(other.modeStack)
                && curlies == other.curlies
                && parentheses == other.parentheses
                && canPreamble == other.canPreamble
                && inPreamble == other.inPreamble
                && inConstructor == other.inConstructor
    }

    override fun toString() = "WvcLexerState()"

}
