package groowt.intellij.wvc.psi.stub

import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.StubBase
import com.intellij.psi.stubs.StubElement

class WvcCompilationUnitStubImpl(parent: StubElement<*>?)
    : StubBase<PsiElement>(parent, WvcStubTypes.COMPILATION_UNIT), WvcCompilationUnitStub
