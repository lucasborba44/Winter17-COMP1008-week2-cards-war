package week2githubintegration;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Lucas
 */
public class DeckOfCards {
    private ArrayList<Card> deck;
    
    public DeckOfCards ()
    {
        deck= new ArrayList<>();
        String[] suits = {"hearts","clubs","spades","diamonds"};
        String[] faceNames = {"two","three","four","five","six","seven","eight","nine","ten","jack","queen","king","ace"};
        
        // passa cada valor de suit pra dentro de suit
        for(String suit: suits)
        {
         for(int i=0; i < faceNames.length; i++)
         {
             Card newCard = new Card(faceNames[i],suit, i+2);
             deck.add(newCard);
         }
        }
    }
    /**
     * This shuffles the deck of cards
     */
    public void shuffle()
    {
        Collections.shuffle(deck);
    }
    
    
    /**
     * This will return a Sting representing the eck of cards
     */
   
    @Override
    public String toString()
    {
        String deckString = "";
        for(Card card : deck)
        {
            deckString += card.toString() + "\n";
        }
        return deckString;
    }
    
    /**
     * This method will deal the top card off the deck
     */
    public Card dealTopCard ()
    {
        if (deck.size()>0)
            return deck.remove(0);
        else
            return null;
    }
}
