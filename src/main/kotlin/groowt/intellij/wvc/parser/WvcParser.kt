package groowt.intellij.wvc.parser

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.openapi.progress.ProgressIndicatorProvider
import com.intellij.psi.tree.IElementType
import groowt.view.component.web.antlr.ParserErrorListener
import groowt.view.component.web.antlr.WebViewComponentsParser
import groowt.view.component.web.antlr.WebViewComponentsTokenStream
import org.antlr.v4.runtime.ConsoleErrorListener
import org.antlr.v4.runtime.Lexer.HIDDEN
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.tree.ParseTreeWalker

class WvcParser : PsiParser {

    override fun parse(root: IElementType, psiBuilder: PsiBuilder): ASTNode {
        ProgressIndicatorProvider.checkCanceled()

        val source = WvcTokenSource(psiBuilder)
        val tokenStream = WebViewComponentsTokenStream(source, setOf(HIDDEN))

        val parser = WebViewComponentsParser(tokenStream)
        parser.errorHandler = WvcErrorStrategy()
        parser.removeErrorListener(ConsoleErrorListener.INSTANCE)
        val errorListener = ParserErrorListener()
        parser.addErrorListener(errorListener)

        val rollbackMarker = psiBuilder.mark()
        val parseTree: ParseTree = parser.compilationUnit() // TODO: check what root is
        rollbackMarker.rollbackTo()

        val parseListener = WvcAntlrPsiConverter(errorListener, psiBuilder)
        val rootMarker = psiBuilder.mark()
        ParseTreeWalker.DEFAULT.walk(parseListener, parseTree)
        while (!psiBuilder.eof()) {
            ProgressIndicatorProvider.checkCanceled()
            psiBuilder.advanceLexer()
        }
        rootMarker.done(root)
        return psiBuilder.treeBuilt
    }

}
