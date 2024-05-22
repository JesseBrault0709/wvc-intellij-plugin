package groowt.intellij.wvc.lexer

import groowt.intellij.wvc.WvcLanguage
import groowt.view.component.web.antlr.WebViewComponentsLexer
import groowt.view.component.web.antlr.WebViewComponentsParser
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.v4.runtime.ConsoleErrorListener

object DefaultWvcLexerFactory : WvcLexerFactory {

    init {
        PSIElementTypeFactory.defineLanguageIElementTypes(
            WvcLanguage,
            WebViewComponentsLexer.ruleNames,
            WebViewComponentsParser.ruleNames
        )
    }

    override fun getLexer() = WvcLexer(WebViewComponentsLexer().apply {
        removeErrorListener(ConsoleErrorListener.INSTANCE)
        addErrorListener(IntellijLexerErrorListener())
    })

}
