package fxml;

import java.net.URL;
import java.util.ResourceBundle;

import backend.Card;
import backend.CardSet;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import main.MainRunner;

public class CardSetViewerController implements Initializable
{
	public Button next;
	public Button previous;
	public Text textBox;
	
	private CardSet cardSet;
	private int currentCardIdx;
	private boolean front;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		cardSet = MainRunner.currentCardSet;
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
	
	private void display()
	{
		Card card = cardSet.getCards().get(currentCardIdx);
		String text = "";
		if(front)
			text = card.getName();
		else
		{
			for(String str: card.getDescriptions())
			{
				text += str + "\n";
			}
		}
			
		textBox.setText(text);
	}
}
