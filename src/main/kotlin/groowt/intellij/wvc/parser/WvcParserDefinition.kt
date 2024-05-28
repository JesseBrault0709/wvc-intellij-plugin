package groowt.intellij.wvc.parser

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import groowt.intellij.wvc.lexer.getDefaultLexer
import groowt.intellij.wvc.psi.WvcElementTypes
import groowt.intellij.wvc.psi.WvcPsiFile
import groowt.intellij.wvc.psi.WvcTokenTypeSets

class WvcParserDefinition : ParserDefinition {

    override fun createLexer(project: Project?) = getDefaultLexer()

    override fun createParser(project: Project?) = WvcParser()

    override fun getFileNodeType() = WvcElementTypes.file

    override fun getCommentTokens() = WvcTokenTypeSets.commentTokens

    override fun getStringLiteralElements() = WvcTokenTypeSets.stringLiteralTokens

    override fun createElement(astNode: ASTNode): PsiElement {
        return ASTWrapperPsiElement(astNode)
    }

    override fun createFile(fileViewProvider: FileViewProvider) =
        WvcPsiFile(fileViewProvider, fileViewProvider.virtualFile.nameWithoutExtension)

}
