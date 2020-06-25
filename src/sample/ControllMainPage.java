package sample;

import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import javafx.application.HostServices;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

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
        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/src/view/EmployeePage.fxml"));
        //Parent root = (Parent)fxmlLoader.load();
        Parent root = FXMLLoader.load(getClass().getResource("view/privacyPolicy.fxml"));
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("RosAtom");
        stage.setScene(new Scene(root,1800, 1080));
        //stage.setScene(new Scene(root));
        stage.showAndWait();
    }
    @FXML
    public void getEmloyeePage(MouseEvent mouseEvent) throws IOException {

        Stage stageOld = (Stage) enterBatton.getScene().getWindow();
        stageOld.close();
        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/src/view/EmployeePage.fxml"));
        //Parent root = (Parent)fxmlLoader.load();
        Parent root = FXMLLoader.load(getClass().getResource("view/EmployeePage.fxml"));
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("RosAtom");
        stage.setScene(new Scene(root,1800, 1080));
        //stage.setScene(new Scene(root));
        stage.showAndWait();
    }


    @FXML
    public void getPasswordRecoveryPage(MouseEvent mouseEvent) throws IOException {

        /*Stage stageOld = (Stage) StringPasswordRecovery.getScene().getWindow();
        stageOld.close();
        Parent root = FXMLLoader.load(getClass().getResource("view/privacyPolicy.fxml"));
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("RosAtom");
        stage.setScene(new Scene(root));
        stage.showAndWait();*/
    }


   @FXML
   public void getWorkPage(MouseEvent mouseEvent) throws IOException {

            Stage stageOld = (Stage) battonMainPageEnter.getScene().getWindow();
            stageOld.close();
            //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/src/view/EmployeePage.fxml"));
            //Parent root = (Parent)fxmlLoader.load();
            Parent root = FXMLLoader.load(getClass().getResource("view/EmployeePage.fxml"));
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("RosAtom");
            stage.setScene(new Scene(root));
            stage.showAndWait();
    }
    private void selectImage(MouseEvent event)
    {
        String source1 = event.getSource().toString(); //yields complete string
        String source2 = event.getPickResult().getIntersectedNode().getId(); //returns JUST the id of the object that was clicked
        System.out.println("Full String: " + source1);
        System.out.println("Just the id: " + source2);
        System.out.println(" " + source2);
    }
/*
    @FXML
    public void goalMause(MouseEvent mouseDragEvent) {
        if(mouseDragEvent.getPickResult().getIntersectedNode().getId()!="") {
            switch (mouseDragEvent.getPickResult().getIntersectedNode().getId()) {
                case "StringPasswordRecovery":
                    StringPasswordRecovery.setStyle("-fx-text-fill: #2a9cee");
                    break;
                case "privacyPolicy":
                    privacyPolicy.setStyle("-fx-text-fill: #2a9cee");
                    break;
                default:
                    StringPasswordRecovery.setStyle("-fx-text-fill: #000000");
                    privacyPolicy.setStyle("-fx-text-fill: #000000");
                    break;
            }
        }
       /* String source1 = mouseDragEvent.getSource().toString();
        //String source2 = mouseDragEvent.getPickResult().getIntersectedNode().getId();
        mouseDragEvent.getPickResult().getIntersectedNode().getId().
        source2.setStyle("-fx-text-fill: #2a9cee");

        //StringPasswordRecovery.setStyle("-fx-text-fill: #2a9cee");*/

    @FXML
    public void goalMause(MouseEvent mouseDragEvent) {problemEntered.setStyle("-fx-text-fill: #075eeb");}
    @FXML
    public void goalMause2(MouseEvent mouseDragEvent) {privacyPolicy.setStyle("-fx-text-fill: #075eeb");}
    @FXML
    public void goalMause3(MouseEvent mouseDragEvent) {enterBatton.setStyle("-fx-background-color: #2889b5");}

    @FXML
    public void notGoalMause(MouseEvent mouseEvent) {
        privacyPolicy.setStyle("-fx-text-fill: #078aed");
        problemEntered.setStyle("-fx-text-fill: #078aed");
        enterBatton.setStyle("-fx-background-color: #098BF3");

    }
}

