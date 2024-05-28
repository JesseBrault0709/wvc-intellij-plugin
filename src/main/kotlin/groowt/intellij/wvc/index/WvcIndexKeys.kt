package groowt.intellij.wvc.index

import com.intellij.psi.PsiClass
import com.intellij.psi.stubs.StubIndexKey

val WVC_QUALIFIED_TEMPLATE_NAMES: StubIndexKey<String, PsiClass> =
    StubIndexKey.createIndexKey("wvc.qualified.template.names")
