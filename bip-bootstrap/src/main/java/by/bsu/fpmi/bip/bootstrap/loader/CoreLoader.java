package by.bsu.fpmi.bip.bootstrap.loader;

import by.bsu.fpmi.bip.plugin.api.PluginDescriptor;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collection;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class CoreLoader {
    private static final Logger LOGGER = Logger.getLogger(CoreLoader.class.getName());

    private static final String BIP_CORE_FILE_PATH = System.getProperty("user.dir") + "/core/bip-core.jar";
    private static final String MAIN_METHOD_NAME = "main";

    public static void launch(String[] args, Collection<PluginDescriptor> pluginDescriptors) {
        try {
            File coreFile = new File(BIP_CORE_FILE_PATH);
            ClassLoader coreClassLoader = new URLClassLoader(new URL[]{ coreFile.toURI().toURL() });
            JarFile coreJarFile = new JarFile(coreFile);
            String mainClassName = coreJarFile.getManifest().getMainAttributes().getValue(Attributes.Name.MAIN_CLASS);
            Class<?> mainClass = coreClassLoader.loadClass(mainClassName);
            Method mainMethod = mainClass.getMethod(MAIN_METHOD_NAME, String[].class, Collection.class);
            mainMethod.invoke(null, args, pluginDescriptors);
        } catch (ClassNotFoundException | IOException | NoSuchMethodException | InvocationTargetException |
                IllegalAccessException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
