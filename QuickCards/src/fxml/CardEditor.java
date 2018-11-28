package fxml;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import backend.Card;
import backend.CardSet;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.MainRunner;
import saving.FileSaver;

public class CardEditor implements Initializable
{
	public TextField frontSideTxt;
	public TextArea backSideTxt;
	private Card currentCard;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		//Use the selected card to build the GUI.
		currentCard = MainRunner.getCardManager().getCurrentCard();
		frontSideTxt.setText(currentCard.getFront());
		backSideTxt.setText(currentCard.getStringback());
	}
	
	/**
	 * when the user is finished with editing the card, 
	 * save the new card.
	 */
	public void saveOnclick()
	{
		currentCard.setFront(frontSideTxt.getText());
		List<String> temp = new ArrayList<String>();
		temp.add(backSideTxt.getText());
		currentCard.setBack(temp);
		FileSaver.writeCardSetToFile(MainRunner.getCardManager().getCurrentCardSet());
	}
	
	public void backBtnOnclick()
	{
		MainRunner.getSceneSelector().switchToCardSetViewer();
	}
}
