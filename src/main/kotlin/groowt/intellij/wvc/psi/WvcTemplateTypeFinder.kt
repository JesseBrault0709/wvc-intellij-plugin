package groowt.intellij.wvc.psi

import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElementFinder
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.StubIndex
import groowt.intellij.wvc.index.WVC_QUALIFIED_TEMPLATE_NAMES

class WvcTemplateTypeFinder : PsiElementFinder() {

    override fun findClass(qualifiedName: String, scope: GlobalSearchScope): PsiClass? {
        return fetch(qualifiedName, scope).firstOrNull()
    }

    override fun findClasses(qualifiedName: String, scope: GlobalSearchScope): Array<PsiClass> {
        return fetch(qualifiedName, scope).toTypedArray()
    }

    private fun fetch(qualifiedName: String, scope: GlobalSearchScope): Collection<PsiClass> {
        return scope.project?.let {
            StubIndex.getElements(
                WVC_QUALIFIED_TEMPLATE_NAMES,
                qualifiedName,
                it,
                scope,
                PsiClass::class.java
            )
        } ?: listOf()
    }

}
