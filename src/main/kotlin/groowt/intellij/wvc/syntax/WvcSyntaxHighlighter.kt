package groowt.intellij.wvc.syntax

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import groowt.intellij.wvc.lexer.DefaultWvcLexerFactory
import groowt.intellij.wvc.psi.WvcTokenTypeSets.badTokens
import groowt.intellij.wvc.psi.WvcTokenTypeSets.tagStructureTokens
import groowt.intellij.wvc.syntax.WvcTextAttributeKeyArrays.badTokenKeys
import groowt.intellij.wvc.syntax.WvcTextAttributeKeyArrays.emptyKeys
import groowt.intellij.wvc.syntax.WvcTextAttributeKeyArrays.preambleBreakKeys
import groowt.intellij.wvc.syntax.WvcTextAttributeKeyArrays.tokenStructureKeys
import org.antlr.intellij.adaptor.lexer.TokenIElementType
import groowt.view.component.web.antlr.WebViewComponentsLexer.*

class WvcSyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getHighlightingLexer() = DefaultWvcLexerFactory.getLexer()

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        if (tokenType is TokenIElementType) {
            return when (tokenType) {
                in tagStructureTokens -> tokenStructureKeys
                in badTokens -> badTokenKeys
                else -> {
                    when (tokenType.antlrTokenType) {
                        PreambleBreak -> preambleBreakKeys
                        else -> emptyKeys
                    }
                }
            }
        } else {
            return emptyKeys
        }
    }

}
