package by.bsu.fpmi.bip.core.application;

import by.bsu.fpmi.bip.plugin.api.PluginDescriptor;
import by.bsu.fpmi.bip.plugin.manager.PluginManager;
import by.bsu.fpmi.bip.plugin.manager.PluginManagers;

import java.util.Collection;

public final class ApplicationContext {
    private static ApplicationContext сontext;

    private final String[] args;
    private final PluginManager pluginManager;

    private ApplicationContext(String[] args, PluginManager pluginManager) {
        this.args = args;
        this.pluginManager = pluginManager;
    }

    public static ApplicationContext getInstance() {
        return сontext;
    }

    public static void initialize(String[] args, Collection<PluginDescriptor> pluginDescriptors) {
        PluginManager pluginManager = PluginManagers.newPluginManager(pluginDescriptors);
        сontext = new ApplicationContext(args, pluginManager);
    }

    public String[] getArgs() {
        return args;
    }

    public PluginManager getPluginManager() {
        return pluginManager;
    }

    public Collection<PluginDescriptor> getResolvedPluginDescriptors() {
        return pluginManager.getPluginDescriptors();
    }
}
