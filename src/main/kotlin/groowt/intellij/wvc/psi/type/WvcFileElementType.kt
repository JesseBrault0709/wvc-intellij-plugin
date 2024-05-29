package groowt.intellij.wvc.psi.type

import com.intellij.psi.tree.IStubFileElementType
import groowt.intellij.wvc.WvcLanguage
import groowt.intellij.wvc.psi.stub.WvcFileStub

class WvcFileElementType : IStubFileElementType<WvcFileStub>(WvcLanguage) {

    override fun getExternalId() = "wvc.file"

    override fun getStubVersion(): Int = 0

}
