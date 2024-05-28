package groowt.intellij.wvc.psi

import com.intellij.psi.tree.IFileElementType
import groowt.intellij.wvc.WvcLanguage

object WvcElementTypes {
    val file = IFileElementType("wvcFile", WvcLanguage)
    val compilationUnit = WvcElementType("compilationUnit")
    val preamble = WvcElementType("preamble")
    val body = WvcElementType("body")
    val bodyText = WvcElementType("bodyText")
    val questionTag = WvcElementType("questionTag")
    val htmlComment = WvcElementType("htmlComment")
    val text = WvcElementType("text")
    val bodyTextGroovyElement = WvcElementType("bodyTextGroovyElement")
    val component = WvcElementType("component")
    val selfClosingComponent = WvcElementType("selfClosingComponent")
    val componentWithChildren = WvcElementType("componentWithChildren")
    val openComponent = WvcElementType("openComponent")
    val closingComponent = WvcElementType("closingComponent")
    val fragmentComponent = WvcElementType("fragmentComponent")
    val componentArgs = WvcElementType("componentArgs")
    val componentType = WvcElementType("componentType")
    val componentConstructor = WvcElementType("componentConstructor")
    val attr = WvcElementType("attr")
    val keyValueAttr = WvcElementType("keyValueAttr")
    val booleanAttr = WvcElementType("booleanAttr")
    val value = WvcElementType("value")
    val gStringAttrValue = WvcElementType("gStringAttrValue")
    val jStringAttrValue = WvcElementType("jStringAttrValue")
    val closureAttrValue = WvcElementType("closureAttrValue")
    val componentAttrValue = WvcElementType("componentAttrValue")
    val equalsScriptlet = WvcElementType("equalsScriptlet")
    val plainScriptlet = WvcElementType("plainScriptlet")
    val dollarScriptlet = WvcElementType("dollarScriptlet")
    val dollarReference = WvcElementType("dollarReference")
}
