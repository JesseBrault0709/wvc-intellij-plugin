package groowt.intellij.wvc.index

import com.intellij.psi.stubs.StringStubIndexExtension
import com.intellij.psi.stubs.StubIndexKey
import groowt.intellij.wvc.psi.element.WvcCompilationUnit

class WvcQualifiedTemplateClassNamesIndex : StringStubIndexExtension<WvcCompilationUnit>() {

    override fun getKey(): StubIndexKey<String, WvcCompilationUnit> = WVC_COMPILATION_UNIT_KEY

}
