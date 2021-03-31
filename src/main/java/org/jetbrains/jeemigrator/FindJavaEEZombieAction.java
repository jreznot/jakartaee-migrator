package org.jetbrains.jeemigrator;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.search.GlobalSearchScope;
import org.jetbrains.annotations.NotNull;

import static com.intellij.psi.search.GlobalSearchScope.moduleWithDependenciesAndLibrariesScope;

public class FindJavaEEZombieAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Module module = e.getData(LangDataKeys.MODULE);
        if (module == null) return;

        JavaPsiFacade javaPsi = JavaPsiFacade.getInstance(module.getProject());
        GlobalSearchScope scope = moduleWithDependenciesAndLibrariesScope(module);
        if (javaPsi.findClass("java.xml.rpc.server.ServiceLifecycle", scope) != null) {
            Messages.showWarningDialog("JAX RPC dependency found", "You Cannot Proceed with Jakarta EE Migration");
        } else {
            Messages.showInfoMessage("Migration to Jakarta EE is possible", "Success");
        }
    }
}
