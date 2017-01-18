package week2githubintegration;

import java.util.ArrayList;

/**
 *
 * @author Lucas Borba 200352679
 */
public class GameOfWar {
   private ArrayList<Card> p1Hand;
   private ArrayList<Card> p2Hand;

   //constructor
   public GameOfWar()
   {
       p1Hand = new ArrayList<>();
       p2Hand = new ArrayList<>();
       
       DeckOfCards theDeck = new DeckOfCards();
       theDeck.shuffle();
       
       dealTheCards(theDeck);
   }//end of the constructor
   
   /**
    * This method will deal all the cards to the players
    */
   
   private void dealTheCards(DeckOfCards theDeck)
   {
       for(int cardNum=0; cardNum < 52; cardNum++)
       {              //remainer
           if(cardNum % 2 ==0)
               p1Hand.add(theDeck.dealTopCard());
           else
               p2Hand.add(theDeck.dealTopCard());
       }
   }
}
