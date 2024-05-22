package groowt.intellij.wvc.syntax

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import groowt.intellij.wvc.lexer.getDefaultLexer
import groowt.intellij.wvc.psi.WvcTokenType
import groowt.intellij.wvc.psi.WvcTokenTypeSets.badTokens
import groowt.intellij.wvc.psi.WvcTokenTypeSets.tagIdentifierTokens
import groowt.intellij.wvc.psi.WvcTokenTypeSets.tagStructureTokens
import groowt.intellij.wvc.syntax.WvcTextAttributeKeyArrays.badTokenKeys
import groowt.intellij.wvc.syntax.WvcTextAttributeKeyArrays.emptyKeys
import groowt.intellij.wvc.syntax.WvcTextAttributeKeyArrays.preambleBreakKeys
import groowt.intellij.wvc.syntax.WvcTextAttributeKeyArrays.tagIdentifierKeys
import groowt.intellij.wvc.syntax.WvcTextAttributeKeyArrays.tagStructureKeys
import groowt.view.component.web.antlr.WebViewComponentsLexer.PreambleBreak

class WvcSyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getHighlightingLexer() = getDefaultLexer()

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return when (tokenType) {
            in tagStructureTokens -> tagStructureKeys
            in tagIdentifierTokens -> tagIdentifierKeys
            in badTokens -> badTokenKeys
            else -> {
                if (tokenType is WvcTokenType) {
                    when (tokenType.antlrType) {
                        PreambleBreak -> preambleBreakKeys
                        else -> emptyKeys
                    }
                } else {
                    emptyKeys
                }
            }
        }
    }

}
