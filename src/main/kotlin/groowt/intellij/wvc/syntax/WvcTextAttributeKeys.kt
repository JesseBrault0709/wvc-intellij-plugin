package groowt.intellij.wvc.syntax

import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.XmlHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey

object WvcTextAttributeKeys {
    val preambleBreak = TextAttributesKey.createTextAttributesKey(
        "preambleBreak", XmlHighlighterColors.HTML_TAG
    )
    val tokenStructure = TextAttributesKey.createTextAttributesKey(
        "tokenStructure", XmlHighlighterColors.HTML_TAG
    )
    val tokenIdentifier = TextAttributesKey.createTextAttributesKey(
        "tokenIdentifier", XmlHighlighterColors.HTML_TAG_NAME
    )
    val badToken = TextAttributesKey.createTextAttributesKey("badToken", HighlighterColors.BAD_CHARACTER)
}
