package groowt.intellij.wvc.psi

import com.intellij.psi.tree.TokenSet
import groowt.intellij.wvc.WvcLanguage
import groowt.view.component.web.antlr.WebViewComponentsLexer.*
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory

object WvcTokenTypeSets {

    val tagStructureTokens: TokenSet = PSIElementTypeFactory.createTokenSet(
        WvcLanguage,
        ComponentOpen,
        ComponentClose,
        ComponentSelfClose,
        ClosingComponentOpen,
        FragmentOpen,
        FragmentClose
    )

    val tagIdentifierTokens: TokenSet = PSIElementTypeFactory.createTokenSet(
        WvcLanguage, TypedIdentifier, StringIdentifier
    )

    val badTokens: TokenSet = PSIElementTypeFactory.createTokenSet(
        WvcLanguage, TagStartError, TagError
    )

}
