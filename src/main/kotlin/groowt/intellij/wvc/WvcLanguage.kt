package groowt.intellij.wvc

import com.intellij.lang.Language

object WvcLanguage : Language("Web View Components") {

    private fun readResolve(): Any = WvcLanguage

    override fun getDisplayName() = "Web View Components"

}
