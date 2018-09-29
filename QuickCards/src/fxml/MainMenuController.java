package fxml;

import main.MainRunner;

public class MainMenuController
{
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
