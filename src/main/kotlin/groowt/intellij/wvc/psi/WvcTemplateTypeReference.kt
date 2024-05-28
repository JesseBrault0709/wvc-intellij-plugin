package groowt.intellij.wvc.psi

import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*

class WvcTemplateTypeReference(
    psiTypeElement: PsiTypeElement,
    textRange: TextRange,
    private val templateClassCanonicalName: String
) : PsiReferenceBase<PsiTypeElement>(psiTypeElement, textRange), PsiPolyVariantReference {

    override fun resolve(): PsiElement? {
        val results = multiResolve(false)
        return if (results.size == 1) {
            results[0].element
        } else {
            null
        }
    }

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        return findWvcTemplates(myElement.project, templateClassCanonicalName).map {
            PsiElementResolveResult(it)
        }.toTypedArray()
    }

    override fun getVariants(): Array<Any> {
        return findWvcTemplates(myElement.project, templateClassCanonicalName).map {
            LookupElementBuilder.create(it).withIcon(AllIcons.Xml.Html5).withTypeText(it.templateClassName)
        }.toTypedArray()
    }

}
