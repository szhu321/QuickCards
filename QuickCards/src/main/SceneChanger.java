package main;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SceneChanger
{
	private Scene scene;
	private Group root;
	private Stage window;
	
	public SceneChanger(Stage window)
	{
		this.window = window;
		root = new Group();
		scene = new Scene(root, MainRunner.resolutionX, MainRunner.resolutionY);
		this.window.setScene(scene);
	}
	
	public void closeWindow()
	{
		window.close();
	}
	
	public void switchToMainMenu()
	{
		try
		{
			root.getChildren().setAll((BorderPane)FXMLLoader.load(getClass().getResource("/fxml/MainMenu.fxml")));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void switchToCardSetViewer()
	{
		try
		{
			root.getChildren().setAll((BorderPane)FXMLLoader.load(getClass().getResource("/fxml/CardSetViewer.fxml")));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void switchToCardSetSelector()
	{
		try
		{
			root.getChildren().setAll((BorderPane)FXMLLoader.load(getClass().getResource("/fxml/CardSetSelector.fxml")));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void switchToCardCreater()
	{
		try
		{
			root.getChildren().setAll((BorderPane)FXMLLoader.load(getClass().getResource("/fxml/CardCreater.fxml")));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void switchToCardSetCreater()
	{
		try
		{
			root.getChildren().setAll((BorderPane)FXMLLoader.load(getClass().getResource("/fxml/CardSetCreater.fxml")));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void switchToCardRemover()
	{
		try
		{
			root.getChildren().setAll((BorderPane)FXMLLoader.load(getClass().getResource("/fxml/CardRemover.fxml")));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void switchToCardEditor()
	{
		try
		{
			root.getChildren().setAll((BorderPane)FXMLLoader.load(getClass().getResource("/fxml/CardEditor.fxml")));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
