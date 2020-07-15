package main;

import backend.Card;
import backend.CardManager;
import backend.SearchEngine;
import javafx.application.Application;
import javafx.stage.Stage;
import saving.FileReader;

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
	public static final int resolutionX = 800;
	public static final int resolutionY = 700;
	
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
		
//		SearchEngine search = ne	w SearchEngine(FileReader.getLocalCardSets());
//		System.out.println(search);
//		System.out.println("\n\n\n");
//		
//		for(Card crd: search.findCards(""))
//		{
//			System.out.println(crd.getFront());
//		}
		
		//System.out.println(String.format("%s", 2.300010));
		//String str = "HEllO@# ";
		//String[] strarr = str.split("@#");
		//System.out.println(strarr.length);
//		String text = "1.1";
//		String[] nums = text.split("0.");
//		System.out.println(nums.length);
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
