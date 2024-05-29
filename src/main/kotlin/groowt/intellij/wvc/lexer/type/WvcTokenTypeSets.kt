package groowt.intellij.wvc.lexer.type

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

    val commentTokens: TokenSet = createWvcTokenSet()
    val stringLiteralTokens: TokenSet = createWvcTokenSet()

    val badTokens: TokenSet = createWvcTokenSet(ErrorChar)

}
