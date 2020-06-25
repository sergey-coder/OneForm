package sample;

import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class CreatTextField {
    public TextField TF10;
    public TextField TF11;
    public TextField TF12;
    public TextField TF13;
    public TextField TF14;
    public TextField TF15;
    private List<TextField> listTF = new ArrayList<TextField>();



    public List<TextField> getListTF(){
        return this.listTF;
    }

    public void addTF(){
        if(listTF.isEmpty()) {
            listTF.add(TF10);
            listTF.add(TF11);
            listTF.add(TF12);
            listTF.add(TF13);
            listTF.add(TF14);
            listTF.add(TF15);
        }
    }
}
