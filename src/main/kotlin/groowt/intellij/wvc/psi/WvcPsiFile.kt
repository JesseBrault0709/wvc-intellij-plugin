package groowt.intellij.wvc.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiReference
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry
import com.intellij.psi.stubs.StubElement
import groowt.intellij.wvc.WvcLanguage
import groowt.intellij.wvc.WvcLanguageFileType
import groowt.intellij.wvc.psi.stub.WvcFileStub

class WvcPsiFile(fileViewProvider: FileViewProvider, val templateClassName: String)
    : PsiFileBase(fileViewProvider, WvcLanguage) {

    override fun getFileType() = WvcLanguageFileType

    override fun toString() = "Web View Component File"

    override fun getReferences(): Array<PsiReference> {
        ReferenceProvidersRegistry.getReferencesFromProviders(this)
        return super.getReferences()
    }

    override fun getName() = templateClassName

    override fun getStub(): StubElement<*> {
        return WvcFileStub(this)
    }

}
