package controller;
import javafx.collections.FXCollections;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.*;
import application.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.ResourceBundle;
public class HistoryController{
	

	private Main main;
	private ObservableList<History>list;
	
	
	
	@FXML
	private DatePicker secondPicker;
	@FXML
	private DatePicker datesPicker;
	@FXML
	private TableView<History> table;
	@FXML
	private TableColumn<History,LocalDate> date;
	@FXML
	private TableColumn<History,String> reason;
	@FXML
	private TableColumn<History,String> amount;
	@FXML
	private TableColumn<History,Integer> movement;
	private ObservableList<History> checker=FXCollections.observableArrayList();
	
	public void getDate(ActionEvent event) {
		LocalDate firstDate = datesPicker.getValue();
	}
	public void getDateSecond(ActionEvent event) {
		LocalDate secondDate = secondPicker.getValue();
	}
	
	public void getDateSingle(ActionEvent event) {
		LocalDate myDate = datesPicker.getValue();
		for(int i=0; i<list.size();i++) {
			if(main.returnList().get(i).getDate().equals(myDate)) {
				checker.add(main.returnList().get(i));
			}
		}
		table.setItems(checker);
		
	}
	public void getDateRange() {
		LocalDate firstDate = datesPicker.getValue();
		LocalDate secondDate = secondPicker.getValue();
		for(int i=0; i<list.size();i++) {
			if(firstDate.getYear()<=main.returnList().get(i).getDate().getYear()&&secondDate.getYear()>=main.returnList().get(i).getDate().getYear()&&firstDate.getDayOfYear()<=main.returnList().get(i).getDate().getDayOfYear()&&secondDate.getDayOfYear()>=main.returnList().get(i).getDate().getDayOfYear()) {
				checker.add(main.returnList().get(i));
			}
		}
		table.setItems(checker);
	}
	public void reset() {
		table.setItems(list);
	}
	public void returnMain() {
		main.showMain();
	}
	public void setMain(Main main) {
		this.main=main;
	}
	public void removeOperation() {
		History operation = table.getSelectionModel().getSelectedItem();
		main.removeOperation(operation);
		table.setItems(list=FXCollections.observableArrayList(main.returnList()));
	}
	public void initialOList() {
		date.setCellValueFactory(new PropertyValueFactory<History, LocalDate>("date"));
		reason.setCellValueFactory(new PropertyValueFactory<History,String>("reason"));
		amount.setCellValueFactory(new PropertyValueFactory<History,String>("amount"));
		movement.setCellValueFactory(new PropertyValueFactory<History,Integer>("movement"));
		
		
		table.setItems(list=FXCollections.observableArrayList(main.returnList()));
	}
	
	
	
}
	
