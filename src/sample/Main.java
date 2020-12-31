package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;




public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("view/mainPage.fxml"));
        primaryStage.setTitle("RosAtom");
        primaryStage.setScene(new Scene(root,1800, 1080));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
