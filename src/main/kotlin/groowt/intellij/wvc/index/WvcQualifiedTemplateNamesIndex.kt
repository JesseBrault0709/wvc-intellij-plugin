package groowt.intellij.wvc.index

import com.intellij.psi.PsiClass
import com.intellij.psi.stubs.StringStubIndexExtension
import com.intellij.psi.stubs.StubIndexKey

class WvcQualifiedTemplateNamesIndex : StringStubIndexExtension<PsiClass>() {

    override fun getKey(): StubIndexKey<String, PsiClass> = WVC_QUALIFIED_TEMPLATE_NAMES

}
