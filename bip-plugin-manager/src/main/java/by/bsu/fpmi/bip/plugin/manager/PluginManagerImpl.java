package by.bsu.fpmi.bip.plugin.manager;

import by.bsu.fpmi.bip.plugin.api.PluginDescriptor;

import java.util.Collection;

final class PluginManagerImpl implements PluginManager {
    private final Collection<PluginDescriptor> pluginDescriptors;

    public PluginManagerImpl(Collection<PluginDescriptor> pluginDescriptors) {
        this.pluginDescriptors = pluginDescriptors;
    }

    @Override
    public Collection<PluginDescriptor> getPluginDescriptors() {
        return pluginDescriptors;
    }
}
