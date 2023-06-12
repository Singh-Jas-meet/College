module com.example.lab1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.CurrencyConverter to javafx.fxml;
    exports com.example.CurrencyConverter;
}