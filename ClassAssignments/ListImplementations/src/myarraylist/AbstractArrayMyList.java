package myarraylist;


import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import mylistpackage.MyList;
/**
 * Abstract array list that contains common operations that sorted array lists
 * and non sorted array lists have.
 * @version 1/15/2015
 * @author Letian Sun
 * @param <E> is any object type
 */
public abstract class AbstractArrayMyList<E> implements MyList<E> {
	
	/**
     * default list capacity.
     */
    protected static final int DEFAULT_CAPACITY = 100;
    
    /**
     * Array back-end for the array list.
     */
    protected E[] elementData;

    /**
     * current number of elements in the list.
     */
    protected int size;
    
    /**
     * Constructs an empty list of default capacity.
     */
    public AbstractArrayMyList() {
        this( DEFAULT_CAPACITY);
    }
    
    /**
     * Constructs an array list with an established array to use as backend
     * @param elementData array to use as backend
     */
    public AbstractArrayMyList(E[] elementData) {
    	this.elementData = elementData;
    	size = 0;
    }
    
    /**
     * Constructs an empty list of the given capacity.
     * @param capacity > 0
     * @throws IllegalArgumentException if capacity <= 0
     */
    public AbstractArrayMyList( int capacity) {
    	checkCapacity(capacity);
        elementData = (E[]) new Object[capacity];
        size = 0;
    }
    
    /**
     * Returns if the list is currently empty.
     * @see mylistpackage.MyList#isEmpty()
     * @return if the list is currently empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Ensures that a capacity is valid(greater than 0), throw exception if not
     * @param capacity the given capacity to check
     */
    protected void checkCapacity(int capacity) {
    	if(capacity <= 0) {
    		throw new IllegalArgumentException("capacity: " + capacity);
    	}
    }
    /**
     * Returns whether or not an element is in the array list.
     * @param the element to check against.
     * @see mylistpackage.MyList#contains(java.lang.Object)
     */
    public boolean contains(E value) {
        return getIndex(value) >= 0;
    }
    
    /**
     * Replaces the value at the given index with the given value
     * @param index < size and index >= 0
     * @value is assigned
     * @see mylistpackage.MyList#set()
     * @throws IndexOutOfBoundsException if index < 0 or index >= size
     */
    @Override
    public void set(int index, E value) {
    	checkInBoundsOfArray(index);
        elementData[index] = value;
    }

    /**
     * Ensures that the given index is a valid index to work with in the array list
     * @param index to check against in the array.
     * @throws IndexOutOfBoundsException if index < 0 or index > size
     */
    protected void checkInBoundsOfArray(int index) {
    	if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }   
    }
    
    /**
     * Ensures that the given index is a valid insertion index in the array list
     * @param index, index to check for valid insertion point
     * @throws IndexOutOfBoundsException if index < 0 or index > size
     */
    protected void checkOkToInsertAtIndex(int index) {
    	if (index < 0 || index > size) {
    		throw new IndexOutOfBoundsException();
    	}
    }
    
    /**
     * Returns the value at the given index in the list.
     * @param index < size and index >= 0
     * @see mylistpackage.MyList#get(int)
     * @throws IndexOutOfBoundsException if index < 0 or index >= size
     * @return the value at the given index in the list.
     */
    @Override 
    public E get(int index) {
    	checkInBoundsOfArray(index);
        return elementData[index];
    }
    
    /**
     * Return the size of the list
     * @see mylistpackage.MyList#getSize()
     * @return the size of the list
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Clear the contents of the list
     * @see mylistpackage.MyList#clear()
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    /**
     * Inserts an element in the front of the list and moves the prior first
     * element to the back.
     * @see mylistpackage.MyList#clear()
     * @param value to insert at front
     */
    @Override
    public void insertFront(E value) {
        ensureCapacity(size + 1);
        elementData[size] = elementData[0];
        elementData[0] = value;
        size++;
    }

    /**
     * Creates a comma-separated, bracketed version of the list.
     * @see java.lang.Object#toString()
     * @return the string representation of the list
     */
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + elementData[0];
            for (int i = 1; i < size; i++) {
                result += ", " + elementData[i];
            }
            result += "]";
            return result;
        }
    }
    
    /**
     *Remove the first occurrence element from the list.
     *@param value the element to remove first occurrence of
     *@see mylistpackage.MyList#remove
     */
    @Override
	public void remove(E value) {
    	int indexOf = getIndex(value); 
    	if(indexOf >= 0)
    		removeAtIndex(getIndex(value));
	}

    /**
     * Ensures that the underlying array has the given capacity; if not,
     * increases the size by 100.
     * @param capacity > elementData.length.
     */
    protected void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int newCapacity = elementData.length + 100;
            if (capacity > newCapacity) {
                newCapacity = capacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }
    /*********************************************
     * Index list methods end
     *********************************************/

    /*********************************************
     * Iterator list class / methods follow
     *********************************************/


    /**
     * Returns an iterator for this list.
     * @see mylistpackage.MyList#iterator()
     * @return an iterator for the list.
     */
    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }


    /**
     * Represents an iterator for the list.
     * 
     * @author BuildingJavaPrograms 3rd Edition
     */
    private class ArrayListIterator implements Iterator<E> {

        /**
         * current position within the list.
         */
        private int position;

        /**
         * flag that indicates whether list element can be removed.
         */
        private boolean removeOK;

        /**
         * Constructs an iterator for the given list
         */
        public ArrayListIterator() {
            reset();
        }
        
        /**
         * Resets the iterator the first list element.
         */
        public final  void reset() {
        	position = 0;
        	removeOK = false;
        }
        
        /**
         * Returns whether there are more list elements.
         * @see java.util.Iterator#hasNext()
         * @return true if there are more elements left, false otherwise
         */
        public boolean hasNext() {
            return position < size;
        }

        /**
         * Returns the next element in the iteration.
         * @throws NoSuchElementException if no more elements.
         * @return the next element in the iteration.
         * @see java.util.Iterator#next()
         */
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = elementData[position];
            position++;
            removeOK = true;
            return result;
        }

        /**
         * Removes the last element returned by the iterator.
         * @throws IllegalStateException if a call to next has not been made
         *             efore call to remove.
         * @see java.util.Iterator#remove()
         */
        public void remove() {
            if (!removeOK) {
                throw new IllegalStateException();
            }
           removeAtIndex(position - 1);
            position--;
            removeOK = false;
        }
    }

}
