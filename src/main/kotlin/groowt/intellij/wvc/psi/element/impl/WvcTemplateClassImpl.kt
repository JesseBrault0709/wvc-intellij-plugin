package groowt.intellij.wvc.psi.element.impl

import com.intellij.lang.ASTNode
import com.intellij.psi.*
import com.intellij.psi.impl.java.stubs.PsiClassStub
import com.intellij.psi.impl.source.PsiClassImpl
import com.intellij.psi.impl.source.PsiModifierListImpl
import groowt.intellij.wvc.psi.element.WvcTemplateClass

class WvcTemplateClassImpl : PsiClassImpl, WvcTemplateClass {

    private val myModifierList by lazy {
        WvcTemplateClassModifierList(node)
    }

    constructor(psiClassStub: PsiClassStub<*>): super(psiClassStub)

    constructor(astNode: ASTNode): super(astNode)

    override fun getTypeParameters(): Array<PsiTypeParameter> = arrayOf()

    override fun hasTypeParameters(): Boolean = false

    override fun getTypeParameterList(): PsiTypeParameterList? = null

    override fun getModifierList(): PsiModifierList = myModifierList

    private class WvcTemplateClassModifierList(node: ASTNode) : PsiModifierListImpl(node), SyntheticElement {

        private val implicitModifiers: Set<String> = setOf("public")

        override fun hasModifierProperty(name: String): Boolean = name in implicitModifiers

        override fun hasExplicitModifier(name: String): Boolean = false

    }

    override fun getName(): String? {
        return super.getName()
    }

    override fun setName(newName: String): PsiElement {
        return super.setName(newName)
    }

    override fun getNameIdentifier(): PsiIdentifier? = null

    override fun getQualifiedName(): String? {
        return super.getQualifiedName()
    }

}
