package fxml;

import java.net.URL;
import java.util.ResourceBundle;

import backend.Card;
import backend.CardSet;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.MainRunner;
import saving.FileSaver;

public class CardRemoverController implements Initializable
{
	public VBox currentCardBox;
	public VBox removedCardBox;
	private CardSet currentCardSet;
	private CardSet removedCardSet;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{	
		currentCardSet = MainRunner.getCardManager().getCurrentCardSet();
		removedCardSet = new CardSet(currentCardSet.getName());
		display();
	}
	
	public void display()
	{
		currentCardBox.getChildren().clear();
		removedCardBox.getChildren().clear();
		int counter = 1;
		for(Card card: currentCardSet.getCards())
		{
			Text tempTxt = new Text(counter + ". " + card.getFront());
			tempTxt.setOnMouseClicked(event -> moveCurrentToRemoved(Integer.parseInt((((Text)event.getTarget()).getText().split(". "))[0]) - 1));
			currentCardBox.getChildren().add(tempTxt);
			counter++;
		}
		counter = 1;
		for(Card card: removedCardSet.getCards())
		{
			Text tempTxt = new Text(counter + ". " + card.getFront());
			tempTxt.setOnMouseClicked(event -> moveRemovedToCurrent(Integer.parseInt((((Text)event.getTarget()).getText().split(". "))[0]) - 1));
			removedCardBox.getChildren().add(tempTxt);
			counter++;
		}
	}
	
	private void moveRemovedToCurrent(int idx)
	{
		currentCardSet.addCard(removedCardSet.getCards().remove(idx));
		display();
	}
	
	private void moveCurrentToRemoved(int idx)
	{
		removedCardSet.addCard(currentCardSet.getCards().remove(idx));
		display();
	}
	
	public void backBtnOnclick()
	{
		MainRunner.getSceneSelector().switchToCardSetViewer();
	}
	
	public void removeBtnOnclick()
	{
		//todo: add the remove function to remove the selected cards.
		FileSaver.writeCardSetToFile(currentCardSet);
		removedCardSet = new CardSet(currentCardSet.getName());
		display();
	}
}
