package mysinglelinkedlist;



/**
 * Represents a sorted linked list.
 * @author Letian Sun
 * @version 1/17/2015
 * @param <E> can be any object type that is comparable
 */
public class LinkedListSorted<E extends Comparable<E>> extends AbstractLinkedMyList<E> {
	
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
	public void set(int index, E value) {
		if(index == 0 && front.next != null &&  value.compareTo(front.next.data) > 0) { 
			throwSortException();
		}
		if(index > 0) {
			ListNode<E> before = nodeAt(index - 1);
			ListNode<E> after = before.next.next;
			if(value.compareTo(before.data) < 0 || (after != null && value.compareTo(after.data) > 0)) {
				throwSortException();
			} 
		}
		//if you make it past all these tests	
		super.set(index, value);
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
	 * Insert a value into its proper place in the sorted linked list 
	 * @param value value to insert into the sorted linked list
	 * @see mylistpackage.MyList#insert(Object)
	 */
	@Override
	public void insert(E value) {
	   //front case
	   if(front == null || front.data.compareTo(value) >= 0) {
		    front = new ListNode<E>(value, front);
		    back = front;
	   } else {
		   ListNode<E> current = front;
		   //know at this point that the value is > front.data
		   while(current.next!= null &&	   /*
			    * Keep going while there is a next value and the 
			    * next value is less than the to be inserted's value
			    */
			   current.next.data.compareTo(current.next.data) < 0) {
			   current = current.next;
		   }
		   current.next = new ListNode<E>(value, current.next);
	   }
	   size ++;
	}
	
	/**
	 * Inserts a value into the front of the sorted linked list.
	 * @param value - element to insert into the front.
	 * @throws IllegalArgumentException if inserting value as the front would 
	 * break sorted property of the list
	 */
	@Override
	public void insertFront(E value) {
		if(front!= null && front.data.compareTo(value) < 0) {
			throwSortException();
		} else {
			super.insertFront(value);
		}
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
	public void insertAtIndex(int index, E value) {
		if(index == 0 && front != null && value.compareTo(front.data) > 0) {
			throwSortException();
		} 
		if(index == size && value.compareTo(back.data) < 0) {
			throwSortException();
		} 
		if(index > 0 && index < size) {
			ListNode<E> before = nodeAt(index - 1);
			if(value.compareTo(before.data) < 0 || value.compareTo(before.next.data) > 0) {
				throwSortException();
			}
		}
		//take advantage of code reuse
		super.insertAtIndex(index, value);
	}
	

	/**
	 * Return the index of a given element.
	 * @see mylistpackage.MyList#getIndex(Object)
	 * @param value the element to return the index of
	 * @return the index of the given element
	 */
	@Override
	public int getIndex(E value) {
		ListNode<E> current = front;
		int index = 0;
		while(current!= null) {
			if(current.data.compareTo(value) == 0) {
				return index;
			}else if(current.data.compareTo(value) > 0) {  
				/*no way its in sorted list, if the current element's value is greater 
				than what we are trying to find, optimization */
				return -1;
			} else {
				//keep iterating
				index ++;
				current = current.next;
			}
		}
		return -1;
	}

	/**
     * Removes the first occurrence of the element from the list.
     * @see mylistpackage.MyList#remove(Object)
     * @param value element to remove first occurrence of
     */
	@Override
	public void remove(E value) {
		if(front != null) {
			ListNode<E> current = front;
			if(front.data.equals(value)) {
				front = front.next;
				if(size  == 1) {
					back = null;
				}
				size --;
			} else if(value.compareTo(front.data) > 0){
				//flag to stop the loop if we have removed an element(first occurrence)
				boolean hasRemovedElement = false;
				while(current.next != null && !hasRemovedElement 
						/* pretty much same code as LinkedListUnsorted but added logic
						 * to stop iterating if we know it is not in the list(sorted
						 * property)
						 */
						&& value.compareTo(current.next.data) < 0) {
					if(current.next.data.equals(value)) {
						current.next = current.next.next;
						hasRemovedElement = true;
						size --;
					}
					current = current.next;
				}
			}
		}
	}
	

}
