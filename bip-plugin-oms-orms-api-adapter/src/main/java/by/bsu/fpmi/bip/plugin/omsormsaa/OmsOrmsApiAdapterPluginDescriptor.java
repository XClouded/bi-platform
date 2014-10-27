package by.bsu.fpmi.bip.plugin.omsormsaa;

import by.bsu.fpmi.bip.plugin.api.ApiDescriptor;
import by.bsu.fpmi.bip.plugin.api.ApiDescriptors;
import by.bsu.fpmi.bip.plugin.api.Plugin;
import by.bsu.fpmi.bip.plugin.api.PluginContext;
import by.bsu.fpmi.bip.plugin.api.PluginDescriptor;

import java.util.Collections;
import java.util.Set;

public final class OmsOrmsApiAdapterPluginDescriptor implements PluginDescriptor {
    private final Set<ApiDescriptor> providedApiDescriptors;
    private final Set<ApiDescriptor> requiredApiDescriptors;

    public OmsOrmsApiAdapterPluginDescriptor() {
        this.providedApiDescriptors = Collections.singleton(ApiDescriptors
                .getProvidedApiDescriptor("by.bsu.fpmi.bip.plugin.orp.storage.api.spi.OrpStorageApiProvider", "0.1",
                        null));
        this.requiredApiDescriptors = Collections.singleton(
                ApiDescriptors.getRequiredApiDescriptor("by.bsu.fpmi.bip.plugin.oms.api.spi.OmsApiProvider", "0.1"));
    }

    @Override
    public String getName() {
        return "by.bsu.fpmi.bip.plugin.omsormsaa.OmsOrmsApiAdapterPluginDescriptor";
    }

    @Override
    public String getDescription() {
        return "OMS (OLAP multidimensional storage) - ORMS (OLAP report master storage) API adapter";
    }

    @Override
    public Set<ApiDescriptor> getRequiredApiDescriptors() {
        return requiredApiDescriptors;
    }

    @Override
    public Set<ApiDescriptor> getProvidedApiDescriptors() {
        return providedApiDescriptors;
    }

    @Override
    public Plugin getPlugin(PluginContext pluginContext) {
        return null;
    }
}
