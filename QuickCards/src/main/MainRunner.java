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

public class MainRunner extends Application
{
	public static Stage window;
	public static Scene scene;
	private Group root;
	
	private List<CardSet> testCardSets = new ArrayList<CardSet>();
	
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
		root.getChildren().setAll((BorderPane)FXMLLoader.load(getClass().getResource("/fxml/MainMenu.fxml")));
		
		window.setScene(scene);
		window.show();
	}
	
	private void createCardSet()
	{
		CardSet tempCards = new CardSet("Pre-K");
		Card card1 = new Card("Apple" ,"A red fruit that is tasty");
		
	}
}
