package by.bsu.fpmi.bip.plugin.api;

import java.util.Set;

public interface PluginDescriptor {
    String getName();

    String getDescription();

    Set<ApiDescriptor> getRequiredApiDescriptors();

    Set<ApiDescriptor> getProvidedApiDescriptors();

    Plugin getPlugin(PluginContext pluginContext);
}
