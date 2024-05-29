package groowt.intellij.wvc.lexer

import groowt.view.component.web.antlr.WebViewComponentsLexer
import org.antlr.v4.runtime.ConsoleErrorListener

fun getDefaultWvcLexer() = WvcLexer(WebViewComponentsLexer().apply {
    removeErrorListener(ConsoleErrorListener.INSTANCE)
    addErrorListener(IntellijLexerErrorListener())
})
