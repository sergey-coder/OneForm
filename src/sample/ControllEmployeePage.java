package sample;

import javafx.beans.property.SimpleSetProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class ControllEmployeePage implements Initializable {
    @FXML
    public Button battonBack;
    @FXML
    public Label privacyPolicy;
    @FXML
    public Button createDoc;
    @FXML
    public TextArea ResultDocument;
    @FXML
    public Button battonLoad;
    @FXML
    public ChoiceBox<String> selectJob;
    @FXML
    public Text nameSelectFiles;
    public Button SaveDoc;
    public TableView tableVeiw;

    String nameSelectFile;  // тут хранится  абсолютный путь до выбранного файла

    String selectJobName;// тут мы храним выбранное значение из списка должностей

    String str;//тут находится преобразованный в string результат обхода DataSet2 DataSet1
    String saveText;// текст сохраненный с главной страницы  кнопкой сохранить изменения

    // реализация кнопки "загрузить документ"__________________________________________________________________

    @FXML
    public void getFileChooser(MouseEvent mouseEvent) throws IOException {

        final FileChooser fileChooser = new FileChooser();
        TextArea textArea = new TextArea();
        textArea.setMinHeight(70);
        textArea.clear();

        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            selectFile(file);
            List<File> files = Arrays.asList(file);
            printLog(textArea, files);
            nameSelectFiles.setText("Выбран документ: " + file.getName());
        }
    }
    private void printLog(TextArea textArea, List<File> files) {
        if (files == null || files.isEmpty()) {
            return;
        }
        for (File file : files) {
            textArea.appendText(file.getAbsolutePath() + "\n");
        }
    }
    private void selectFile(File file) {
        nameSelectFile = file.getAbsolutePath();
    }

    // реализация выпадающего спика для выбора должности________________________________________________

    ObservableList<String> job = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadJob();
    }
    private void loadJob(){
        job.removeAll(job);
        String job1 = "Очень хороший сотрудник";
        String job2 = "Xороший сотрудник";
        String job3 = "Плохой сотрудник";
        String job4 = "Очень плохой сотрудник";
        String job5 = "Разработчик UX";
        job.addAll(job1,job2,job3,job4,job5);
        selectJob.getItems().addAll(job);
    }

    //реализация кнопки "создать документ"________________________________________________________
    /*public void BuilderDoc() throws SQLException {
        str = "";
        StringBuilder text = new StringBuilder();
        InOutGUI enterData = new InOutGUI();
        enterData.GetDataset1();
        enterData.GetDataset2();
        int x = enterData.DataSet1.getMetaData().getColumnCount();
        int y =1;

        while(enterData.DataSet1.next()){
            y++;
            for(int i=1; i<=x;i++){
                text.append(" " + enterData.DataSet1.getString(i));
            }
        }

        int x2 = enterData.DataSet2.getMetaData().getColumnCount();
        while(enterData.DataSet2.next()){
            for(int i=1; i<=x2;i++){
                text.append(" " + enterData.DataSet2.getString(i));
            }
        }
        str =text.toString();
    }*/
    public void BuilderDoc() throws SQLException {
        InOutGUI enterData = new InOutGUI();
        enterData.GetDataset1();
        // создаем список объектов
        int x = enterData.DataSet1.getMetaData().getColumnCount();
        String a1="";
        String a2="";
        String a3="";
        String a4="";
        String a5="";
        String a6="";
        String a7="";
        int i2 =1;
        ObservableList<CreateInstructionDataSet1> listDataset1 = FXCollections.observableArrayList();


        while(enterData.DataSet1.next()){

            for(int i=1; i<=x;i++){
                    switch (i2){
                        case 1 : if(enterData.DataSet1.getString(i)==null){
                            a1 = "null"; break;
                        } a1 = enterData.DataSet1.getString(i); break;

                        case 2 : if(enterData.DataSet1.getString(i)==null){
                            a2 = "null"; break;
                        } a2 = enterData.DataSet1.getString(i); break;
                        case 3 : if(enterData.DataSet1.getString(i)==null){
                            a3 = "null"; break;
                        }a3 = enterData.DataSet1.getString(i); break;
                        case 4 : if(enterData.DataSet1.getString(i)==null){
                            a4 = "null"; break;
                        }a4 = enterData.DataSet1.getString(i); break;
                        case 5 : if(enterData.DataSet1.getString(i)==null){
                            a5 = "null"; break;
                        } a5 = enterData.DataSet1.getString(i); break;
                        case 6 : if(enterData.DataSet1.getString(i)==null){
                            a6 = "null"; break;
                        } a6 = enterData.DataSet1.getString(i); break;
                        case 7 :if(enterData.DataSet1.getString(i)==null){
                            a7 = "null"; break;
                        } a7 = enterData.DataSet1.getString(i); break;
                        default: break;
                    }
                    i2++;
                    if(i2==8){
                        listDataset1.add(new CreateInstructionDataSet1(a1,a2,a3,a4,a5,a6,a7));
                        i2=1;
                    }

            }

        }
        for(CreateInstructionDataSet1 list : listDataset1){
            System.out.println("переменная а1 =  " + list.getAuthor());
            System.out.println("переменная а2 =  " + list.getCan());
            System.out.println("переменная а3 =  " + list.getDisp());
            System.out.println("переменная а4 =  " + list.getFeh());
            System.out.println("переменная а5 =  " + list.getId());
            System.out.println("переменная а6 =  " + list.getRank());
            System.out.println("переменная а7 =  " + list.getName());
        }
         
    }

    public void getCreateDoc(MouseEvent mouseEvent) throws SQLException {
        selectJobName = selectJob.getValue();
        BuilderDoc();
        //ResultDocument.setText(str);
    }
    public void getSaveDoc(MouseEvent mouseEvent) {
        saveText = ResultDocument.getText();
        System.out.print(saveText);

    }

    @FXML
    public void getMainPage(MouseEvent mouseEvent) throws IOException {

        battonBack.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("view/mainPage.fxml"));
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("RosAtom");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void getPrivacyPolicyPage(MouseEvent mouseEvent) throws IOException {
        Stage stageOld = (Stage) privacyPolicy.getScene().getWindow();
        stageOld.close();
        Parent root = FXMLLoader.load(getClass().getResource("view/privacyPolicy.fxml"));
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("RosAtom");
        stage.setScene(new Scene(root,1800, 1080));
        stage.showAndWait();
    }

    public void goalMause(MouseEvent mouseDragEvent) {privacyPolicy.setStyle("-fx-text-fill: #2a9cee");}

    public void notGoalMause(MouseEvent mouseEvent) {
        privacyPolicy.setStyle("-fx-text-fill: #000000");
    }

    @FXML
    public void goalMause3(MouseEvent mouseDragEvent) {createDoc.setStyle("-fx-background-color: #f209e2");}


    @FXML
    public void goalMause4(MouseEvent mouseDragEvent) {SaveDoc.setStyle("-fx-background-color: #f209e2");}

    @FXML
    public void notGoalMause3(MouseEvent mouseEvent) {
        createDoc.setStyle("-fx-background-color: #098BF3");
        SaveDoc.setStyle("-fx-background-color: #098BF3");
    }
}
