package Game;
import static org.junit.Assert.*;


import org.junit.Test;

import Game.SetCard.CardNumber;
import Game.SetCard.CardColor;
import Game.SetCard.Shading;
import Game.SetCard.Shape;



public class SetCardTest {
	//Given example
	@Test
	public void testValidSet() {
		SetCard card1 = new SetCard(CardColor.RED, Shape.SQUIGGLE, Shading.SOLID, CardNumber.TWO);
		SetCard card2 = new SetCard(CardColor.GREEN, Shape.DIAMOND, Shading.SOLID, CardNumber.ONE);
		SetCard card3 = new SetCard(CardColor.PURPLE, Shape.OVAL, Shading.SOLID, CardNumber.THREE);
		assertTrue(SetCard.isSet(card1, card2, card3));
	}
	
	@Test 
	public void testInvaldSets() {
		SetCard card1 = new SetCard(CardColor.RED, Shape.SQUIGGLE, Shading.SOLID, CardNumber.TWO);
		SetCard card2 = new SetCard(CardColor.GREEN, Shape.SQUIGGLE, Shading.SOLID, CardNumber.ONE);
		SetCard card3 = new SetCard(CardColor.PURPLE, Shape.OVAL, Shading.SOLID, CardNumber.THREE);
		assertFalse(SetCard.isSet(card1, card2, card3));
		assertFalse(SetCard.isSet(null, card2, card1));
		assertFalse(SetCard.isSet(null, null, null));
	}

}
