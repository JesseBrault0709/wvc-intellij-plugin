package groowt.intellij.wvc.groovy

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import org.jetbrains.plugins.groovy.lang.parser.GroovyParserDefinition

class WvcGroovyParserDefinition : ParserDefinition {

    private val delegate = GroovyParserDefinition()

    override fun createLexer(project: Project?): Lexer = WvcGroovyLexer()

    override fun createParser(project: Project?): PsiParser = delegate.createParser(project)

    override fun getFileNodeType(): IFileElementType = delegate.fileNodeType

    override fun getCommentTokens(): TokenSet = delegate.commentTokens

    override fun getStringLiteralElements(): TokenSet = delegate.stringLiteralElements

    override fun createElement(node: ASTNode?): PsiElement = delegate.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = WvcGroovyFile(viewProvider)

}
