package groowt.intellij.wvc.psi

import com.intellij.psi.tree.IElementType
import groowt.intellij.wvc.WvcLanguage

class WvcTokenType(val antlrType: Int, name: String) : IElementType(name, WvcLanguage)
