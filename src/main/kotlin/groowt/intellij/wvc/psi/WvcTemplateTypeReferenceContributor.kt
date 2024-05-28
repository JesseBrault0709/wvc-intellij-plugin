package groowt.intellij.wvc.psi

import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.*
import com.intellij.util.ProcessingContext

class WvcTemplateTypeReferenceContributor : PsiReferenceContributor() {

    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PsiTypeElement::class.java),
            object : PsiReferenceProvider() {

                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    val psiTypeElement = element as PsiTypeElement
                    return arrayOf(WvcTemplateTypeReference(
                        psiTypeElement,
                        psiTypeElement.textRange,
                        psiTypeElement.type.canonicalText
                    ))
                }

            }
        )
    }

}
