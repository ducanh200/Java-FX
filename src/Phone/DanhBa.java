package Phone;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.awt.event.MouseEvent;

public class DanhBa {

    public TextField FullName;
    public TextField PhoneNumber;
    public ListView<Name> lv;
    public Name editName;
    public ObservableList<Name> listName = FXCollections.observableArrayList();


    public void Submit(ActionEvent actionEvent) {
        String na = FullName.getText();
        String ph = PhoneNumber.getText();

        if (editName == null){
            Name n = new Name(na,ph);
            listName.add(n);
        }else{
            for (Name n : listName){
                if (n.name.equals(editName.name) && n.phonenumber.equals(editName.phonenumber));
                n.setName(na);
                n.setPhonenumber(ph);
            }
        }

        lv.setItems(listName);
        lv.refresh();
        editName = null;
        clearInput();


    }
    void clearInput(){
        FullName.clear();
        PhoneNumber.clear();
    }
    public void name(MouseEvent mouseEvent){
        editName = lv.getSelectionModel().getSelectedItem();
        FullName.setText(editName.getName());
        PhoneNumber.setText(editName.getPhonenumber());
    }
}
