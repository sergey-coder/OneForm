package sample;

import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public TableColumn <CreateInstructionDataSet1,String> Column1;
    public TableColumn <CreateInstructionDataSet1,String>Column2;
    public TableColumn <CreateInstructionDataSet1,String>Column3;
    public TableColumn <CreateInstructionDataSet1,String>Column4;
    public TableColumn <CreateInstructionDataSet1,String>Column5;
    public TableColumn <CreateInstructionDataSet1,String>Column6;
    public TableColumn <CreateInstructionDataSet1,String>Column7;
    public TableView tableVeiw2;
    public TableColumn <CreateInstructionDataSet2,String> tableVeiw2_Column1;
    public TableColumn <CreateInstructionDataSet2,String> tableVeiw2_Column2;
    public TableColumn <CreateInstructionDataSet2,String> tableVeiw2_Column3;
    public TableColumn <CreateInstructionDataSet2,String> tableVeiw2_Column4;
    public TableColumn <CreateInstructionDataSet2,String> tableVeiw2_Column5;
    public TableColumn <CreateInstructionDataSet2,String> tableVeiw2_Column6;

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
    ObservableList<CreateInstructionDataSet1> listDataset1 = FXCollections.observableArrayList();
    ObservableList<CreateInstructionDataSet2> listDataset2 = FXCollections.observableArrayList();
    public void BuilderDoc() throws SQLException {
        listDataset1.clear();

        InOutGUI enterData = new InOutGUI();
        enterData.GetDataset1();
        enterData.GetDataset2();

        workDataset1(enterData.DataSet1);
        workDataset2(enterData.DataSet2);
    }

        private void workDataset1(ResultSet dataSet1) throws SQLException {
        int x = dataSet1.getMetaData().getColumnCount();
        String a1="";
        String a2="";
        String a3="";
        String a4="";
        String a5="";
        String a6="";
        String a7="";
        int i2 =1;

        while(dataSet1.next()){

            for(int i=1; i<=x;i++){
                    switch (i2){
                        case 1 : if(dataSet1.getString(i)==null){
                            a1 = "null"; break;
                        } a1 = dataSet1.getString(i); break;

                        case 2 : if(dataSet1.getString(i)==null){
                            a2 = "null"; break;
                        } a2 = dataSet1.getString(i); break;
                        case 3 : if(dataSet1.getString(i)==null){
                            a3 = "null"; break;
                        }a3 = dataSet1.getString(i); break;
                        case 4 : if(dataSet1.getString(i)==null){
                            a4 = "null"; break;
                        }a4 = dataSet1.getString(i); break;
                        case 5 : if(dataSet1.getString(i)==null){
                            a5 = "null"; break;
                        } a5 = dataSet1.getString(i); break;
                        case 6 : if(dataSet1.getString(i)==null){
                            a6 = "null"; break;
                        } a6 = dataSet1.getString(i); break;
                        case 7 :if(dataSet1.getString(i)==null){
                            a7 = "null"; break;
                        } a7 = dataSet1.getString(i); break;
                        default: break;
                    }
                    i2++;
                    if(i2==8){
                        listDataset1.add(new CreateInstructionDataSet1(a1,a2,a3,a4,a5,a6,a7));
                        i2=1;
                    }
            }
        }
        //тест удалить
        //listDataset1.add(new CreateInstructionDataSet1("й1","ц2","у3","к4","е5","н6","г7"));
        //listDataset1.add(new CreateInstructionDataSet1("кукук1","кукукук2","кукуку3","екеке4","шлшлшлшл5","рпролорл6","аропро7"));

        Column1.setCellValueFactory(new PropertyValueFactory<>("id"));
        Column1.setCellFactory(TextFieldTableCell.forTableColumn());
        Column1.setOnEditCommit((CellEditEvent<CreateInstructionDataSet1,String> event) ->{
            TablePosition<CreateInstructionDataSet1,String> pos = event.getTablePosition();
            String newId = event.getNewValue();
            int row = pos.getRow();
            CreateInstructionDataSet1 dataset1 = event.getTableView().getItems().get(row);
            dataset1.setId(newId);
            System.out.println("внитри метода в пемеренной dataset1.getId() сохраняется это --" + dataset1.getId());
        });
        Column2.setCellValueFactory(new PropertyValueFactory<>("author"));
        Column2.setCellFactory(TextFieldTableCell.forTableColumn());
        Column2.setOnEditCommit((CellEditEvent<CreateInstructionDataSet1,String> event) ->{
            TablePosition<CreateInstructionDataSet1,String> pos = event.getTablePosition();
            String newAuthor = event.getNewValue();
            int row = pos.getRow();
            CreateInstructionDataSet1 dataset1 = event.getTableView().getItems().get(row);
            dataset1.setAuthor(newAuthor);
        });
        Column3.setCellValueFactory(new PropertyValueFactory<>("name"));
        Column3.setCellFactory(TextFieldTableCell.forTableColumn());
        Column3.setOnEditCommit((CellEditEvent<CreateInstructionDataSet1,String> event) ->{
            TablePosition<CreateInstructionDataSet1,String> pos = event.getTablePosition();
            String newName = event.getNewValue();
            int row = pos.getRow();
            CreateInstructionDataSet1 dataset1 = event.getTableView().getItems().get(row);
            dataset1.setName(newName);
        });
        Column4.setCellValueFactory(new PropertyValueFactory<>("can"));
        Column4.setCellFactory(TextFieldTableCell.forTableColumn());
        Column4.setOnEditCommit((CellEditEvent<CreateInstructionDataSet1,String> event) ->{
            TablePosition<CreateInstructionDataSet1,String> pos = event.getTablePosition();
            String newCan = event.getNewValue();
            int row = pos.getRow();
            CreateInstructionDataSet1 dataset1 = event.getTableView().getItems().get(row);
            dataset1.setCan(newCan);
        });
        Column5.setCellValueFactory(new PropertyValueFactory<>("feh"));
        Column5.setCellFactory(TextFieldTableCell.forTableColumn());
        Column5.setOnEditCommit((CellEditEvent<CreateInstructionDataSet1,String> event) ->{
            TablePosition<CreateInstructionDataSet1,String> pos = event.getTablePosition();
            String newFeh = event.getNewValue();
            int row = pos.getRow();
            CreateInstructionDataSet1 dataset1 = event.getTableView().getItems().get(row);
            dataset1.setFeh(newFeh);
        });
        Column6.setCellValueFactory(new PropertyValueFactory<>("disp"));
        Column6.setCellFactory(TextFieldTableCell.forTableColumn());
        Column6.setOnEditCommit((CellEditEvent<CreateInstructionDataSet1,String> event) ->{
            TablePosition<CreateInstructionDataSet1,String> pos = event.getTablePosition();
            String newDisp = event.getNewValue();
            int row = pos.getRow();
            CreateInstructionDataSet1 dataset1 = event.getTableView().getItems().get(row);
            dataset1.setDisp(newDisp);
        });
        Column7.setCellValueFactory(new PropertyValueFactory<>("rank"));
        Column7.setCellFactory(TextFieldTableCell.forTableColumn());
        Column7.setOnEditCommit((CellEditEvent<CreateInstructionDataSet1,String> event) ->{
            TablePosition<CreateInstructionDataSet1,String> pos = event.getTablePosition();
            String newRank = event.getNewValue();
            int row = pos.getRow();
            CreateInstructionDataSet1 dataset1 = event.getTableView().getItems().get(row);
            dataset1.setRank(newRank);
        });
        tableVeiw.setItems(listDataset1);

        System.out.println("внитри метода createDoc в переменной listDataset1 сохраняется  --" + listDataset1.get(0).getId());

    }

    private void workDataset2(ResultSet dataSet2) throws SQLException {
        int x = dataSet2.getMetaData().getColumnCount();
        String a1="";
        String a2="";
        String a3="";
        String a4="";
        String a5="";
        String a6="";

        int i2 =1;

        while(dataSet2.next()){

            for(int i=1; i<=x;i++){
                switch (i2){
                    case 1 : if(dataSet2.getString(i)==null){
                        a1 = "null"; break;
                    } a1 = dataSet2.getString(i); break;

                    case 2 : if(dataSet2.getString(i)==null){
                        a2 = "null"; break;
                    } a2 = dataSet2.getString(i); break;
                    case 3 : if(dataSet2.getString(i)==null){
                        a3 = "null"; break;
                    }a3 = dataSet2.getString(i); break;
                    case 4 : if(dataSet2.getString(i)==null){
                        a4 = "null"; break;
                    }a4 = dataSet2.getString(i); break;
                    case 5 : if(dataSet2.getString(i)==null){
                        a5 = "null"; break;
                    } a5 = dataSet2.getString(i); break;
                    case 6 : if(dataSet2.getString(i)==null){
                        a6 = "null"; break;
                    } a6 = dataSet2.getString(i); break;
                    default: break;
                }
                i2++;
                if(i2==7){
                    listDataset2.add(new CreateInstructionDataSet2(a1,a2,a3,a4,a5,a6));
                    i2=1;
                }
            }
        }
        //тест удалить
        //listDataset1.add(new CreateInstructionDataSet1("й1","ц2","у3","к4","е5","н6","г7"));
        //listDataset1.add(new CreateInstructionDataSet1("кукук1","кукукук2","кукуку3","екеке4","шлшлшлшл5","рпролорл6","аропро7"));
        tableVeiw2_Column1.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableVeiw2_Column1.setCellFactory(TextFieldTableCell.forTableColumn());
        tableVeiw2_Column1.setOnEditCommit((CellEditEvent<CreateInstructionDataSet2,String> event) ->{
            TablePosition<CreateInstructionDataSet2,String> pos = event.getTablePosition();
            String newId = event.getNewValue();
            int row = pos.getRow();
            CreateInstructionDataSet2 dataset2 = event.getTableView().getItems().get(row);
            dataset2.setId(newId);
            System.out.println("внитри метода в пемеренной dataset2.getId() сохраняется это --" + dataset2.getId());
        });
        tableVeiw2_Column2.setCellValueFactory(new PropertyValueFactory<>("doc_id"));
        tableVeiw2_Column2.setCellFactory(TextFieldTableCell.forTableColumn());
        tableVeiw2_Column2.setOnEditCommit((CellEditEvent<CreateInstructionDataSet2,String> event) ->{
            TablePosition<CreateInstructionDataSet2,String> pos = event.getTablePosition();
            String newDoc_id = event.getNewValue();
            int row = pos.getRow();
            CreateInstructionDataSet2 dataset2 = event.getTableView().getItems().get(row);
            dataset2.setDoc_id(newDoc_id);
        });

        tableVeiw2_Column3.setCellValueFactory(new PropertyValueFactory<>("lem_num"));
        tableVeiw2_Column3.setCellFactory(TextFieldTableCell.forTableColumn());
        tableVeiw2_Column3.setOnEditCommit((CellEditEvent<CreateInstructionDataSet2,String> event) ->{
            TablePosition<CreateInstructionDataSet2,String> pos = event.getTablePosition();
            String newlem_num = event.getNewValue();
            int row = pos.getRow();
            CreateInstructionDataSet2 dataset2 = event.getTableView().getItems().get(row);
            dataset2.setlem_num(newlem_num);
        });
        tableVeiw2_Column4.setCellValueFactory(new PropertyValueFactory<>("rank"));
        tableVeiw2_Column4.setCellFactory(TextFieldTableCell.forTableColumn());
        tableVeiw2_Column4.setOnEditCommit((CellEditEvent<CreateInstructionDataSet2,String> event) ->{
            TablePosition<CreateInstructionDataSet2,String> pos = event.getTablePosition();
            String newRank = event.getNewValue();
            int row = pos.getRow();
            CreateInstructionDataSet2 dataset2 = event.getTableView().getItems().get(row);
            dataset2.setRank(newRank);
        });
        tableVeiw2_Column5.setCellValueFactory(new PropertyValueFactory<>("disp"));
        tableVeiw2_Column5.setCellFactory(TextFieldTableCell.forTableColumn());
        tableVeiw2_Column5.setOnEditCommit((CellEditEvent<CreateInstructionDataSet2,String> event) ->{
            TablePosition<CreateInstructionDataSet2,String> pos = event.getTablePosition();
            String newDisp = event.getNewValue();
            int row = pos.getRow();
            CreateInstructionDataSet2 dataset2 = event.getTableView().getItems().get(row);
            dataset2.setDisp(newDisp);
        });
        tableVeiw2_Column6.setCellValueFactory(new PropertyValueFactory<>("picf"));
        tableVeiw2_Column6.setCellFactory(TextFieldTableCell.forTableColumn());
        tableVeiw2_Column6.setOnEditCommit((CellEditEvent<CreateInstructionDataSet2,String> event) ->{
            TablePosition<CreateInstructionDataSet2,String> pos = event.getTablePosition();
            String newPicf = event.getNewValue();
            int row = pos.getRow();
            CreateInstructionDataSet2 dataset2 = event.getTableView().getItems().get(row);
            dataset2.setRank(newPicf);
        });
        tableVeiw2.setItems(listDataset2);

        System.out.println("внитри метода createDoc в переменной listDataset2 сохраняется  --" + listDataset2.get(0).getId());

    }

    public void getCreateDoc(MouseEvent mouseEvent) throws SQLException {
        selectJobName = selectJob.getValue();
        BuilderDoc();
        //ResultDocument.setText(str);
    }
    public void getSaveDoc(MouseEvent mouseEvent) {
        //saveText = ResultDocument.getText();
        System.out.println("внитри метода saveDoc в пеменной listDataset1.get(0).getId()  сохраняется это --" + listDataset1.get(0).getId() );
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
