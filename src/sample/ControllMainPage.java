package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllMainPage {

    @FXML
    public Label privacyPolicy;
    public Button enterBatton;

    @FXML
    private Button battonMainPageEnter;

    @FXML
    private Label problemEntered;

    @FXML
    public void getPrivacyPolicyPage(MouseEvent mouseEvent) throws IOException {
        Stage stageOld = (Stage) privacyPolicy.getScene().getWindow();
        stageOld.close();
        Parent root = FXMLLoader.load(getClass().getResource("view/privacyPolicy.fxml"));
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("RosAtom");
        stage.setScene(new Scene(root, 1800, 1080));
        stage.showAndWait();
    }

    @FXML
    public void getEmloyeePage(MouseEvent mouseEvent) throws IOException {
        Stage stageOld = (Stage) enterBatton.getScene().getWindow();
        stageOld.close();
        Parent root = FXMLLoader.load(getClass().getResource("view/EmployeePage.fxml"));
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("RosAtom");
        stage.setScene(new Scene(root, 1800, 1080));
        stage.showAndWait();
    }

    @FXML
    public void getWorkPage(MouseEvent mouseEvent) throws IOException {

        Stage stageOld = (Stage) battonMainPageEnter.getScene().getWindow();
        stageOld.close();
        Parent root = FXMLLoader.load(getClass().getResource("view/EmployeePage.fxml"));
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("RosAtom");
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    private void selectImage(MouseEvent event) {
        String source1 = event.getSource().toString();
        String source2 = event.getPickResult().getIntersectedNode().getId();
        System.out.println("Full String: " + source1);
        System.out.println("Just the id: " + source2);
        System.out.println(" " + source2);
    }

    @FXML
    public void goalMause(MouseEvent mouseDragEvent) {
        problemEntered.setStyle("-fx-text-fill: #075eeb");
    }

    @FXML
    public void goalMause2(MouseEvent mouseDragEvent) {
        privacyPolicy.setStyle("-fx-text-fill: #075eeb");
    }

    @FXML
    public void goalMause3(MouseEvent mouseDragEvent) {
        enterBatton.setStyle("-fx-background-color: #075eeb");
    }

    @FXML
    public void notGoalMause(MouseEvent mouseEvent) {
        privacyPolicy.setStyle("-fx-text-fill: #078aed");
        problemEntered.setStyle("-fx-text-fill: #078aed");
        enterBatton.setStyle("-fx-background-color: #098BF3;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.24), 0, 0, 1, 1);");

    }
}

