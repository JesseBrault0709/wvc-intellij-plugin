package groowt.intellij.wvc.psi.stub

import com.intellij.psi.stubs.PsiFileStubImpl
import groowt.intellij.wvc.psi.element.WvcPsiFile

class WvcFileStub(wvcPsiFile: WvcPsiFile) : PsiFileStubImpl<WvcPsiFile>(wvcPsiFile)
