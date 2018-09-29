package main;

import java.util.List;

import backend.CardSet;
import backend.CardStorage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainRunner extends Application
{
	private static Stage window;
	private static SceneChanger sceneChanger;
	
	//Testing variables
	public static List<CardSet> testCardSet;
	public static CardSet currentCardSet;
	public static List<CardSet> localCardSet;
	
	//RealDeal
	public static CardStorage cardStorage;
	
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
		sceneChanger = new SceneChanger(window);
		sceneChanger.switchToCardSetSelector();
		
		
		//root.getChildren().setAll((BorderPane)FXMLLoader.load(getClass().getResource("/fxml/MainMenu.fxml")));
		//BorderPane bp = (BorderPane)FXMLLoader.load(getClass().getResource("/fxml/CardSetSelector.fxml"));
		window.show();
		
		//String str = "HEllO@# ";
		//String[] strarr = str.split("@#");
		//System.out.println(strarr.length);
	}
	
	public static SceneChanger getSceneSelector()
	{
		return sceneChanger;
	}
}
