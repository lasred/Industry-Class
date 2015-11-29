package mysinglelinkedlist;

/**
 * Represents basic unsorted node-based list.
 * 
 * @author Letian Sun
 * @version Jan. 17, 2015
 * @param <E> is of any object type
 */
public class LinkedListUnsorted<E> extends AbstractLinkedMyList<E> {
    
	/**
     * Insert a value into the unsorted linked list.
     * @see mylistpackage.MyList#insert(java.lang.Object)
     * @param value the value to insert into the unsorted linked list.
     */
     @Override
     public void insert(E value) {
    	 insertAtIndex(size, value);
	 }
	   
     /**
     * Returns the index of value.
     * @param value assigned.
     * @see mylistpackage.MyList#getIndex(Object)
     * @return index of value if in the list, -1 otherwise.
     */
     public int getIndex(E value) {
    	 int index = 0;
         ListNode<E> current = front;
         while (current != null) {
        	 if (current.data.equals(value)) {
        		 return index;
        	 }
             index++;
             current = current.next;
         }
         return -1;
    }

    /**
     * Remove the first occurrence of an element in unsorted linked list.
     * @param value the value to remove the first occurrence of.
     * @see mylistpackage.MyList#remove(java.lang.Object)
    */
	@Override
	public void remove(E value) {
		if(front != null) {
			if(front.data.equals(value)) {
				front = front.next;
				if(size == 1) {
					back = null;
				}
				size --; 
			} else {
				ListNode<E> current = front;
				//flag to stop the loop if we have removed an element
				boolean hasRemovedElement = false;
				while(current.next != null && !hasRemovedElement) {
					if(current.next.data.equals(value)) {
						current.next = current.next.next;
						hasRemovedElement = true;
						//removed an element
						size --;
					} else {
						current = current.next;
					}
				}
			}
		}
	}

}