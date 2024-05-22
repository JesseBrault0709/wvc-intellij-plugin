package groowt.intellij.wvc.lexer

import groowt.intellij.wvc.WvcLanguage
import groowt.view.component.web.antlr.SimplePairCounter
import groowt.view.component.web.antlr.WebViewComponentsLexer
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.ANTLRLexerState
import org.antlr.v4.runtime.Lexer

class WvcLexer(lexer: WebViewComponentsLexer = WebViewComponentsLexer()) : ANTLRLexerAdaptor(WvcLanguage, lexer) {

    override fun getInitialState(): ANTLRLexerState {
        return WvcLexerState(
            mode = Lexer.DEFAULT_MODE,
            modeStack = null,
            curlies = SimplePairCounter(),
            parentheses = SimplePairCounter(),
            canPreamble = true,
            inPreamble = false,
            inConstructor = false
        )
    }

    override fun getLexerState(lexer: Lexer?): ANTLRLexerState {
        lexer as WebViewComponentsLexer
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
