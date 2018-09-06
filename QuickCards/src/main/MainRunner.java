package main;

import java.util.ArrayList;
import java.util.List;

import backend.Card;
import backend.CardSet;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import saving.FileSaver;

public class MainRunner extends Application
{
	public static Stage window;
	public static Scene scene;
	public static Group root;
	
	//Testing variables
	public static List<CardSet> testCardSet;
	public static CardSet currentCardSet;
	
	//Launches the program. Launch calls the start method.
	public static void main(String[] args)
	{
		launch(args);
	}

	//the start of the program
	@Override
	public void start(Stage mainStage) throws Exception
	{
		window = mainStage;
		window.setTitle("QuickCards");
		
		root = new Group();
		
		scene = new Scene(root, 800, 600);
		//root.getChildren().setAll((BorderPane)FXMLLoader.load(getClass().getResource("/fxml/MainMenu.fxml")));
		BorderPane bp = (BorderPane)FXMLLoader.load(getClass().getResource("/fxml/MainMenu.fxml"));
		root.getChildren().add(bp);
		window.setScene(scene);
		window.show();
		
	}
	
	
}
