package fxml;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import backend.CardSet;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import main.MainRunner;
import saving.FileReader;

public class CardSetCreater implements Initializable
{
	public TextField cardNameTxt;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		cardNameTxt.setPromptText("Enter a name");
	}
	
	public void createCardsetOnClick()
	{
		String cardsetName = cardNameTxt.getText();
		if(cardsetName != "")
		{
			List<String> names = FileReader.getAllFileNames();
			for(String name: names)
			{
				if(cardsetName.equals(name))
				{
					cardNameTxt.setText("");
					cardNameTxt.setPromptText("This name is already taken");
					return;
				}
			}
			MainRunner.getCardManager().addCardSetAndSave(new CardSet(cardsetName));
			cardNameTxt.setPromptText("Enter a name");
			cardNameTxt.setText("");
		}
	}
	
	public void backBtnOnClick()
	{
		MainRunner.getSceneSelector().switchToCardSetSelector();
	}
}
