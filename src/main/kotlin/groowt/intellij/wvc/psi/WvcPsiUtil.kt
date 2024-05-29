package groowt.intellij.wvc.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import groowt.intellij.wvc.WvcLanguageFileType
import groowt.intellij.wvc.psi.element.WvcPsiFile

fun findWvcTemplates(project: Project, templateClassCanonicalName: String): List<WvcPsiFile> =
    FileTypeIndex.getFiles(WvcLanguageFileType, GlobalSearchScope.allScope(project))
        .mapNotNull {
            PsiManager.getInstance(project).findFile(it) as WvcPsiFile?
        }.filter {
            it.templateClassName == templateClassCanonicalName
        }

