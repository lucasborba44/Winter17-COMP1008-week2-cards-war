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
   
   /**
    * This method will simulate playing the Game called War
    */
    public void playTheGame()
    {           //while p1 is not empty
        while(!p1Hand.isEmpty() && !p2Hand.isEmpty())
        {
            playHand();
        }
        
        if (p1Hand.isEmpty())
            System.out.println("Player 2 is the winner!");
        else
            System.out.println("Player 1 is the winner!");
    }
    
    /**
     * This method will simulate playing 1 hand at the game of war
     */
    private void playHand()
    {                        //remove the next card of the player's deck
        Card p1Card = p1Hand.remove(0);
        Card p2Card = p2Hand.remove(0);
        
        System.out.printf("Player 1 : %s cards in hand: %d",p1Card, p1Hand.size()+1);
        System.out.printf("\tPlayer 2 : %s cards in hand: %d%n",p2Card, p2Hand.size()+1);
        
        //player 1's card is higher thant player 2's card
        if(p1Card.getFaceValue()> p2Card.getFaceValue())
        {
            p1Hand.add(p1Card);
            p1Hand.add(p2Card);
        }
        // player 2's card is higher than player 1's
        else if (p2Card.getFaceValue()> p1Card.getFaceValue())
        {
            p2Hand.add(p1Card);
            p2Hand.add(p2Card);
        }
        //otherwise it's WAR
        else
        {
            ArrayList<Card> warPile = new ArrayList<>();
            warPile.add(p1Card);
            warPile.add(p2Card);
            playWarHand(warPile);
        }
    }//end of method playHand()
    
    /**
     * This method will simulate playing the war hand
     */
    private void playWarHand(ArrayList<Card> warPile)
    {   //check if player has enough cards
        if(p1Hand.size() < 3)
        {
            p2Hand.addAll(p1Hand);
            p1Hand.clear();
            p2Hand.addAll(warPile);
            return;
        }
        //check if player 2 has enough cards
         if(p2Hand.size() < 3)
        {
            p1Hand.addAll(p1Hand);
            p2Hand.clear();
            p1Hand.addAll(warPile);
            return;
        }
         //each player puts 2 cards on the pile and then prep's the 3rd card
         warPile.add(p1Hand.remove(0));
         warPile.add(p1Hand.remove(0));
         warPile.add(p2Hand.remove(0));
         warPile.add(p2Hand.remove(0));
         
         Card p1Card = p1Hand.remove(0);
         Card p2Card = p2Hand.remove(0);
         
         System.out.printf("%n%n ~~~~~~~~~~~~ WAR ~~~~~~~~~~~~%n");
         System.out.printf("Player 1 : %s cards in hand: %d",p1Card, p1Hand.size()+1);
        System.out.printf("\tPlayer 2 : %s cards in hand: %d%n",p2Card, p2Hand.size()+1);
         
         //if player 1 wins
         if(p1Card.getFaceValue() > p2Card.getFaceValue())
         {
             p1Hand.addAll(warPile);
             p1Hand.add(p1Card);
             p1Hand.add(p2Card);
         }
         //if player 2 wins
         if(p2Card.getFaceValue() > p1Card.getFaceValue())
         {
             p2Hand.addAll(warPile);
             p2Hand.add(p1Card);
             p2Hand.add(p2Card);
         }
         else
         {
             warPile.add(p1Card);
             warPile.add(p2Card);
             this.playWarHand(warPile);       
         }
     }// end of the method playWarHand
} //end of the class
