package fxml;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import main.MainRunner;

public class MainMenuController implements Initializable
{
	public BorderPane container;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		//container.setPrefHeight(MainRunner.resolutionX);
		//container.setPrefWidth(MainRunner.resolutionY);
		
	}
	public void loginOnClick()
	{
		//todo:add a login page
	}
	
	public void localCardsOnClick()
	{
		MainRunner.getSceneSelector().switchToCardSetSelector();
	}
	
	public void quitOnClick()
	{
		MainRunner.getSceneSelector().closeWindow();
		//Platform.exit()
	}

	
}
