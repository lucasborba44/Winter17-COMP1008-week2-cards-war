package week2githubintegration;

/**
 *
 * @author Lucas
 */
public class Card {
    private String faceName, suit;
    private int faceValue;
    
    //this is a constructor, has to have the same name as the class
    public Card(String face, String suit, int value)
    {
        faceName = face;
        setSuit(suit);
        setValue(value);
    }
    
    /**
     * This method will validate if the suit is valid(hearts, diamonds, spades or clubs)
     */
    
    private void setSuit(String suit)
    {
        if (suit.equalsIgnoreCase("hearts") || suit.equalsIgnoreCase("diamonds")
                || suit.equalsIgnoreCase("spades") || suit.equalsIgnoreCase("clubs"))
        {
            this.suit = suit;
        }
        else
            throw new IllegalArgumentException("suit must be hearts, diamonds, clubs or spades");
    }
    /**
     * This will validate that the input is between 2-14 and set the card value accordingly
     * 
     */
    private void setValue(int value)
    {
        if(value <2 || value>14) 
          throw new IllegalArgumentException("card value must be 2-14 inclusive");  
        
        else
            faceValue = value;
    }
    
    /**
     * This method will return a String to represent the Card
     *  
     */
    @Override
    public String toString()
    {
        return faceName + " of " + suit;
    }

    public String getFaceName() {
        return faceName;
    }

    public String getSuit() {
        return suit;
    }

    public int getFaceValue() {
        return faceValue;
    }
    
    
}
