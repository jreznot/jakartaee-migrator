package org.jetbrains.jeemigrator;

import com.intellij.refactoring.migration.PredefinedMigrationProvider;
import org.jetbrains.annotations.NotNull;

import java.net.URL;
import java.util.Objects;

public class JakartaMigrationProvider implements PredefinedMigrationProvider {
    @Override
    public @NotNull URL getMigrationMap() {
        return Objects.requireNonNull(JakartaMigrationProvider.class.getResource("/migration/jakartaee.xml"));
    }
}
