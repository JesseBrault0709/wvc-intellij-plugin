package groowt.intellij.wvc.file

import com.intellij.lang.Language
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.MultiplePsiFilesPerDocumentFileViewProvider
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import groowt.intellij.wvc.WvcLanguage
import groowt.intellij.wvc.groovy.WvcGroovyParserDefinition
import org.jetbrains.plugins.groovy.GroovyLanguage

class WvcFileViewProvider(
    manager: PsiManager,
    virtualFile: VirtualFile,
    eventSystemEnabled: Boolean
) : MultiplePsiFilesPerDocumentFileViewProvider(manager, virtualFile, eventSystemEnabled) {

    companion object {
        val LANGUAGES = mutableSetOf(WvcLanguage, GroovyLanguage)
    }

    override fun getBaseLanguage(): Language = WvcLanguage

    override fun getLanguages(): MutableSet<Language> = LANGUAGES

    override fun cloneInner(fileCopy: VirtualFile): MultiplePsiFilesPerDocumentFileViewProvider =
        WvcFileViewProvider(manager, fileCopy, isEventSystemEnabled)

    override fun createFile(lang: Language): PsiFile? {
        if (lang == GroovyLanguage) {
            return createGroovyFile()
        } else {
            return super.createFile(lang)
        }
    }

    private fun createGroovyFile(): PsiFile {
        val parserDefinition = WvcGroovyParserDefinition()
        return parserDefinition.createFile(this)
    }

}
