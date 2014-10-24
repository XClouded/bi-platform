package by.bsu.fpmi.bip.plugin.api;

import java.util.Map;

public interface PluginContext {
    Map<ApiDescriptor, Object> getRequiredApiProviders();
}
