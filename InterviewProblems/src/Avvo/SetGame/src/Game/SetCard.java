package Game;
import java.util.HashSet;
import java.util.Set;

/*
 * Represents a card in the Set card game.
 */
public class SetCard{
	public enum CardColor {
		RED, GREEN, PURPLE; 
	}
	
	public enum Shape {
	    DIAMOND, SQUIGGLE, OVAL;
	}
	
	public enum Shading {
		SOLID, EMPTY, STRIPED;
	}
	   
	public enum CardNumber {
	     ONE, TWO, THREE;
	} 
	
	 CardColor CardColor;
     Shape shape;
     Shading shading;
     CardNumber number;
     
     public SetCard(CardColor CardColor, Shape shape, Shading shading, CardNumber number) {
    	this.CardColor = CardColor;
    	this.shape = shape;
    	this.shading = shading;
    	this.number = number;
     }
     
	 static boolean isSet(SetCard one, SetCard two, SetCard three) {
		 if(one == null || two == null || three == null) {
			 return false;
		 }
	     Set<CardColor> CardColors = new HashSet<CardColor>();
	     Set<Shape> shapes = new HashSet<Shape>();
	     Set<Shading> shadings = new HashSet<Shading>();
	     Set<CardNumber> numbers = new HashSet<CardNumber>();
	     SetCard[] toProcess = {one, two, three};
	     for(SetCard card: toProcess) {
	       CardColors.add(card.CardColor);
	       shapes.add(card.shape);
	       shadings.add(card.shading);
	       numbers.add(card.number);
	     }
	     //this is the fail case bc otherwise the set will have 1 or all unique elements which qualifies the set requirement
	     return CardColors.size() != 2 && shapes.size() != 2 && numbers.size() != 2 && shadings.size() != 2;
	   }
}
