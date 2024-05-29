package groowt.intellij.wvc.psi

import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElementFinder
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.StubIndex
import groowt.intellij.wvc.index.WVC_COMPILATION_UNIT_KEY
import groowt.intellij.wvc.psi.element.WvcCompilationUnit

class WvcTemplateTypeFinder : PsiElementFinder() {

    override fun findClass(qualifiedName: String, scope: GlobalSearchScope): PsiClass? {
        return fetch(qualifiedName, scope).firstOrNull()?.templateClass
    }

    override fun findClasses(qualifiedName: String, scope: GlobalSearchScope): Array<PsiClass> {
        return fetch(qualifiedName, scope).map { it.templateClass }.toTypedArray()
    }

    private fun fetch(qualifiedName: String, scope: GlobalSearchScope): Collection<WvcCompilationUnit> {
        return scope.project?.let {
            StubIndex.getElements(
                WVC_COMPILATION_UNIT_KEY,
                qualifiedName,
                it,
                scope,
                WvcCompilationUnit::class.java
            )
        } ?: listOf()
    }

}
