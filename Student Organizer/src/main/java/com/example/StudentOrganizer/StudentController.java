/*
 * This the controller class for the GUI. It describes the GUI components, their initialization and any methods related to them
 *
 * */


package com.example.StudentOrganizer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;


public class StudentController implements Initializable {

    //    fxml notations for the GUI components
    @FXML
    private TableColumn<Student, Integer> firstCol;

    @FXML
    private TableColumn<Student, String> secondCol;

    @FXML
    private TableView<Student> studentCollection;

    @FXML
    private TextField studentId;

    @FXML
    private TextField studentMajor;

    @FXML
    private TextField studentName;

    @FXML
    private TableColumn<Student, String> thirdCol;

    /*This is an empty observable array list, which is created allow multiple students to be added on their
     * separated rows, instead of having just one working row. It is used in conjunction with another
     * observable array list, which is declared below to make this possible. */
    ObservableList<Student> toAdd;

    /*
    * The below method is triggered by the add button on the GUI.
    * What is does is...
    makes the tableView visible
    creates a new observable array list to store student id, name, and major
    * first it checks if the toADD observable list is empty(which initially always is). if this is true, second list is put equal
    * to this and this is added to the tableView using setItems method.
    * If, toADD is not empty, then second list elements are added to it which is then added to the tableView
    * */
    @FXML
    void joinStudent() {
        studentCollection.setVisible(true);
        ObservableList<Student> tempAdd = FXCollections.observableArrayList(
                new Student(Integer.parseInt(studentId.getText()),
                        studentName.getText(),
                        studentMajor.getText())
        );
        if (toAdd != null) {
            toAdd.addAll(tempAdd);
        } else {
            toAdd = tempAdd;
        }
        studentCollection.setItems(toAdd);
        studentId.clear();
        studentName.clear();
        studentMajor.clear();
    }

    /*
     * The action below deletes the data related to a row in the tableView. It is triggered by delete button on the GUI.
     * For that the user must first select the row, and then press the delete button in the GUI.*/
    @FXML
    void removeStudent() {
        toAdd.remove(studentCollection.getSelectionModel().getSelectedItem());
        if(toAdd.isEmpty()){
            studentCollection.setVisible(false);
        }
    }

    /*
     * Below method initializes the columns for tableView. Initially it's visibility is set to false because it stores no data.*/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentCollection.setVisible(false);
        firstCol.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        secondCol.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        thirdCol.setCellValueFactory(new PropertyValueFactory<>("studentMajor"));
    }


}
