package by.bsu.fpmi.bip.core.controller;

import by.bsu.fpmi.bip.core.application.ApplicationContext;
import by.bsu.fpmi.bip.plugin.api.ApiDescriptor;
import by.bsu.fpmi.bip.plugin.api.Plugin;
import by.bsu.fpmi.bip.plugin.api.PluginContext;
import by.bsu.fpmi.bip.plugin.api.PluginDescriptor;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;

public final class PluginController implements Initializable {
    @FXML
    private ListView<PluginDescriptorWrapper> pluginList;
    @FXML
    private Button runButton;

    private static Collection<PluginDescriptorWrapper> getResolvedPluginDescriptors() {
        return Collections.unmodifiableList(ApplicationContext.getInstance().getResolvedPluginDescriptors().stream()
                .map(PluginDescriptorWrapper::new).collect(Collectors.toList()));
    }

    @FXML @Override
    public void initialize(URL location, ResourceBundle resources) {
        pluginList.setItems(FXCollections.observableArrayList(getResolvedPluginDescriptors()));
        runButton.setOnAction(event -> {
        });
    }

    private static final class PluginDescriptorWrapper implements PluginDescriptor {
        private final PluginDescriptor descriptor;

        private PluginDescriptorWrapper(PluginDescriptor descriptor) {
            this.descriptor = descriptor;
        }

        @Override
        public String getName() {
            return descriptor.getName();
        }

        @Override public String getDescription() {
            return descriptor.getDescription();
        }

        @Override public Set<ApiDescriptor> getRequiredApiDescriptors() {
            return descriptor.getRequiredApiDescriptors();
        }

        @Override public Set<ApiDescriptor> getProvidedApiDescriptors() {
            return descriptor.getProvidedApiDescriptors();
        }

        @Override public Plugin getPlugin(PluginContext pluginContext) {
            return descriptor.getPlugin(pluginContext);
        }

        @Override public String toString() {
            return getDescription();
        }
    }
}
