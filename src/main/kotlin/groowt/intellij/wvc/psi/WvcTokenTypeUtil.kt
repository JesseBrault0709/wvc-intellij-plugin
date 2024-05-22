package groowt.intellij.wvc.psi

import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import com.jetbrains.rd.util.getOrCreate
import groowt.view.component.web.antlr.WebViewComponentsLexer

private val antlrTypeToIElementType: MutableMap<Int, IElementType> = HashMap()

fun mapAntlrTypeToIElementType(antlrType: Int): IElementType {
    return antlrTypeToIElementType.getOrCreate(antlrType) {
        if (antlrType == WebViewComponentsLexer.GroovyCode) {
            WvcGroovyTokenType(antlrType)
        } else {
            val displayName = WebViewComponentsLexer.VOCABULARY.getDisplayName(antlrType)
            WvcTokenType(antlrType, "Wvc$displayName")
        }
    }
}

fun createWvcTokenSet(vararg antlrTypes: Int): TokenSet =
    TokenSet.create(*antlrTypes.map(::mapAntlrTypeToIElementType).toTypedArray())
