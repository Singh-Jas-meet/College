module com.example.lab2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.StudentOrganizer to javafx.fxml;
    exports com.example.StudentOrganizer;
}