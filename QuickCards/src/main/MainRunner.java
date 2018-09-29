package main;

import java.util.List;

import backend.CardSet;
import backend.CardManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainRunner extends Application
{
	private static Stage window;
	private static SceneChanger sceneChanger;
	
	//Testing variables
//	public static List<CardSet> testCardSet;
//	public static CardSet currentCardSet;
//	public static List<CardSet> localCardSet;
	
	//RealDeal
	private static CardManager cardManager;
	
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
		sceneChanger.switchToMainMenu();
		
		
		//root.getChildren().setAll((BorderPane)FXMLLoader.load(getClass().getResource("/fxml/MainMenu.fxml")));
		//BorderPane bp = (BorderPane)FXMLLoader.load(getClass().getResource("/fxml/CardSetSelector.fxml"));
		window.show();
		
		//String str = "HEllO@# ";
		//String[] strarr = str.split("@#");
		//System.out.println(strarr.length);
	}
	
	/**
	 * 
	 * @return Returns the static sceneChanger connected to the main runner.
	 */
	public static SceneChanger getSceneSelector()
	{
		return sceneChanger;
	}

	public static CardManager getCardManager()
	{
		return cardManager;
	}

	public static void setCardManager(CardManager cardManager)
	{
		MainRunner.cardManager = cardManager;
	}
}
