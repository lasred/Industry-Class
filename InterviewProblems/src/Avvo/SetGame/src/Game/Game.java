package Game;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Game {
	/*
	 * Will return a board 
	 */
	public static Set<SetCard> getSetInBoard(List<SetCard> board) {
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
		return null;
	}
}
