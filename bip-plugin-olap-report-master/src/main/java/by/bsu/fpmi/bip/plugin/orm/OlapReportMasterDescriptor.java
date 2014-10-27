package by.bsu.fpmi.bip.plugin.orm;

import by.bsu.fpmi.bip.plugin.api.ApiDescriptor;
import by.bsu.fpmi.bip.plugin.api.ApiDescriptors;
import by.bsu.fpmi.bip.plugin.api.Plugin;
import by.bsu.fpmi.bip.plugin.api.PluginContext;
import by.bsu.fpmi.bip.plugin.api.PluginDescriptor;

import java.util.Collections;
import java.util.Set;

public final class OlapReportMasterDescriptor implements PluginDescriptor {
    private final Set<ApiDescriptor> requiredApiDescriptors;
    private final OlapReportMasterPlugin olapReportMasterPlugin = new OlapReportMasterPlugin();

    public OlapReportMasterDescriptor() {
        this.requiredApiDescriptors = Collections.singleton(
                ApiDescriptors.getRequiredApiDescriptor("by.bsu.fpmi.bip.plugin.oms.api.spi.OmsApiProvider", "0.1"));
    }

    @Override
    public String getName() {
        return "by.bsu.fpmi.bip.plugin.orm.OlapReportMasterPlugin";
    }

    @Override
    public String getDescription() {
        return "OLAP Report Master";
    }

    @Override
    public Set<ApiDescriptor> getRequiredApiDescriptors() {
        return requiredApiDescriptors;
    }

    @Override
    public Set<ApiDescriptor> getProvidedApiDescriptors() {
        return Collections.emptySet();
    }

    @Override
    public Plugin getPlugin(PluginContext pluginContext) {
        return olapReportMasterPlugin;
    }
}
