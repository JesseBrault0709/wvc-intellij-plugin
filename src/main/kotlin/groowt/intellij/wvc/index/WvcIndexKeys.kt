package groowt.intellij.wvc.index

import com.intellij.psi.stubs.StubIndexKey
import groowt.intellij.wvc.psi.element.WvcCompilationUnit

val WVC_COMPILATION_UNIT_KEY: StubIndexKey<String, WvcCompilationUnit> =
    StubIndexKey.createIndexKey("wvc.compilation.unit")
