package application;
	
import javafx.application.Application;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.ArrayList;

import controller.*;
import model.*;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private Stage currentStage=new Stage();
	private Image icon = new Image("CHAD.jpg");
	
	public CalculateIncomesAndOutcomes calculator;
	@Override
	public void start(Stage primaryStage) {
		calculator= new CalculateIncomesAndOutcomes(0);
		try {
			
			currentStage.setTitle("Giga chad financial manager");
			showMain();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void showIntro() {
		VBox root;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/intro.fxml"));
			root = (VBox)loader.load();
			IntroController introController = loader.getController();
			introController.setMain(this);
			introController.play();
			Scene scene = new Scene(root,640,380);
			currentStage.setScene(scene);
			currentStage.getIcons().add(icon);
			currentStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void showMain() {
	
		try {
			VBox root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/incomeAndExpenses.fxml"));
			root = (VBox)loader.load();
			IncomeAndOutComeController controller = loader.getController();
			controller.setMain(this);
			controller.initialTxt();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("../ui/application.css").toExternalForm());
			currentStage.setScene(scene);
	
			currentStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void showHistory() {
		
		try {
			VBox root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/history.fxml"));
			root = (VBox)loader.load();
			HistoryController hc = loader.getController();
			hc.setMain(this);
			hc.initialOList();
			Scene scene = new Scene(root,500,600);
			currentStage.setScene(scene);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	
	}
	public void showAdvice() {
		VBox root;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/advice.fxml"));
		try {
			root = (VBox)loader.load();
			Scene scene = new Scene(root,800,300);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<History> returnList(){
		return calculator.returnList();
	}
	public static void main(String[] args) {
		launch(args);
	}
	public String getBaseAmountString() {
		return calculator.getBaseAmountString();
	}
	public void removeOperation(History operation) {
		calculator.removeOperation(operation);
	}
}
