package by.bsu.fpmi.bip.core.ui.window;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class MainWindow extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/plugins.fxml"));
        loader.setClassLoader(getClass().getClassLoader());
        Parent root = loader.load();
        stage.setScene(new Scene(root, 300, 275));
        stage.setTitle("Business Intelligence Platform");
        stage.show();
    }
}
