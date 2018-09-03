package fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import backend.Card;
import backend.CardSet;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import main.MainRunner;

public class MainMenuController implements Initializable
{
	public FlowPane cardGrid;
	private List<CardSet> testCardSets;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		createCardSet();
		displayCardSets(testCardSets);
	}
	
	private void displayCardSets(List<CardSet> cardSet)
	{
		cardGrid.getChildren().removeAll();
		for(CardSet cardset: testCardSets)
		{
			Button btn = new Button(cardset.getName());
			btn.setOnAction(event -> 
			{
				openCardSet(((Button)event.getSource()).getText());
			});
			cardGrid.getChildren().add(btn);
		}
	}
	
	private void createCardSet()
	{
		testCardSets = new ArrayList<CardSet>();
		
		CardSet tempCards = new CardSet("Pre-K");
		Card card1 = new Card("Apple" ,"A red fruit that is tasty");
		Card card2 = new Card("Pear" ,"A yellow fruit that is tasty");
		Card card3 = new Card("Lava" ,"Very hot rock");
		Card card4 = new Card("Boat" ,"Something that floats on water");
		
		
		tempCards.addCard(card1);
		tempCards.addCard(card2);
		tempCards.addCard(card3);
		tempCards.addCard(card4);
		
		System.out.println(card1.getExplanations());
		
		
		testCardSets.add(tempCards);
	}
	
	public void openCardSet(String name)
	{
		MainRunner.testCardSet = testCardSets;
		for(CardSet cs: testCardSets)
		{
			if(name.equals(cs.getName()))
				MainRunner.currentCardSet = cs;
		}
		System.out.println(name);
		
		try
		{
			MainRunner.root.getChildren().setAll((BorderPane)FXMLLoader.load(getClass().getResource("/fxml/CardSetViewer.fxml")));
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
