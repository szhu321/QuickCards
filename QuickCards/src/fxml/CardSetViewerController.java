package fxml;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import backend.Card;
import backend.CardSet;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import main.MainRunner;

public class CardSetViewerController implements Initializable
{
	public Button next;
	public Button previous;
	public Text textBox;
	public HBox textBoxContainer;
	public Text cardCounterTxt;
	
	private CardSet cardSet;
	private int currentCardIdx;
	private boolean front;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		cardSet = MainRunner.getCardManager().getCurrentCardSet();
		currentCardIdx = 0;
		front = true;
		display();
	}
	
	public void flipCard()
	{
		if(front)
			front = false;
		else
			front = true;
		display();
	}
	
	public void next()
	{
		front = true;
		if(currentCardIdx + 1 <= cardSet.getCards().size() - 1)
			currentCardIdx++;
		display();
	}
	
	public void previous()
	{
		front = true;
		if(currentCardIdx > 0)
			currentCardIdx--;
		display();
	}
	
	public void addCardOnClick()
	{
		MainRunner.getSceneSelector().switchToCardCreater();
	}
	
	public void removeBtnOnClick()
	{
		MainRunner.getSceneSelector().switchToCardRemover();
	}
	
	/**
	 * If there is no cards the edit button wont work.
	 */
	public void editBtnOnclick()
	{
		if(cardSet.getCards().size() != 0)
			MainRunner.getSceneSelector().switchToCardEditor();
	}
	
	public void returnToSelector()
	{
		MainRunner.getSceneSelector().switchToCardSetSelector();
	}
	
	/**
	 * Displays the current card on screen.
	 */
	private void display()
	{
		if(cardSet.getCards().size() == 0)
		{
			String text = "";
			textBox.setText(text);
			cardCounterTxt.setText("0 / 0");
			MainRunner.getCardManager().setCurrentCard(null);
			return;
		}
		Card card = cardSet.getCards().get(currentCardIdx);
		//set the current card in card manager.
		MainRunner.getCardManager().setCurrentCard(card);
		String text = "";
		if(front)
		{
			text = card.getFront();
			textBoxContainer.setStyle("-fx-border-color: blue");
		}
		else
		{
			List<String> expl = card.getBack();
			for(int i = 0; i < expl.size(); i++)
			{
				if(i + 1 == expl.size())
					text += expl.get(i);
				else
					text += expl.get(i) + "\n";
			}
			textBoxContainer.setStyle("-fx-border-color: green");
		}
		textBox.setText(text);
		
		cardCounterTxt.setText(currentCardIdx + 1 + " / " + cardSet.getCards().size());
	}
}
