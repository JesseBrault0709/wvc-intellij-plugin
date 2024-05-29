package groowt.intellij.wvc.parser

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IFileElementType
import groowt.intellij.wvc.lexer.getDefaultWvcLexer
import groowt.intellij.wvc.psi.element.WvcPsiFile
import groowt.intellij.wvc.lexer.type.WvcTokenTypeSets
import groowt.intellij.wvc.psi.element.impl.WvcCompilationUnitImpl
import groowt.intellij.wvc.psi.type.WvcStubTypes

class WvcParserDefinition : ParserDefinition {

    override fun createLexer(project: Project?) = getDefaultWvcLexer()

    override fun createParser(project: Project?) = WvcParser()

    override fun getFileNodeType(): IFileElementType = WvcStubTypes.file

    override fun getCommentTokens() = WvcTokenTypeSets.commentTokens

    override fun getStringLiteralElements() = WvcTokenTypeSets.stringLiteralTokens

    override fun createElement(astNode: ASTNode): PsiElement {
        if (astNode.elementType == WvcStubTypes.compilationUnit) {
            return WvcCompilationUnitImpl(astNode)
        } else {
            return ASTWrapperPsiElement(astNode)
        }
    }

    override fun createFile(fileViewProvider: FileViewProvider) =
        WvcPsiFile(fileViewProvider, fileViewProvider.virtualFile.nameWithoutExtension)

}
