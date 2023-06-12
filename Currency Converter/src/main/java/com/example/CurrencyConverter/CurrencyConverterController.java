/*
This class defines the working of controller class for the currency converter. It does the following...
links the gui components from the fxml file.
initialize comboBox field values by overriding initialize method.
declares a method of type double that does the currency conversion process.
declares a mouse onClick event, which prints the result value in the second textField, which initially is disabled.
exception is also handled in the case user press convert button without entering any initial value
*/
package com.example.CurrencyConverter;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CurrencyConverterController implements Initializable {


    /* Initialize method populates the comboBox with field values using observableArrayList method in conjunction with
     * FXCollections method*/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        currInitial.setItems(FXCollections.observableArrayList("US Dollars", "Pound Sterling", "Indian Rupees", "Serbian Dinar", "Iranian Rial"));
        currFinal.setItems(FXCollections.observableArrayList("US Dollars", "Pound Sterling", "Indian Rupees", "Serbian Dinar", "Iranian Rial"));
    }

    /*
     *  conversionProcess is a mouseclick method associated with convert button, which enables
     * the second textField to show result of conversion(after converting it to a string)
     */
    @FXML
    void conversionProcess() {
        amountOutput.setDisable(false);
        amountOutput.setText(Double.toString(getResult()));
    }

    /*
     *  clearAll is a mouseclick method associated with the clear button, that resets each textField and comboBox
     * to default values or clear it for the next input
     */
    @FXML
    void clearAll() {
        amountInput.clear();
        amountOutput.clear();
        currInitial.getSelectionModel().clearSelection();
        currFinal.getSelectionModel().clearSelection();
        amountOutput.setDisable(true);

    }


    double convertedAmount; // This variable stores the converted value that will be printed onto the second textField.

    /*
    The method below holds the logic for currency conversion. It is done through hard coding.
    First it extracts value from first textField, and converts it into type double and stores in a variable named val.
    Then it declares 5 if/else statements to process conversion for each currency.
    Each if or else statement contains additional switch with 5 case+ default to handle conversion for that currency to
    other 4 currencies.
    each case/default updates the value of convertedAmount variable
     */
    double getResult() {
        try {
            double val = Double.parseDouble(amountInput.getText());
//      If initial currency is US Dollars
            if (currInitial.getValue().equals("US Dollars")) {
                switch (currFinal.getValue()) {
                    case "Pound Sterling" -> convertedAmount = val * 0.80;
                    case "Indian Rupees" -> convertedAmount = val * 82.38;
                    case "Serbian Dinar" -> convertedAmount = val * 108.09;
                    case "Iranian Rial" -> convertedAmount = val * 42255.00;
                    default -> convertedAmount = val;
                }

            }

//        If initial currency is Pound Sterling
            else if (currInitial.getValue().equals("Pound Sterling")) {

                switch (currFinal.getValue()) {
                    case "US Dollars" -> convertedAmount = val * 1.25;
                    case "Indian Rupees" -> convertedAmount = val * 102.88;
                    case "Serbian Dinar" -> convertedAmount = val * 135.02;
                    case "Iranian Rial" -> convertedAmount = val * 52771.42;
                    default -> convertedAmount = val;
                }
            }

//        If initial currency is Indian Rupees
            else if (currInitial.getValue().equals("Indian Rupees")) {

                switch (currFinal.getValue()) {
                    case "Pound Sterling" -> convertedAmount = val * 0.0097;
                    case "US Dollars" -> convertedAmount = val * 0.012;
                    case "Serbian Dinar" -> convertedAmount = val * 1.31;
                    case "Iranian Rial" -> convertedAmount = val * 512.94;
                    default -> convertedAmount = val;
                }

            }

//        If initial currency is Serbian Dinar
            else if (currInitial.getValue().equals("Serbian Dinar")) {

                switch (currFinal.getValue()) {
                    case "Pound Sterling" -> convertedAmount = val * 0.0074;
                    case "Indian Rupees" -> convertedAmount = val * 0.76;
                    case "US Dollars" -> convertedAmount = val * 0.0093;
                    case "Iranian Rial" -> convertedAmount = val * 390.88;
                    default -> convertedAmount = val;
                }

            }

//       This case will work for Iranian Rial
            else {

                switch (currFinal.getValue()) {
                    case "Pound Sterling" -> convertedAmount = val * 0.000019;
                    case "Indian Rupees" -> convertedAmount = val * 0.0019;
                    case "Serbian Dinar" -> convertedAmount = val * 0.0026;
                    case "US Dollars" -> convertedAmount = val * 0.000024;
                    default -> convertedAmount = val;
                }

            }
        } catch (IllegalArgumentException e) {
            hidden.setText("Empty field is not allowed!");
        }
        return convertedAmount;
    }


/* Below are FXML notations for the following GUI components.
Components used: 2 textField, 2 comboBox, 2 Buttons
 */

    //    ******************Text Fields********************
    // fxml notation for textField for user input
    @FXML
    private TextField amountInput;

    /*
    fxml notation for second textField which will show the output. It is initially set to be disabled
    to avoid complicating exception handling. But when convert button is pressed, it is enabled and shows
    the output
     */
    @FXML
    private TextField amountOutput;
//    *************************************************

//    *******************Buttons***********************

    //    fxml notation for button which triggers conversionMethodProcess

    //    ********************Combo Boxes********************
    /*
    fxml notation for two comboBoxes used for input/output currency.
    They both re set to have same 5 values: {"US Dollars", "Pound Sterling", "Indian Rupees", "Serbian Dinar", "Iranian Rial"}
    */
    @FXML
    private ComboBox<String> currFinal;

    @FXML
    private ComboBox<String> currInitial;
//    *****************************************************

    //    fxml notation for hidden label that becomes visible only when an exception is caught
    @FXML
    private Label hidden;
}
