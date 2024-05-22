package groowt.intellij.wvc.lexer

import com.intellij.openapi.diagnostic.Logger
import groowt.view.component.web.antlr.LexerError
import groowt.view.component.web.antlr.LexerErrorType
import groowt.view.component.web.antlr.WebViewComponentsLexer
import groowt.view.component.web.antlr.formatLexerError
import groowt.view.component.web.util.SourcePosition
import org.antlr.v4.runtime.BaseErrorListener
import org.antlr.v4.runtime.LexerNoViableAltException
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer
import org.antlr.v4.runtime.misc.Interval

class IntellijLexerErrorListener : BaseErrorListener() {

    companion object {
        private val logger = Logger.getInstance(IntellijLexerErrorListener::class.java)
    }

    override fun syntaxError(
        recognizer: Recognizer<*, *>?,
        offendingSymbol: Any?,
        line: Int,
        charPositionInLine: Int,
        msg: String?,
        e: RecognitionException?
    ) {
        if (e is LexerNoViableAltException) {
            val lexer = e.recognizer as WebViewComponentsLexer
            val sourcePosition = SourcePosition(line, charPositionInLine + 1)
            val badText = lexer.inputStream.getText(
                Interval.of(e.startIndex, e.startIndex)
            )
            val lexerError = LexerError(
                LexerErrorType.NO_VIABLE_ALTERNATIVE,
                sourcePosition,
                badText,
                lexer._mode
            )
            logger.error(formatLexerError(lexerError), e)
        } else {
            logger.error("Unknown lexer error: $e", e)
        }
    }

}
