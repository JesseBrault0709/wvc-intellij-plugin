package groowt.intellij.wvc.psi

import com.intellij.psi.tree.ILazyParseableElementType
import groowt.intellij.wvc.WvcLanguage

class WvcGroovyTokenType(val antlrType: Int) : ILazyParseableElementType("WvcGroovyToken", WvcLanguage) {
    // TODO: override as necessary
}
