package Game;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	@Test
	public void testGame() {
		SetCard[] testSequence = {ph, ph, c1, ph, c2, c3, ph, ph, ph, c1, ph, ph, c4, ph, c5};	
		List<SetCard> testGameDeck = Arrays.asList(testSequence);
		Game testGame = new Game(testGameDeck);
		List<Set<SetCard>> allSets = testGame.playGame();
		SetCard[] expectedSetArray1 = {c1, c2, c3};
		Set<SetCard> expectedSet1 = new HashSet<SetCard>();
		for(SetCard setCard: expectedSetArray1) {
			expectedSet1.add(setCard);
		}
		SetCard[] expectedSetArray2 = {c1, c4, c5};
		Set<SetCard> expectedSet2 = new HashSet<SetCard>();
		for(SetCard setCard: expectedSetArray2) {
			expectedSet2.add(setCard);
		}
		assertTrue(allSets.size()==2&&allSets.contains(expectedSet1)&&allSets.contains(expectedSet2));
	}
	

}
