package controller;
import java.io.IOException;

import Exception.NotANumberEntryException;
import application.Main;
import model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class IncomeAndOutComeController {

	public Main main;	
	@FXML
	private TextField amount;
	@FXML
	private TextField feedback;
	@FXML
	private Label currentAmount;
	
	public void setMain(Main main) {
		this.main=main;
	}
	
	public void calculateIncomes() {
		try {
			main.calculator.calculateIncome(amount.getText(), feedback.getText());
			currentAmount.setText(main.calculator.getBaseAmountString());
		}catch(NotANumberEntryException e) {
			main.showAdvice();
			e.printStackTrace();
		}
	}
	public void calculateOutcomes() {
		try {
			main.calculator.calculateOutcome(amount.getText(), feedback.getText());
		} catch (NotANumberEntryException e) {
			main.showAdvice();
			e.printStackTrace();
		}
		currentAmount.setText(main.calculator.getBaseAmountString());
	}
	public void openHistory() {
		main.showHistory();
	}
	public void initialTxt() {
		currentAmount.setText(main.getBaseAmountString());
	}
	@FXML
	public void initialize() {
		
	}
	
}
