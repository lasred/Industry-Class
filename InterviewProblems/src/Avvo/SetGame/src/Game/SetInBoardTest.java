package Game;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import Game.SetCard.CardNumber;
import Game.SetCard.CardColor;
import Game.SetCard.Shading;
import Game.SetCard.Shape;

public class SetInBoardTest {
	//ph - place holder, will not create any new sets
	private static final SetCard ph = null;
	//c - common
	private static final SetCard c1 = new SetCard(CardColor.RED, Shape.SQUIGGLE, Shading.SOLID, CardNumber.TWO);
	private static final SetCard c2 =  new SetCard(CardColor.PURPLE, Shape.OVAL, Shading.SOLID, CardNumber.THREE);
	private static final SetCard ifSet =  new SetCard(CardColor.GREEN, Shape.DIAMOND, Shading.SOLID, CardNumber.ONE);
	private static final SetCard noSet = new SetCard(CardColor.GREEN, Shape.SQUIGGLE, Shading.SOLID, CardNumber.ONE);

	@Test
	public void testSetInBoard() {
		SetCard[] testSequenceSetInBoard = {ph, c1, ph, ph, c2, ph, ifSet, ph,
				 ph, ph, ph, ph};
		List<SetCard> boardHasSet = Arrays.asList(testSequenceSetInBoard);
		Game setInInitialBoard = new Game(boardHasSet);
		Set<SetCard> set = setInInitialBoard.getSetInBoard();

		assertTrue(set.size()==3 && set.contains(c1) && set.contains(c2)
				 && set.contains(ifSet));
	}
	
	@Test 
	public void testNoSetInBoard()  {
		SetCard[] testSequenceNoSetInBoard = {ph, ph, c1, ph, c2, ph, ph, noSet,
				ph, ph, ph, ph};
		List<SetCard> boardHasNoSet = Arrays.asList(testSequenceNoSetInBoard);
		Game noSetInInitialBoard = new Game(boardHasNoSet);
		Set<SetCard> noSet = noSetInInitialBoard.getSetInBoard();
		assertNull(noSet);
	}
}
