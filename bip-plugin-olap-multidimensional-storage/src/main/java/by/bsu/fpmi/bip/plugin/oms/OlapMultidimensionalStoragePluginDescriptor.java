package by.bsu.fpmi.bip.plugin.oms;

import by.bsu.fpmi.bip.plugin.api.Plugin;
import by.bsu.fpmi.bip.plugin.api.PluginDescriptor;

public final class OlapMultidimensionalStoragePluginDescriptor implements PluginDescriptor {
    private final OlapMultidimensionalStoragePlugin plugin = new OlapMultidimensionalStoragePlugin();

    @Override
    public String getName() {
        return "OlapMultidimensionalStoragePluginDescriptor";
    }

    @Override
    public Plugin getPlugin() {
        return plugin;
    }
}
