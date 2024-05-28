package groowt.intellij.wvc.psi

import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.psi.*
import com.intellij.util.ProcessingContext

class WvcTemplateTypeReferenceContributor : PsiReferenceContributor() {

    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
            psiElement(PsiTypeElement::class.java),
            object : PsiReferenceProvider() {

                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    if (element is PsiTypeElement) {
                        return arrayOf(WvcTemplateTypeReference(
                            element,
                            element.textRange,
                            element.type.canonicalText
                        ))
                    } else {
                        return arrayOf()
                    }
                }

            }
        )
    }

}
