package doublylinkedlist;


/**
 * Represents a sorted doubly linked list.
 * @author Letian Sun
 * @version 1/17/2015
 * @param <Type> can be any object type the is Comparable or extends Comparable
 */
public class LinkedDListSorted<Type extends Comparable<Type>> extends AbstractDLinkedMyList<Type> {
	
	/**
	 * Return the index of an element in the list.
	 * @param value the element to return index of.
	 * @return the index of the element in the list.
	 */
	@Override
	public int getIndex(Type value) {
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
			//Optimization 
			if(fromBegin.data.compareTo(value) > 0 || fromEnd.data.compareTo(value) <0){
				return -1;
			} else if(fromBegin.data.equals(value)) {
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
			return fromBegin.data.equals(value)?startIndex:-1;
		} else {
			 // Know from Begin.next == fromEnd
			if(fromBegin.data.equals(value)) {
				return startIndex;
			} else if(fromEnd.data.equals(value)) {
				return endIndex;
			} else {
				return -1;
			}
		}
	}
	
	/**
	 * Inserts a value into the front of the sorted linked list.
	 * @param value - element to insert into the front.
	 * @throws IllegalArgumentException if inserting value as the front would 
	 * break sorted property of the list
	 */
	@Override
	public void insertFront(Type value) {
		if(front!= null && front.data.compareTo(value) < 0) {
			throwSortException();
		} else {
			super.insertFront(value);
		}
	}
	
	/**
	 * Will throw a IllegalArgumentException that states that doing this operation will break the 
	 * sorted property of the list
	 * @throws IllegalArgumentException - doing this operation will break list's sorted property.
	 */
	private void throwSortException() {
		throw new IllegalArgumentException("Cannot set here, would break sorted property of list");
	}
	
	/**
	 * Set the element at the given index as value
	 * @param index the index to set value at
	 * @param value what to set element at the given index as
	 * @see mylistpackage.MyList#set(int, Object)
	 * @throws IllegalArugmentException if setting that value at that index would break the sorted
	 * property of the list
	 * @throws IndexOutOfBoundsException if index < 0 or index >= size
	 */
	@Override
	public void set(int index, Type value) {
		if(index == 0 && front.next != null &&  value.compareTo(front.next.data) > 0) { 
			throwSortException();
		}
		if(index > 0) {
			ListNode<Type> before = nodeAt(index - 1);
			ListNode<Type> after = before.next.next;
			if(value.compareTo(before.data) < 0 || (after != null && value.compareTo(after.data) > 0)) {
				throwSortException();
			} 
		}
		//if you make it past all these tests	
		super.set(index, value);
	}
	
	/**
	 * Insert an element at a particular element in the list
	 * @param index the index to insert the element at, if inserted, must maintain sorted property 
	 * of the linked list, throw IllegalArgumentException if not
	 * @param value the value to insert at that index
	 * @throws IllegalArugmentException if inserting that value at that index would break the sorted
	 * property of the list
	 * @throws IndexOutOfBoundsException if 0 < index > size
	 */
	@Override
	public void insertAtIndex(int index, Type value) {
		if(index == 0 && front != null && value.compareTo(front.data) > 0) {
			throwSortException();
		} 
		if(index == size && value.compareTo(back.data) < 0) {
			throwSortException();
		} 
		if(index > 0 && index < size) {
			ListNode<Type> before = nodeAt(index - 1);
			if(value.compareTo(before.data) < 0 || value.compareTo(before.next.data) > 0) {
				throwSortException();
			}
		}
		//take advantage of code reuse
		super.insertAtIndex(index, value);
	}
	
	/**
	 * Insert an element into the correct position in the sorted array 
	 * @see mylistpackage.MyList#insert(Object)
	 * @param value the element to insert
	 */
	@Override
	public void insert(Type value) {
	   //front case
	   if(front == null || front.data.compareTo(value) >= 0) {
		   //logic that takes care of adjusting back
		   super.insertFront(value);
		    //back case, readjust back, know back is not null bc front is not null
	   } else {
		   size ++;
		   if(back.data.compareTo(value) <= 0) {
			   	back = new ListNode<Type>(value, null, back);
			   	back.previous.next = back;
		   } else {
			   //know at this point that the value is > front.data
			   //pointer from front
			   ListNode<Type> currentff = front;
			   //objective - optimize with back pointer
			   ListNode<Type> currentfb = back;
			   boolean hasInserted = false;
			   //keep going until we insert - we have to 
			   while(!hasInserted){
				   //check currentff's next
				   if(currentff.next.data.compareTo(value) >= 0) {
					   //insert new node from currentff
					   currentff.next = new ListNode<Type>(value, currentff.next, currentff);
					   currentff.next.next.previous = currentff.next;
					   hasInserted = true;
					}//check currentfb
				    else if(currentfb.previous.data.compareTo(value) <= 0) {
						//insert new node from back pointer
						currentfb.previous = new ListNode<Type>(value, currentfb, currentfb.previous);
						currentfb.previous.previous.next = currentfb.previous;
						hasInserted = true;
				    } else {
						   //iterate 
						   currentfb = currentfb.previous;
						   currentff = currentff.next;
					}
			   }
		   }
	   }


	}
}

