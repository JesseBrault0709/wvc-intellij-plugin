package groowt.intellij.wvc.psi.stub.impl

import com.intellij.psi.stubs.StubBase
import com.intellij.psi.stubs.StubElement
import groowt.intellij.wvc.psi.element.WvcCompilationUnit
import groowt.intellij.wvc.psi.stub.WvcCompilationUnitStub
import groowt.intellij.wvc.psi.type.WvcStubTypes

class WvcCompilationUnitStubImpl(parent: StubElement<*>?, override val templateClassName: String?)
    : StubBase<WvcCompilationUnit>(parent, WvcStubTypes.compilationUnit), WvcCompilationUnitStub
