package groowt.intellij.wvc.groovy

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import org.jetbrains.plugins.groovy.GroovyFileType
import org.jetbrains.plugins.groovy.GroovyLanguage

class WvcGroovyFile(fileViewProvider: FileViewProvider) : PsiFileBase(fileViewProvider, GroovyLanguage) {

    override fun getFileType(): FileType = GroovyFileType.GROOVY_FILE_TYPE

}
