package doublylinkedlist;

/**
 * Represents a unsorted doubly linked list 
 * @author Letian Sun
 * @version 1/19/2015
 * @param <Type> can be any object type
 */
public class LinkedDListUnsorted<Type> extends AbstractDLinkedMyList<Type>{
	
	/**
	 * Inserts an element into the unsorted doubly linked list
	 * @param value to insert into the list.
	 * @see mylistpackage.MyList#insert(java.lang.Object)
	 */
	@Override
	public void insert(Type value) {
		insertAtIndex(size, value);
	}
	
	/**
	 * Return the index of an element in the list.
	 * @param value the element to return index of.
	 * @see mylistpackage.MyList#getIndex(Object)
	 * @return the index of the element in the list, or -1 if the value is not in the list
	 */
	@Override
	public int getIndex(Type value) {
		 //The same as getIndex inside the unsorted doubly linked list but doesn't have optimization
		int startIndex = 0;
		int endIndex = size - 1;
		ListNode<Type> fromBegin = front;
		ListNode<Type> fromEnd = back;
		/*
		 * fromBegin!=fromEnd will work when list is of odd size
		 * however if list is odd, these pointers will never intersect, which 
		 * is why I also have fromBegin.next != fromEnd, to stop iteration
		 */
		while(fromBegin != fromEnd && fromBegin.next != fromEnd) {
			if(fromBegin.data.equals(value)) {
				return startIndex;
			} else if(fromEnd.data.equals(value)) {
				return endIndex;
			} else {
				//iteration
				startIndex ++;
				endIndex --;
				fromBegin = fromBegin.next;
				fromEnd = fromEnd.previous;
			}
		}
		if(fromBegin == fromEnd) {
			//both pointers are at the same value, this is the only possibility
			return fromBegin.data.equals(value)?startIndex:-1;
		} else {
			 // Know from Begin.next == fromEnd
			if(fromBegin.data.equals(value)) {
				return startIndex;
			} else if(fromEnd.data.equals(value)) {
				return endIndex;
			} else {
				//in the even case, two are one away from intersecting
				return -1;
			}
		}		
	}

	
}
