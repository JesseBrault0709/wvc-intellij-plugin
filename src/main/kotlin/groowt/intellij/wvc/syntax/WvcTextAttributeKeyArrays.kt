package groowt.intellij.wvc.syntax

import com.intellij.openapi.editor.colors.TextAttributesKey

object WvcTextAttributeKeyArrays {
    val preambleBreakKeys = arrayOf(WvcTextAttributeKeys.preambleBreak)
    val tokenStructureKeys = arrayOf(WvcTextAttributeKeys.tokenStructure)
    val badTokenKeys = arrayOf(WvcTextAttributeKeys.badToken)
    val emptyKeys = emptyArray<TextAttributesKey>()
}
