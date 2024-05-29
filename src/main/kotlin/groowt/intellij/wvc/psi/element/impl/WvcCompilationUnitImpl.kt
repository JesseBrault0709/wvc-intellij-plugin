package groowt.intellij.wvc.psi.element.impl

import com.intellij.extapi.psi.StubBasedPsiElementBase
import com.intellij.lang.ASTNode
import groowt.intellij.wvc.psi.element.WvcCompilationUnit
import groowt.intellij.wvc.psi.element.WvcTemplateClass
import groowt.intellij.wvc.psi.stub.WvcCompilationUnitStub
import groowt.intellij.wvc.psi.type.WvcStubTypes

class WvcCompilationUnitImpl : StubBasedPsiElementBase<WvcCompilationUnitStub>, WvcCompilationUnit {

    constructor(stub: WvcCompilationUnitStub) : super(stub, WvcStubTypes.compilationUnit)

    constructor(node: ASTNode) : super(node)

    override val templateClassName: String
        get() = stub?.templateClassName ?: containingFile.virtualFile?.nameWithoutExtension ?: "AnonymousWvcTemplate"

    override val templateClass: WvcTemplateClass by lazy {
        WvcTemplateClassImpl(this.node)
    }

    override fun toString(): String {
        return "WvcCompilationUnitImpl($node)"
    }

}
