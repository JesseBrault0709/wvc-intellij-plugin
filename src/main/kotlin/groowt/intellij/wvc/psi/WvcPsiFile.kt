package groowt.intellij.wvc.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import groowt.intellij.wvc.WvcLanguage
import groowt.intellij.wvc.WvcLanguageFileType

class WvcPsiFile(fileViewProvider: FileViewProvider, val templateClassName: String)
    : PsiFileBase(fileViewProvider, WvcLanguage) {

    override fun getFileType() = WvcLanguageFileType

    override fun toString() = "Web View Component File"

}
