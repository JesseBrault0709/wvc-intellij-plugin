package groowt.intellij.wvc.lexer.type

import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import com.jetbrains.rd.util.getOrCreate
import groowt.view.component.web.antlr.WebViewComponentsLexer

private val antlrTokenTypeToIElementType: MutableMap<Int, IElementType> = HashMap()

fun mapAntlrTokenTypeToIElementType(antlrType: Int): IElementType {
    return antlrTokenTypeToIElementType.getOrCreate(antlrType) {
        if (antlrType == WebViewComponentsLexer.GroovyCode) {
            WvcGroovyTokenType()
        } else {
            val displayName = WebViewComponentsLexer.VOCABULARY.getDisplayName(antlrType)
            WvcTokenType(antlrType, "Wvc$displayName")
        }
    }
}

fun createWvcTokenSet(vararg antlrTypes: Int): TokenSet =
    TokenSet.create(*antlrTypes.map(::mapAntlrTokenTypeToIElementType).toTypedArray())
