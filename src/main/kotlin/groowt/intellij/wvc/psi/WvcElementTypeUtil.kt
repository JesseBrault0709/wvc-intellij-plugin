package groowt.intellij.wvc.psi

import groowt.view.component.web.antlr.WebViewComponentsParser.*

fun mapAntlrRuleIndexToWvcElement(ruleIndex: Int): WvcElementType {
    return when (ruleIndex) {
        RULE_compilationUnit -> WvcElementTypes.compilationUnit
        RULE_preamble -> WvcElementTypes.preamble
        RULE_body -> WvcElementTypes.body
        RULE_bodyText -> WvcElementTypes.bodyText
        RULE_questionTag -> WvcElementTypes.questionTag
        RULE_htmlComment -> WvcElementTypes.htmlComment
        RULE_text -> WvcElementTypes.text
        RULE_bodyTextGroovyElement -> WvcElementTypes.bodyTextGroovyElement
        RULE_component -> WvcElementTypes.component
        RULE_selfClosingComponent -> WvcElementTypes.selfClosingComponent
        RULE_componentWithChildren -> WvcElementTypes.componentWithChildren
        RULE_openComponent -> WvcElementTypes.openComponent
        RULE_closingComponent -> WvcElementTypes.closingComponent
        RULE_fragmentComponent -> WvcElementTypes.fragmentComponent
        RULE_componentArgs -> WvcElementTypes.componentArgs
        RULE_componentType -> WvcElementTypes.componentType
        RULE_componentConstructor -> WvcElementTypes.componentConstructor
        RULE_attr -> WvcElementTypes.attr
        RULE_keyValueAttr -> WvcElementTypes.keyValueAttr
        RULE_booleanAttr -> WvcElementTypes.booleanAttr
        RULE_value -> WvcElementTypes.value
        RULE_gStringAttrValue -> WvcElementTypes.gStringAttrValue
        RULE_jStringAttrValue -> WvcElementTypes.jStringAttrValue
        RULE_closureAttrValue -> WvcElementTypes.closureAttrValue
        RULE_componentAttrValue -> WvcElementTypes.componentAttrValue
        RULE_equalsScriptlet -> WvcElementTypes.equalsScriptlet
        RULE_plainScriptlet -> WvcElementTypes.plainScriptlet
        RULE_dollarScriptlet -> WvcElementTypes.dollarScriptlet
        RULE_dollarReference -> WvcElementTypes.dollarReference
        else -> throw IllegalArgumentException("Not a recognized antlr type: $ruleIndex")
    }
}
