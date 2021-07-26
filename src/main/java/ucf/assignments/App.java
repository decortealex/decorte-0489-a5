package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage pStage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(new File("src\\main\\resources\\Main.fxml").toURI().toURL());
            Parent root = loader.load();

            Scene scene = new Scene(root);

            pStage.setTitle("ucf.assignments.Inventory Management System");
            pStage.setScene(scene);
            pStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }




    }
}
