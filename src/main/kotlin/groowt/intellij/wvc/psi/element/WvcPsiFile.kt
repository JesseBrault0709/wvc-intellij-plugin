package groowt.intellij.wvc.psi.element

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiClassOwner
import groowt.intellij.wvc.WvcLanguage
import groowt.intellij.wvc.WvcLanguageFileType

class WvcPsiFile(fileViewProvider: FileViewProvider, val templateClassName: String)
    : PsiFileBase(fileViewProvider, WvcLanguage), PsiClassOwner {

    override fun getFileType() = WvcLanguageFileType

    override fun toString() = "WvcPsiFile($name)"

    override fun getClasses(): Array<PsiClass> {
        val templateClass = findChildByClass(WvcTemplateClass::class.java)
        return templateClass?.let { arrayOf(it) } ?: PsiClass.EMPTY_ARRAY
    }

    override fun getPackageName(): String {
        TODO("Not yet implemented")
    }

    override fun setPackageName(packageName: String) {
        TODO("Not yet implemented")
    }

}
