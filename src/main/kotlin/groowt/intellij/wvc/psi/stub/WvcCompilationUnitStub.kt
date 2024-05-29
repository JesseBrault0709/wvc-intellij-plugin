package groowt.intellij.wvc.psi.stub

import com.intellij.psi.stubs.StubElement
import groowt.intellij.wvc.psi.element.WvcCompilationUnit

interface WvcCompilationUnitStub : StubElement<WvcCompilationUnit> {
    val templateClassName: String?
}
