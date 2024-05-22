package groowt.intellij.wvc.syntax

import com.intellij.openapi.editor.colors.TextAttributesKey

object WvcTextAttributeKeyArrays {
    val preambleBreakKeys = arrayOf(WvcTextAttributeKeys.preambleBreak)
    val tagStructureKeys = arrayOf(WvcTextAttributeKeys.tokenStructure)
    val tagIdentifierKeys = arrayOf(WvcTextAttributeKeys.tokenIdentifier)
    val badTokenKeys = arrayOf(WvcTextAttributeKeys.badToken)
    val emptyKeys = emptyArray<TextAttributesKey>()
}
