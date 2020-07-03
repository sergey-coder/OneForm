package sample;

import javafx.beans.property.SimpleStringProperty;

public class CreateInstructionDataSet1 {

    private SimpleStringProperty id;

    private SimpleStringProperty author;

    private SimpleStringProperty name;

    private SimpleStringProperty can;

    private SimpleStringProperty feh;

    private SimpleStringProperty disp;

    private SimpleStringProperty rank;

    public CreateInstructionDataSet1(String id,String author, String name, String can, String feh, String disp, String rank) {
        this.id = new SimpleStringProperty(id);
        this.author = new SimpleStringProperty(author);
        this.name = new SimpleStringProperty(name);
        this.can = new SimpleStringProperty(can);
        this.feh = new SimpleStringProperty(feh);
        this.disp = new SimpleStringProperty(disp);
        this.rank = new SimpleStringProperty(rank);
    }




    public String getId() {
        return id.get();
    }

    public void setId(String value) {
        id.set(value);
    }

    public String getAuthor() {
        return author.get();
    }

    public void setAuthor(String value) {
         author.set(value);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String value) {
        name.set(value);
    }

    public String getCan() {
        return can.get();
    }

    public void setCan(String value) {
        can.set(value);
    }

    public String getFeh() {
        return feh.get();
    }

    public void setFeh(String value) {
        feh.set(value);
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
