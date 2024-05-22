package groowt.intellij.wvc.lexer

import groowt.view.component.web.antlr.PairCounter
import org.antlr.v4.runtime.misc.IntegerStack
import java.util.*

class WvcLexerState(
    val mode: Int,
    val modeStack: IntegerStack,
    val curlies: PairCounter,
    val parentheses: PairCounter,
    val canPreamble: Boolean,
    val inPreamble: Boolean,
    val inConstructor: Boolean
) {

    override fun hashCode(): Int =
        Objects.hash(mode, modeStack, curlies, parentheses, canPreamble, inPreamble, inConstructor)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is WvcLexerState) return false
        return mode == other.mode
                && modeStack == other.modeStack
                && curlies == other.curlies
                && parentheses == other.parentheses
                && canPreamble == other.canPreamble
                && inPreamble == other.inPreamble
                && inConstructor == other.inConstructor
    }

    override fun toString() = "WvcLexerState()"

}
