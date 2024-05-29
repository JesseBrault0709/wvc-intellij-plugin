package groowt.intellij.wvc.psi.element

import com.intellij.psi.StubBasedPsiElement
import groowt.intellij.wvc.psi.stub.WvcCompilationUnitStub

interface WvcCompilationUnit : StubBasedPsiElement<WvcCompilationUnitStub> {
    val templateClassName: String
    val templateClass: WvcTemplateClass
}
