package Phone;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class DanhBa implements Initializable {

    public TextField FullName;
    public TextField PhoneNumber;
    public static TextField stFullName;
    public static TextField stPhoneNumber;

    public Name editName;
    public ObservableList<Name> listName = FXCollections.observableArrayList();
    public static Name editDanhba;
    public TableView<Name> tbview;
    public TableColumn<Name,String> cName;
    public TableColumn<Name,String> cPhoneNumber;
    public TableColumn<Name, Button> cView;


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

        tbview.setItems(listName);
        tbview.refresh();
        editName = null;
        clearInput();


    }
    void clearInput(){
        FullName.clear();
        PhoneNumber.clear();
    }
    public void name(MouseEvent mouseEvent){
//        editName = lv.getSelectionModel().getSelectedItem();
        FullName.setText(editName.getName());
        PhoneNumber.setText(editName.getPhonenumber());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        cPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        cView.setCellValueFactory(new PropertyValueFactory<>("Edit"));


        stFullName = FullName;
        stPhoneNumber = PhoneNumber;
    }
}
