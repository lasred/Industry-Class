package Game;

import static org.junit.Assert.*;

import org.junit.Test;

import Game.SetCard.CardColor;
import Game.SetCard.CardNumber;
import Game.SetCard.Shading;
import Game.SetCard.Shape;

public class GameTest {
	private static final SetCard ph = null;
	//c - common
	private static final SetCard c1 = new SetCard(CardColor.RED, Shape.SQUIGGLE, Shading.SOLID, CardNumber.TWO);
	private static final SetCard c2 =  new SetCard(CardColor.PURPLE, Shape.OVAL, Shading.SOLID, CardNumber.THREE);
	private static final SetCard c3 =  new SetCard(CardColor.GREEN, Shape.DIAMOND, Shading.SOLID, CardNumber.ONE);
	private static final SetCard c4 =  new SetCard(CardColor.GREEN, Shape.OVAL, Shading.STRIPED, CardNumber.ONE);
	private static final SetCard c5 =  new SetCard(CardColor.PURPLE, Shape.DIAMOND, Shading.EMPTY, CardNumber.THREE);

	//Todo
	@Test
	public void testGame() {
		//SetCard[] testSequence = {ph, ph, c1, ph, c2, c3, ph, ph, ph, c1, ph, ph, c4, ph, ph, c5};
		fail("Not yet implemented");
	}
	

}
