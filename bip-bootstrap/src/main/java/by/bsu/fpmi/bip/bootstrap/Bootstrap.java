package by.bsu.fpmi.bip.bootstrap;

import by.bsu.fpmi.bip.bootstrap.loader.CoreLoader;
import by.bsu.fpmi.bip.bootstrap.loader.PluginLoader;

final class Bootstrap {
    public static void main(String[] args) {
        CoreLoader.launch(args, PluginLoader.loadPlugins());
    }
}
