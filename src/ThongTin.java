import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Observable;

public class ThongTin {

    public TextField txtFullName;
    public TextField txtEmail;
    public Text txtInfo;
    public ObservableList<Student> listStudent = FXCollections.observableArrayList();
    public ListView<Student> lv;
    public Student editStudent;

    public void submit(ActionEvent actionEvent) {
        String fn = txtFullName.getText();
        String em = txtEmail.getText();

        if (editStudent == null){
            Student s = new Student(fn,em);
            listStudent.add(s);
        }else {
//            editStudent.setFullName(fn);
//            editStudent.setEmail(fn);
            for (Student s : listStudent) {
                if (s.email.equals(editStudent.email) && s.fullName.equals(editStudent.fullName)) {
                    s.setFullName(fn);
                    s.setEmail(em);
                }
            }
        }

        lv.setItems(listStudent);
        lv.refresh();
        editStudent = null;
        clearInput();
//        String txt =txtInfo.getText();
//        txt +="\n==================";
//        txt += "\nFullName : "+fn+"\n"+"Email : "+em;
//        txtInfo.setText(txt);

//        Student s = new Student(fn,em);
//        listStudent.add(s);
//        String txt = "";
//        for (Student sv : listStudent){
//            txt += "\n===================\n"+sv.toString();
//        }


//        IStudent s = new IStudent() {
//            @Override
//            public void learn(int a) {
//            }
//        };
//            IStudent s1 = (a)-> {
//        };
//            s1.learn(5);
//        ArrayList<String> arrs = new ArrayList<>();
//        arrs.add("Hello");
//        arrs.add("Word");
//        arrs.stream().filter(s->!s.equals("a")).forEach(s->{
//            System.out.println(s);
//        });
    }
    void clearInput(){
        txtEmail.clear();
        txtFullName.clear();
    }

    public void edit(MouseEvent mouseEvent) {
         editStudent  = lv.getSelectionModel().getSelectedItem();
        txtFullName.setText(editStudent.getFullName());
        txtEmail.setText(editStudent.getEmail());
    }
}
