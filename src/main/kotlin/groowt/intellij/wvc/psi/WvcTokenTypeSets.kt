package groowt.intellij.wvc.psi

import com.intellij.psi.tree.TokenSet
import groowt.view.component.web.antlr.WebViewComponentsLexer.*

object WvcTokenTypeSets {

    val tagStructureTokens: TokenSet = createWvcTokenSet(
        ComponentOpen,
        ComponentClose,
        ComponentSelfClose,
        ClosingComponentOpen,
        FragmentOpen,
        FragmentClose
    )

    val tagIdentifierTokens: TokenSet = createWvcTokenSet(TypedIdentifier, StringIdentifier)
    val badTokens: TokenSet = createWvcTokenSet(TagStartError, TagError)

}
