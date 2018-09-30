package fxml;

import java.net.URL;
import java.util.ResourceBundle;

import backend.Card;
import backend.CardSet;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import main.MainRunner;
import saving.FileSaver;

public class CardCreaterController implements Initializable
{
	public TextField frontSideTxt;
	public TextField backSideTxt;
	public TextField cardSetTxtBox;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		cardSetTxtBox.setText(MainRunner.getCardManager().getCurrentCardSet().getName());
	}
	
	public void addAndSaveOnClick()
	{
		Card tempCard = new Card();
		tempCard.setFront(frontSideTxt.getText());
		tempCard.addExplanation(backSideTxt.getText());
		frontSideTxt.setText("");
		backSideTxt.setText("");
		CardSet tempCardSet = null;
		for(CardSet cardsets: MainRunner.getCardManager().getAllCardSets())
		{
			if(cardsets.getName().equals(cardSetTxtBox.getText()))
				tempCardSet = cardsets;
		}
		if(tempCardSet != null)
			FileSaver.writeCardToCardSet(tempCardSet, tempCard);
		else
			System.out.println("tempCardSet is null");
	}
	
	public void exitToMainMenuOnClick()
	{
		MainRunner.getSceneSelector().switchToMainMenu();
	}
}
