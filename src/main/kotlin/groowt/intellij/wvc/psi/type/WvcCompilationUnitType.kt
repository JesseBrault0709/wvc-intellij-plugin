package groowt.intellij.wvc.psi.type

import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.*
import groowt.intellij.wvc.WvcLanguage
import groowt.intellij.wvc.index.WVC_QUALIFIED_TEMPLATE_NAMES
import groowt.intellij.wvc.psi.stub.WvcCompilationUnitStub
import groowt.intellij.wvc.psi.stub.WvcCompilationUnitStubImpl

class WvcCompilationUnitType : IStubElementType<WvcCompilationUnitStub, PsiElement>(
    "compilationUnit", WvcLanguage
) {

    override fun getExternalId() = "wvc"

    override fun serialize(stub: WvcCompilationUnitStub, dataStream: StubOutputStream) {}

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?) =
        WvcCompilationUnitStubImpl(parentStub)

    override fun indexStub(stub: WvcCompilationUnitStub, sink: IndexSink) {
        sink.occurrence(WVC_QUALIFIED_TEMPLATE_NAMES, "Hello")
    }

    override fun createPsi(stub: WvcCompilationUnitStub): PsiElement = stub.psi

    override fun createStub(
        psi: PsiElement,
        parentStub: StubElement<out PsiElement>?
    ): WvcCompilationUnitStub {
        return WvcCompilationUnitStubImpl(parentStub)
    }

}
