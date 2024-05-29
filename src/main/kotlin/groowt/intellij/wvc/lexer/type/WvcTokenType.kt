package groowt.intellij.wvc.lexer.type

import com.intellij.psi.tree.IElementType
import groowt.intellij.wvc.WvcLanguage

class WvcTokenType(val antlrType: Int, name: String) : IElementType(name, WvcLanguage)
