package fxml;

import java.net.URL;
import java.util.ResourceBundle;

import backend.Card;
import backend.CardSet;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.MainRunner;
import saving.FileSaver;

public class CardCreaterController implements Initializable
{
	public TextField frontSideTxt;
	public TextArea backSideTxt;
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
		if(frontSideTxt.getText().equals(""))
			return;
		tempCard.addExplanation(backSideTxt.getText());
		//System.out.print("BACK ADDING:" + backSideTxt.getText() + "hello");
		frontSideTxt.setText("");
		backSideTxt.setText("");
		CardSet tempCardSet = null;
		for(CardSet cardsets: MainRunner.getCardManager().getAllCardSets())
		{
			if(cardsets.getName().equals(cardSetTxtBox.getText()))
				tempCardSet = cardsets;
		}
		if(tempCardSet != null)
		{
			FileSaver.writeCardToCardSet(tempCardSet, tempCard);
			tempCardSet.addCard(tempCard);
		}
		else
			System.out.println("tempCardSet is null");
	}
	
	public void backBtnOnClick()
	{
		MainRunner.getSceneSelector().switchToCardSetViewer();
	}
}
