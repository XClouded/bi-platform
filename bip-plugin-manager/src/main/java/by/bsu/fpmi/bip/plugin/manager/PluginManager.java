package by.bsu.fpmi.bip.plugin.manager;

import by.bsu.fpmi.bip.plugin.api.PluginDescriptor;

import java.util.Collection;

public interface PluginManager {
    Collection<PluginDescriptor> getPluginDescriptors();
}
