package groowt.intellij.wvc.syntax

import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

class WvcSyntaxHighlighterFactory : SyntaxHighlighterFactory() {

    override fun getSyntaxHighlighter(p0: Project?, p1: VirtualFile?) = WvcSyntaxHighlighter()

}
