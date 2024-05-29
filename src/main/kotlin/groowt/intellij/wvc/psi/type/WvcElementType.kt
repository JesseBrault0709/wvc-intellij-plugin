package groowt.intellij.wvc.psi.type

import com.intellij.psi.tree.IElementType
import groowt.intellij.wvc.WvcLanguage

class WvcElementType(debugName: String) : IElementType(debugName, WvcLanguage) {

    override fun toString(): String {
        return "WvcElement(${super.toString()})"
    }

}
