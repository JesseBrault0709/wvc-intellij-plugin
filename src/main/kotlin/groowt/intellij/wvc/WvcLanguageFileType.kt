package groowt.intellij.wvc

import com.intellij.icons.AllIcons
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object WvcLanguageFileType : LanguageFileType(WvcLanguage) {

    override fun getName() = "Web View Components"

    override fun getDescription() = "Templating language for Groowt Web View Components."

    override fun getDefaultExtension() = "wvc"

    override fun getIcon(): Icon = AllIcons.Xml.Html5 // TODO: make our own icon

}
