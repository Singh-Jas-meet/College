/*
This class is the main launching point of the program. It does the following...
creates an fxmlLoader object to load the fxml file containing the GUI structure.
sets a new scene of resolution w*h=600*255,and loads the fxml file into the scene.
sets the scene title, and sets scene as the stage
*/
package com.example.CurrencyConverter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// extending the class Application
public class MainApplication extends Application {

    //    declaring the start method which initializes the stage
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("guiStructure.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 255);
        stage.setTitle("Currency Converter");
        stage.setScene(scene);
        stage.show();
    }

    //    main method which declares the launch method
    public static void main(String[] args) {
        launch();
    }
}