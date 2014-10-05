package by.bsu.fpmi.bip.core;

import by.bsu.fpmi.bip.plugin.api.PluginDescriptor;

import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        main(args, Collections.emptyList());
    }

    public static void main(String[] args, Collection<PluginDescriptor> pluginDescriptors) {
        ApplicationContext applicationContext = ApplicationContext.createApplicationContext(args, pluginDescriptors);
        for (String arg : applicationContext.getArgs()) {
            System.out.println("Argument: " + arg);
        }
        for (PluginDescriptor pluginDescriptor : applicationContext.getPluginManager().getPluginDescriptors()) {
            System.out.println("Invoke plugin " + pluginDescriptor.getName());
            pluginDescriptor.getPlugin().invoke();
        }
    }
}
