package groowt.intellij.wvc.syntax

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon

class WvcColorSettingsPage : ColorSettingsPage {

    private val descriptors = arrayOf(
        AttributesDescriptor("Preamble Break", WvcTextAttributeKeys.preambleBreak),
        AttributesDescriptor("Tag/Component Structure", WvcTextAttributeKeys.tokenStructure),
        AttributesDescriptor("Bad Token", WvcTextAttributeKeys.badToken)
    )

    override fun getAttributeDescriptors() = descriptors

    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY

    override fun getDisplayName() = "Web View Components"

    override fun getIcon(): Icon? = null

    override fun getHighlighter(): SyntaxHighlighter = WvcSyntaxHighlighter()

    override fun getDemoText(): String = """
        ---
        package test
        ---
        <p>Hello, World!</p>
    """.trimIndent()

    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey>? = null

}
