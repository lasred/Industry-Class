package mysinglelinkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;








import mylistpackage.MyList;

/**
 * Abstract linked list contains common operations that sorted linked lists
 * and non sorted linked lists have.
 * @author Letian Sun
 * @version 1/18/2015
 * @param <Type> can be any object type 
 */
public abstract class AbstractLinkedMyList<Type> implements MyList<Type> {
	
	/**
	* Reference to the first node in the list.
	*/
	protected ListNode<Type> front; 
	   
    /**
	* Reference to the last node in the list.
	*/
	protected ListNode<Type> back; 


	/**
	* current number of elements.
	*/
    protected int size; 
	   
	/**
     * Constructs an empty list.
     */
    public AbstractLinkedMyList() {
        front = back = null;
        size = 0;
    }
    
    /**
     * Replaces the value at the given index with the given value.
     * @param index < size and index >= 0
     * @param value is assigned
     * @throws IndexOutOfBoundsException if index < 0 or index >= size
     */
     @Override
    public void set(int index, Type value) {
     	if (index < 0 || index >= getSize()) {
     		throw new IndexOutOfBoundsException("index: " + index);
         }
     	nodeAt(index).data = value;
    }
     
    /**
     * Return size of the list.
     * @see mylistpackage.MyList#getSize()
     * @return size of the list 
     */
    @Override
    public int getSize() {
        return size;
    }
  
   /**
    * Return if the list is currently empty 
    * @see mylistpackage.MyList#isEmpty()
    * @return if the list is empty 
    */
    @Override
   public boolean isEmpty() {
       return size == 0;
   }
    
    /**
     * Return if the list contains a specific value
     * @see mylistpackage.MyList#contains(Object)
     * @returns if list contains that value
     */
    @Override
    public boolean contains(Type value) {
    	return getIndex(value) != -1;
    }
   
   
   /**
    * Returns the value at the given index in the list. 
    * @param index < size and index >= 0
    * @see mylistpackage.MyList#get(int)
    * @throws IndexOutOfBoundsException if index < 0 or index >= size
    * @return the value at the given index in the list.
    */
   public Type get(int index) {
	   checkInBoundsOfList(index);
       return nodeAt(index).data;
   }
   
   /**
    * Ensures that the given index is a valid index to work with in the linked list
    * @param index to check against in the array.
    * @throws IndexOutOfBoundsException if index < 0 or index > size
    */
   protected void checkInBoundsOfList(int index) {
   	if (index < 0 || index >= size) {
           throw new IndexOutOfBoundsException();
       }   
   }
   
   /**
    * Ensures that the given index is a valid insertion index in the linked list
    * @param index, index to check for valid insertion point
    * @throws IndexOutOfBoundsException if index < 0 or index > size
    */
   protected void checkOkToInsertAtIndex(int index) {
   	if (index < 0 || index > size) {
   		throw new IndexOutOfBoundsException();
   	}
   }

   /**
    * Inserts an element in the front of the list
    * @see mylistpackage.MyList#insertFront(Object)
    * @param value assigned.
    */
   public void insertFront(Type value) {
       insertAtIndex(0, value);
   }
   
   /**
    * Clear the contents of the list.
    * @see mylistpackage.MyList#clear()
    */
   public void clear() {
       front = null;
       back = null;
       size = 0;
   }

   /**
    * Returns an iterator for this list.
    * @see mylistpackage.MyList#iterator()
    * @return an iterator for the list.
    */
   public Iterator<Type> iterator() {
       return new LinkedIterator();
   }
   
   /**
    * Inserts the given value at the given index, shifting subsequent values.
    * @param index <= size() and index >= 0
    * @param value assigned
    * @see mylistpackage.MyList#insertAtIndex(int, Object)
    * @throws IndexOutOfBoundsException if 0 < index > size
    */
   public void insertAtIndex(int index, Type value) {
	   checkOkToInsertAtIndex(index);
       if (size == 0) {
           ListNode<Type> newNode = new ListNode<Type>(value);
           front = back = newNode;
       }
       else {
           if (index == 0) {
               ListNode<Type> newNode = new ListNode<Type>(value, front);
               front = newNode;
           }
           else {
               ListNode<Type> current = nodeAt(index - 1);
               ListNode<Type> newNode = new ListNode<Type>(value, current.next);
               current.next = newNode;
               if (index == size) {
                   back = newNode;
               }
           }       
       }
       size++;
   }
   
   /**
   * Removes value at the given index
   * @param index < size and index >= 0
   * @see mylistpackage.MyList#removeAtIndex(int)
   * @throws IndexOutOfBoundsException if index < 0 or index >= size
   */
  public void removeAtIndex(int index) {
	  checkInBoundsOfList(index);
      if (index == 0) {
          front = front.next;
          if (size == 1)
              back = null;
      }
      else {
          ListNode<Type> current = nodeAt(index - 1);
          current.next = current.next.next;
          if (current.next == null)
              back = current;
      }
      size--;
  }
  

  /**
   * Returns the node at a specific index.
   * @param index where 0 <= index < size()
   * @return reference to the node at a specific index
   */
  protected ListNode<Type> nodeAt(int index) {
      ListNode<Type> current = front;
      for (int i = 1; i <= index; i++) {
              current = current.next;
      }
      return current;
  }

  
  /**
   * Creates a comma-separated, bracketed version of the list.
   * @see java.lang.Object#toString()
   * @return string representation of the list
   */
  public String toString() {
      if (size == 0) {
          return "[]";
      } else {
          String result = "[" + front.data;
          ListNode<Type> current = front.next;
          while (current != null) {
              result += ", " + current.data;
              current = current.next;
          }
          result += "]";
          return result;
      }
  }

   /**
    * Represents a list node.
    * @author Letian Sun	
    * @version 1/18/2015
    * @param <E> is of any object type
    */
   protected static class ListNode<Type> {

       /**
        * Data stored in this node.
        */
       public Type data; 

       /**
        * Link to next node in the list.
        */
       public ListNode<Type> next;  

      
       /**
        * Constructs a node with given data and a null link.
        * @param data assigned
        */
       public ListNode(Type data) {
           this(data, null);
       }

       /**
        * Constructs a node with given data and given link.
        * @param data assigned
        * @param next assigned
        */
       public ListNode(Type data, ListNode<Type> next) {
           this.data = data;
           this.next = next;
       }
   }

   /**
    * Represents an iterator for the list.
    * @
    * @author Letian Sun, modified from BuildingJavaPrograms 3rd Edition
    */
   private class LinkedIterator implements Iterator<Type> {
       
       /**
        * Location of current value to return.
        */
       private ListNode<Type> current; 

       /**
        * flag that indicates whether list element can be removed.
        */
       private boolean removeOK; 
       
       /**
        * Location of the prior value in case of removal.
        */
       private ListNode<Type> prior;

       /**
        * Constructs an iterator for the given list.
        */
       public LinkedIterator() {
           reset();
       }
       
       /**
        * Resets iterator to first list position.
        */
       public final void reset() {
    	   current = front;
    	   removeOK = false;
    	   prior = null;
       }
       /**
        * Returns whether there are more list elements.
        * 
        * @return true if there are more elements left, false otherwise
        * @see java.util.Iterator#hasNext()
        */
       public boolean hasNext() {
           return current != null;
       }

       /**
        * Returns the next element in the iteration.
        * 
        * @throws NoSuchElementException if no more elements.
        * @return the next element in the iteration.
        * @see java.util.Iterator#next()
        */
       public Type next() {
           if (!hasNext()) {
               throw new NoSuchElementException();
           }
           prior = current;
           Type result = current.data;
           current = current.next;
           removeOK = true;
           return result;
       }

       /**
        * Removes the last element returned by the iterator.
        * 
        * @throws IllegalStateException if a call to next has not been made
        *             efore call to remove.
        * @see java.util.Iterator#remove()
        */
       public void remove() {
           if (!removeOK) {
               throw new IllegalStateException();
           }
           AbstractLinkedMyList.this.remove(prior.data);
           removeOK = false;
       }
   }

}
