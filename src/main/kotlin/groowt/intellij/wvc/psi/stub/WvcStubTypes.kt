package groowt.intellij.wvc.psi.stub

import groowt.intellij.wvc.psi.WvcElementTypes

interface WvcStubTypes {

    companion object {

        @JvmField
        val EXTERNAL_PREFIX_ID = "wvc"

        @JvmField
        val FILE = WvcElementTypes.file

        @JvmField
        val COMPILATION_UNIT = WvcElementTypes.compilationUnit

    }

}
