package Game;

import static org.junit.Assert.*;

import org.junit.Test;

import Game.SetCard.CardNumber;
import Game.SetCard.CardColor;
import Game.SetCard.Shading;
import Game.SetCard.Shape;

public class GameTest {
	private static final SetCard placeHolder = new SetCard(CardColor.PURPLE, Shape.DIAMOND, Shading.EMPTY, CardNumber.ONE);
	private static final SetCard common1 = new SetCard(CardColor.RED, Shape.SQUIGGLE, Shading.SOLID, CardNumber.ONE);
	private static final SetCard common2 =  new SetCard(CardColor.PURPLE, Shape.OVAL, Shading.SOLID, CardNumber.THREE);
	private static final SetCard ifSet =  new SetCard(CardColor.GREEN, Shape.DIAMOND, Shading.SOLID, CardNumber.ONE);
	

	@Test
	public void testSetInBoard() {
		
	}
	
	@Test 
	public void testNoSetInBoard() {
		
	}
}
