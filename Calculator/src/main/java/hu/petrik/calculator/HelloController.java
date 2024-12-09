package hu.petrik.calculator;

import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

public class HelloController {

    @FXML
    private Button plusButton;
    @FXML
    private Button minusButton;
    @FXML
    private Button divisonButton;
    @FXML
    private GridPane Grid;
    @FXML
    private Button percentageButton;
    @FXML
    private Button multiplyButton;
    @FXML
    private Label outcome;
    @FXML
    private Spinner<Double> secondNumber;
    @FXML
    private Spinner<Double> firstNumber;

    public void initialize() {
        firstNumber.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(-1000, 1000, 0));
        secondNumber.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(-1000, 1000, 0));
        firstNumber.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                Double.parseDouble(newValue);
            } catch (NumberFormatException e) {
                firstNumber.getEditor().setText(oldValue);
            }
        });
        secondNumber.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                Double.parseDouble(newValue);
            } catch (NumberFormatException e) {
                secondNumber.getEditor().setText(oldValue);
            }
        });

    }


        @FXML
    public void plusClick(ActionEvent actionEvent) {
        double first = firstNumber.getValue();
        double second = secondNumber.getValue();
        double result = first + second;
        outcome.setText(String.valueOf(result));
    }

    @FXML
    public void percentageClick(ActionEvent actionEvent) {
        double first = firstNumber.getValue();
        double second = secondNumber.getValue();
        double result = (first / second) * 100;
        outcome.setText(String.valueOf(result));

    }

    @FXML
    public void minusClick(ActionEvent actionEvent) {
        double first = firstNumber.getValue();
        double second = secondNumber.getValue();
        double result = first - second;
        outcome.setText(String.valueOf(result));
    }

    @FXML
    public void divisonClick(ActionEvent actionEvent) {
        double first = firstNumber.getValue();
        double second = secondNumber.getValue();
        double result = Math.round((first / second*100))/100.0;
        outcome.setText(String.valueOf(result));
    }


    @FXML
    public void multiplyClick(ActionEvent actionEvent) {
        double first = firstNumber.getValue();
        double second = secondNumber.getValue();
        double result = first * second;
        outcome.setText(String.valueOf(result));
    }
}