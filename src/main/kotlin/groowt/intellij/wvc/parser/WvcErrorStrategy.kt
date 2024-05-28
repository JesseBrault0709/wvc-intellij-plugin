package groowt.intellij.wvc.parser

import org.antlr.v4.runtime.CommonToken
import org.antlr.v4.runtime.DefaultErrorStrategy
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.misc.IntervalSet
import org.antlr.v4.runtime.tree.ErrorNodeImpl

class WvcErrorStrategy : DefaultErrorStrategy() {

    override fun consumeUntil(recognizer: Parser, set: IntervalSet) {
        val o = recognizer.currentToken
        if (o.type == Token.EOF) {
            recognizer.ruleContext.addErrorNode(ErrorNodeImpl(o))
        }
        super.consumeUntil(recognizer, set)
    }

    override fun getMissingSymbol(recognizer: Parser): Token {
        val missingSymbol = super.getMissingSymbol(recognizer)
        if (missingSymbol is CommonToken) {
            val current: Token = recognizer.currentToken
            missingSymbol.startIndex = current.startIndex
            missingSymbol.stopIndex = current.stopIndex
        }
        return missingSymbol
    }

}
