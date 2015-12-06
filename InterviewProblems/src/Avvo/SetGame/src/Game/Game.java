package Game;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Game {
	public static final int STARTING_BOARD_SIZE = 12;
	public static final int CARDS_TO_DRAW = 3;
	private List<SetCard> board;
	private Queue<SetCard> deck;
	private List<Set<SetCard>> allSetsFound;
	
	//Todo
	public Game(List<SetCard> deck) {
		this.deck = new LinkedList<SetCard>();
		board = new ArrayList<SetCard>();
		for(SetCard setCard: deck) {
			this.deck.add(setCard);
		}
		for(int i=0;i<STARTING_BOARD_SIZE;i++) {
			board.add(this.deck.remove());
		}
		//removal in middle of list is more efficient
		allSetsFound = new LinkedList<Set<SetCard>>();
	}
	
	private void takeTurn() {
		Set<SetCard> setInBoard = getSetInBoard();
		if(setInBoard == null) {
			for(int i=0;i<CARDS_TO_DRAW;i++) {
				board.add(deck.remove());
			}
		} else {
			for(SetCard card: setInBoard) {
				board.remove(card);
			}
			allSetsFound.add(setInBoard);
		}
	}
	
	/*
	 * Requirement method - Will return a set in the board or null if there is no set
	 */
	public Set<SetCard> getSetInBoard() {
		if(board != null){
			//brute force solution - must try all possibilities
			int size = board.size();
			for(int i=0;i<size - 2; i++) {
				for(int j = i + 1; j < size - 1; j++) {
					for(int l = j+1; l < size; l ++ ) {
						if(SetCard.isSet(board.get(i), board.get(j), board.get(l))) {
							Set<SetCard> setInBoard = new HashSet<SetCard>();
							setInBoard.add(board.get(i));
							setInBoard.add(board.get(j));
							setInBoard.add(board.get(l));
							return setInBoard;
						}
					}
				}
			}
		}
		return null;
	}
	
	/*
	 * Requirement method - Play the game of set, entirely from start to end and return a list
	 *  of each valid set removed from the board
	 */
	public List<Set<SetCard>> playGame() {
		while(!deck.isEmpty()) {
			takeTurn();
		}
		return allSetsFound;
	}
}
