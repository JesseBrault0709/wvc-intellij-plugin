package groowt.intellij.wvc.parser

import com.intellij.lang.PsiBuilder
import com.intellij.openapi.progress.ProgressIndicatorProvider
import groowt.intellij.wvc.psi.type.mapAntlrRuleIndexToWvcElement
import groowt.view.component.web.antlr.ParserError
import groowt.view.component.web.antlr.ParserErrorListener
import groowt.view.component.web.antlr.WebViewComponentsParserBaseListener
import groowt.view.component.web.antlr.formatParserError
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.tree.ErrorNode
import org.antlr.v4.runtime.tree.TerminalNode
import java.util.*

class WvcAntlrPsiConverter(
    parserErrorListener: ParserErrorListener,
    private val psiBuilder: PsiBuilder
) : WebViewComponentsParserBaseListener() {

    private val markerStack: Deque<PsiBuilder.Marker> = LinkedList()

    private val errors: Map<Int, ParserError> = parserErrorListener.getParserErrors().associateBy {
        it.offendingToken?.startIndex ?: 0
    }

    override fun visitTerminal(node: TerminalNode?) {
        psiBuilder.advanceLexer()
    }

    override fun enterEveryRule(ctx: ParserRuleContext) {
        ProgressIndicatorProvider.checkCanceled()
        markerStack.push(psiBuilder.mark())
    }

    override fun visitErrorNode(node: ErrorNode) {
        ProgressIndicatorProvider.checkCanceled()

        val offending: Token = node.symbol
        val conjured = offending.tokenIndex < 0
        val error: ParserError? = errors[offending.startIndex]

        if (error != null) {
            val errorMarker = psiBuilder.mark()
            if (offending.startIndex >= 0 && offending.type != Token.EOF && !conjured) {
                psiBuilder.advanceLexer()
            }
            errorMarker.error(formatParserError(error))
        } else if (conjured) {
            psiBuilder.mark().error(offending.text)
        } else {
            psiBuilder.advanceLexer()
        }
    }

    override fun exitEveryRule(ctx: ParserRuleContext) {
        ProgressIndicatorProvider.checkCanceled()
        markerStack.pop().done(mapAntlrRuleIndexToWvcElement(ctx.ruleIndex))
    }

}
