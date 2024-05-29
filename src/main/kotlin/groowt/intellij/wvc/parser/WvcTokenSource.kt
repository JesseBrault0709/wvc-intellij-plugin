package groowt.intellij.wvc.parser

import com.intellij.lang.PsiBuilder
import com.intellij.openapi.progress.ProgressIndicatorProvider
import com.intellij.util.text.CharSequenceReader
import groowt.intellij.wvc.lexer.type.WvcTokenType
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenFactory
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.TokenFactory
import org.antlr.v4.runtime.TokenSource
import org.antlr.v4.runtime.misc.Pair

class WvcTokenSource(private val psiBuilder: PsiBuilder) : TokenSource {

    private var tokenFactory: TokenFactory<*> = CommonTokenFactory.DEFAULT

    override fun nextToken(): Token {
        ProgressIndicatorProvider.checkCanceled()

        val wvcTokenType: WvcTokenType? = psiBuilder.tokenType as WvcTokenType?
        val antlrType: Int = wvcTokenType?.antlrType ?: Token.EOF

        val channel: Int = Token.DEFAULT_CHANNEL
        val source: Pair<TokenSource, CharStream> = Pair(this, null)
        val text: String? = psiBuilder.tokenText
        val start: Int = psiBuilder.currentOffset
        val length: Int = text?.length ?: 0
        val stop = start + length - 1

        val token: Token = tokenFactory.create(
            source, antlrType, text, channel, start, stop, 0, 0
        )
        psiBuilder.advanceLexer()
        return token
    }

    override fun getLine() = 0

    override fun getCharPositionInLine() = 0

    override fun getInputStream(): CharStream {
        val reader = CharSequenceReader(psiBuilder.originalText)
        return CharStreams.fromReader(reader)
    }

    override fun getSourceName() = CharStream.UNKNOWN_SOURCE_NAME

    override fun setTokenFactory(factory: TokenFactory<*>) {
        tokenFactory = factory
    }

    override fun getTokenFactory() = tokenFactory

}
