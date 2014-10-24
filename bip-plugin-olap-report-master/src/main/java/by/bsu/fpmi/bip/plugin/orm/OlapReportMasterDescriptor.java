package by.bsu.fpmi.bip.plugin.orm;

import by.bsu.fpmi.bip.plugin.api.Plugin;
import by.bsu.fpmi.bip.plugin.api.PluginDescriptor;

public final class OlapReportMasterDescriptor implements PluginDescriptor {
    private final OlapReportMasterPlugin olapReportMasterPlugin;

    public OlapReportMasterDescriptor() {
        olapReportMasterPlugin = new OlapReportMasterPlugin();
    }

    @Override
    public String getName() {
        return "OLAP Report Master";
    }

    @Override
    public Plugin getPlugin() {
        return olapReportMasterPlugin;
    }
}
