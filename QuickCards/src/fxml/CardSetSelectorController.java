package fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import backend.Card;
import backend.CardManager;
import backend.CardSet;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import main.MainRunner;
import saving.FileReader;

public class CardSetSelectorController implements Initializable
{
	public FlowPane cardGrid;
	//testing
//	private List<CardSet> testCardSets;
//	private List<CardSet> localCards;
	
	private List<CardSet> cardSets;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		//createCardSet();
		//displayCardSets(testCardSets);
		MainRunner.setCardManager(new CardManager(FileReader.getLocalCardSets()));
		cardSets = MainRunner.getCardManager().getAllCardSets();
		displayCardSets(cardSets);
	}
	
	private void displayCardSets(List<CardSet> cardSet)
	{
		cardGrid.getChildren().removeAll();
		for(CardSet cardset: cardSet)
		{
			Button btn = new Button(cardset.getName());
			btn.setOnAction(event -> 
			{
				openCardSet(((Button)event.getSource()).getText());
			});
			cardGrid.getChildren().add(btn);
		}
	}
	
//	private void displayLocalCardSets(List<CardSet> cardSet)
//	{
//		localCardGrid.getChildren().removeAll();
//		for(CardSet cardset: cardSet)
//		{
//			Button btn = new Button(cardset.getName());
//			btn.setOnAction(event -> 
//			{
//				openLocalCardSet(((Button)event.getSource()).getText());
//			});
//			localCardGrid.getChildren().add(btn);
//		}
//	}
	
//	private void createCardSet()
//	{
//		testCardSets = new ArrayList<CardSet>();
//		
//		CardSet tempCards = new CardSet("Pre-K");
//		Card card1 = new Card("Apple" ,"A red fruit that is tasty");
//		Card card2 = new Card("Pear" ,"A yellow fruit that is tasty");
//		Card card3 = new Card("Lava" ,"Very hot rock");
//		Card card4 = new Card("Boat" ,"Something that floats on water");
//		
//		
//		tempCards.addCard(card1);
//		tempCards.addCard(card2);
//		tempCards.addCard(card3);
//		tempCards.addCard(card4);
//		
//		//System.out.println(card1.getExplanations());
//		CardSet tempCards2 = new CardSet("Middle School");
//		Card card5 = new Card("Determined" ,"Feeling motivated");
//		Card card6 = new Card("Dog" ,"A animal");
//		Card card7 = new Card("American Constitution" ,"A set of rules/laws for the American people");
//		Card card8 = new Card("Sponge Bob" ,"Something that floats on water");
//		
//		tempCards2.addCard(card5);
//		tempCards2.addCard(card6);
//		tempCards2.addCard(card7);
//		tempCards2.addCard(card8);
//		
//		CardSet tempCards3 = new CardSet("Computer Hardware");
//		Card card9 = new Card("RAM" ,"Random Access Memory");
//		Card card10 = new Card("SSD" ,"Solid State Drive");
//		Card card11 = new Card("HDD" ,"Hard Disk Drive");
//		Card card12 = new Card("USB" ,"Universal Serial Bus");
//		
//		tempCards3.addCard(card9);
//		tempCards3.addCard(card10);
//		tempCards3.addCard(card11);
//		tempCards3.addCard(card12);
//		
//		CardSet tempCards4 = new CardSet("Computer Software");
//		Card card13 = new Card("Operating system" ,"Software that controls a computers basic functions");
//		Card card14 = new Card("Microsoft Word" ,"A nice homework typing station.");
//		Card card15 = new Card("Candy Crush" ,"A game about linking candies.");
//		Card card16 = new Card("BIOS" ,"Basic Input Output System");
//		
//		tempCards4.addCard(card13);
//		tempCards4.addCard(card14);
//		tempCards4.addCard(card15);
//		tempCards4.addCard(card16);
//		
//		testCardSets.add(tempCards);
//		testCardSets.add(tempCards2);
//		testCardSets.add(tempCards3);
//		testCardSets.add(tempCards4);
//		
////		FileSaver.writeCardSetToFile(tempCards);
////		FileSaver.writeCardSetToFile(tempCards2);
////		FileSaver.writeCardSetToFile(tempCards3);
////		FileSaver.writeCardSetToFile(tempCards4);
//		
//		localCards = FileReader.getLocalCardSets();
//		//System.out.println(localCards);
//	}
	
	public void openCardSet(String name)
	{
		for(CardSet cs: cardSets)
		{
			if(name.equals(cs.getName()))
				MainRunner.currentCardSet = cs;
		}
		//System.out.println(name);
		MainRunner.getSceneSelector().switchToCardSetViewer();
	}
	
//	public void openLocalCardSet(String name)
//	{
//		MainRunner.localCardSet = localCards;
//		for(CardSet cs: localCards)
//		{
//			if(name.equals(cs.getName()))
//				MainRunner.currentCardSet = cs;
//		}
//		//System.out.println(name);
//		
//		try
//		{
//			MainRunner.getSceneSelector().switchToCardSetViewer();
//		} 
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//	}
}
