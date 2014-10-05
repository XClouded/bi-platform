package by.bsu.fpmi.bip.bootstrap.loader;

import by.bsu.fpmi.bip.common.util.Errors;
import by.bsu.fpmi.bip.plugin.api.PluginDescriptor;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class PluginLoader {
    private static final Logger LOGGER = Logger.getLogger(PluginLoader.class.getName());

    private static final String PLUGIN_DIRECTORY_PATH = System.getProperty("user.dir") + "/plugins";
    private static final String JAR_FILE_SUFFIX = ".jar";

    private PluginLoader() {
        Errors.throwInstantiationError();
    }

    public static Collection<PluginDescriptor> loadPlugins() {
        File pluginDirectory = new File(PLUGIN_DIRECTORY_PATH);
        File[] pluginJarFiles = pluginDirectory
                .listFiles((directory, fileName) -> fileName != null && fileName.endsWith(JAR_FILE_SUFFIX));
        List<PluginDescriptor> pluginDescriptors = new ArrayList<>();
        if (pluginJarFiles == null) {
            return pluginDescriptors;
        }
        for (File pluginJarFile : pluginJarFiles) {
            try {
                ClassLoader pluginClassLoader = new URLClassLoader(new URL[]{ pluginJarFile.toURI().toURL() });
                PluginDescriptor pluginDescriptor =
                        ServiceLoader.load(PluginDescriptor.class, pluginClassLoader).iterator().next();
                pluginDescriptors.add(pluginDescriptor);
            } catch (MalformedURLException e) {
                LOGGER.log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return pluginDescriptors;
    }
}
