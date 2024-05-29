package groowt.intellij.wvc.psi.type

import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.*
import groowt.intellij.wvc.WvcLanguage
import groowt.intellij.wvc.index.WVC_COMPILATION_UNIT_KEY
import groowt.intellij.wvc.psi.element.WvcCompilationUnit
import groowt.intellij.wvc.psi.element.impl.WvcCompilationUnitImpl
import groowt.intellij.wvc.psi.stub.WvcCompilationUnitStub
import groowt.intellij.wvc.psi.stub.impl.WvcCompilationUnitStubImpl

class WvcCompilationUnitType : IStubElementType<WvcCompilationUnitStub, WvcCompilationUnit>(
    "compilationUnit", WvcLanguage
) {

    override fun getExternalId() = "wvc.compilationUnit"

    override fun serialize(stub: WvcCompilationUnitStub, dataStream: StubOutputStream) {
        val templateClassName: String = stub.psi.templateClassName
        dataStream.writeName(templateClassName)
    }

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): WvcCompilationUnitStub {
        val templateClassName = dataStream.readName()
        return WvcCompilationUnitStubImpl(parentStub, templateClassName?.string)
    }

    override fun indexStub(stub: WvcCompilationUnitStub, sink: IndexSink) {
        stub.templateClassName?.let { sink.occurrence(WVC_COMPILATION_UNIT_KEY, it) }
    }

    override fun createPsi(stub: WvcCompilationUnitStub): WvcCompilationUnit {
        return WvcCompilationUnitImpl(stub)
    }

    override fun createStub(
        wvcCompilationUnit: WvcCompilationUnit,
        parentStub: StubElement<out PsiElement>?
    ): WvcCompilationUnitStub {
        return WvcCompilationUnitStubImpl(parentStub, wvcCompilationUnit.templateClassName)
    }

}
