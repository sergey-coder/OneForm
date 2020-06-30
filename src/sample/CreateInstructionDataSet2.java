package sample;

import javafx.beans.property.SimpleStringProperty;

public class CreateInstructionDataSet2 {


    private SimpleStringProperty id;

    private SimpleStringProperty doc_id;

    private SimpleStringProperty lem_num;

    private SimpleStringProperty rank;

    private SimpleStringProperty disp;

    private SimpleStringProperty picf;



    public CreateInstructionDataSet2(String id, String doc_id, String lem_num, String rank, String disp, String picf) {
        this.id = new SimpleStringProperty(id);
        this.doc_id = new SimpleStringProperty(doc_id);
        this.lem_num = new SimpleStringProperty(lem_num);
        this.picf = new SimpleStringProperty(picf);
        this.disp = new SimpleStringProperty(disp);
        this.rank = new SimpleStringProperty(rank);
    }




    public String getId() {
        return id.get();
    }

    public void setId(String value) {
        id.set(value);
    }

    public String getDoc_id() {
        return doc_id.get();
    }

    public void setDoc_id(String value) {
        doc_id.set(value);
    }

    public String getlem_num() {
        return lem_num.get();
    }

    public void setlem_num(String value) {
        lem_num.set(value);
    }

    public String getPicf() {
        return picf.get();
    }

    public void setPicf(String value) {
        picf.set(value);
    }

    public String getRank() {
        return rank.get();
    }

    public void setRank(String value) {
        rank.set(value);
    }

    public String getDisp() {
        return disp.get();
    }

    public void setDisp(String value) {
        disp.set(value);
    }

}
