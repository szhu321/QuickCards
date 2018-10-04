package fxml;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import main.MainRunner;

public class CardSetCreater implements Initializable
{
	public TextField cardNameTxt;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		
	}
	
	public void createCardsetOnClick()
	{
		
	}
	
	public void backBtnOnClick()
	{
		MainRunner.getSceneSelector().switchToCardSetSelector();
	}
}
