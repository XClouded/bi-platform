package by.bsu.fpmi.bip.core;

import by.bsu.fpmi.bip.plugin.api.PluginDescriptor;
import by.bsu.fpmi.bip.plugin.manager.PluginManager;
import by.bsu.fpmi.bip.plugin.manager.PluginManagerFactory;

import java.util.Collection;

public final class ApplicationContext {
    private static ApplicationContext currentApplicationContext;

    private final String[] args;
    private final PluginManager pluginManager;

    private ApplicationContext(String[] args, PluginManager pluginManager) {
        this.args = args;
        this.pluginManager = pluginManager;
    }

    public static ApplicationContext getCurrentInstance() {
        return currentApplicationContext;
    }

    public static ApplicationContext createApplicationContext(String[] args,
                                                              Collection<PluginDescriptor> pluginDescriptors) {
        PluginManager pluginManager = PluginManagerFactory.createPluginManager(pluginDescriptors);
        currentApplicationContext = new ApplicationContext(args, pluginManager);
        return currentApplicationContext;
    }

    public String[] getArgs() {
        return args;
    }

    public PluginManager getPluginManager() {
        return pluginManager;
    }
}
