package groowt.intellij.wvc.psi.impl

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiModifierList
import com.intellij.psi.PsiSyntheticClass
import com.intellij.psi.impl.source.PsiClassImpl
import com.intellij.psi.impl.source.PsiModifierListImpl
import groowt.intellij.wvc.psi.WvcPsiFile

class WvcTemplateClass(compilationAstNode: ASTNode) : PsiClassImpl(compilationAstNode), PsiSyntheticClass {

    private var name: String

    init {
        val psiFile = this.containingFile as WvcPsiFile
        this.name = psiFile.templateClassName
    }

    override fun getQualifiedName() = name // TODO

    override fun getName(): String = name

    override fun setName(newName: String): PsiElement {
        this.name = newName
        // TODO: get containing file and rename it
        return this
    }

    override fun getModifierList(): PsiModifierList {
        return PsiModifierListImpl(node)
    }

}
