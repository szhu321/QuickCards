package main;

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
		scene = new Scene(root, 800, 600);
		this.window.setScene(scene);
	}
	
	public void switchToMainMenu() throws Exception
	{
		root.getChildren().setAll((BorderPane)FXMLLoader.load(getClass().getResource("/fxml/MainMenu.fxml")));
	}
	
	public void switchToCardSetViewer() throws Exception
	{
		root.getChildren().setAll((BorderPane)FXMLLoader.load(getClass().getResource("/fxml/CardSetViewer.fxml")));
	}
	
	public void switchToCardSetSelector() throws Exception
	{
		root.getChildren().setAll((BorderPane)FXMLLoader.load(getClass().getResource("/fxml/CardSetSelector.fxml")));
	}
}
