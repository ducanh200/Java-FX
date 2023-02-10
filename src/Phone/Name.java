package Phone;

import javafx.scene.control.Button;

public class Name {
    String name;
    String phonenumber;
    Button edit;

    public Name(String name,String phonenumber) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.edit = new Button("Edit");
        this.edit.setOnAction((event)->{
            DanhBa.editDanhba = this;
            DanhBa.stFullName.setText(this.name);
            DanhBa.stPhoneNumber.setText(this.phonenumber);
        });
    }

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String toString(){
        return this.name + " : "+this.phonenumber;
    }
}
