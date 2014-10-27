package by.bsu.fpmi.bip.core.application;

import by.bsu.fpmi.bip.core.application.ui.window.MainWindow;
import by.bsu.fpmi.bip.plugin.api.Plugin;
import by.bsu.fpmi.bip.plugin.api.PluginDescriptor;

import java.util.Collection;
import java.util.Collections;

final class Application {
    public static void main(String[] args) {
        initialize(args, Collections.emptyList());
    }

    public static void initialize(String[] args, Collection<PluginDescriptor> pluginDescriptors) {
        ApplicationContext.initialize(args, pluginDescriptors);
        ApplicationContext context = ApplicationContext.getInstance();
        for (String arg : context.getArgs()) {
            System.out.println("Argument: " + arg);
        }
        for (PluginDescriptor pluginDescriptor : context.getPluginManager().getPluginDescriptors()) {
            System.out.println("Invoke plugin " + pluginDescriptor.getName());
            Plugin plugin = pluginDescriptor.getPlugin(null);
            if (plugin == null) {
                System.out.println("Plugin " + pluginDescriptor.getDescription() + " is null.");
            } else {
                plugin.invoke();
            }
        }

        javafx.application.Application.launch(MainWindow.class, args);
    }
}
