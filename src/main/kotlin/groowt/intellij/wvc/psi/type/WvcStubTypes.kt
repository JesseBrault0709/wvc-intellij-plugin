package groowt.intellij.wvc.psi.type

interface WvcStubTypes {

    companion object {

        @JvmField
        val EXTERNAL_PREFIX_ID = "wvc."

        @JvmField
        val file = WvcFileElementType()

        @JvmField
        val compilationUnit =  WvcCompilationUnitType()

    }

}
