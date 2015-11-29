package mylistpackage;

import java.util.Iterator;

/**
 * Represents MyList interface.
 * 
 * @author Letian Sun
 * @version Jan. 12, 2015
 * @param <Type> is of any object type.
 */
public interface MyList<Type> {

    /**
     * Returns the current number of elements in the list.
     * @return the current number of elements in the list >= 0
     */
    public int getSize();

    /**
     * Returns whether the list is empty.
     * @return true if list is empty, false otherwise.
     */
    public boolean isEmpty();

    /**
     * Returns whether value is in the list.
     * @param value assigned
     * @return true if value in the list, false otherwise.
     */
    public boolean contains(Type value);

    /**
     * Inserts an element in the back of the list.
     * @param value assigned
     */
    public void insert(Type value);
    
    /**
     * Insert an element into the front of the list. Previous front element is then moved to the back.
     * @param value - the element to insert into the front of the list
     */
    public void insertFront(Type value);
    
    /**
     * Remove the element at a particular index 
     * @param index - index of the element to remove
     */
    public void removeAtIndex(int index);

    /**
     * Removes the first occurrence of the element from the list.
     * @param value assigned
     */
    public void remove(Type value);

    /**
     * Clears the list.
     */
    public void clear();

    /**
     * Returns a string representation of list contents.
     * @return a string representation of list contents.
     * @see Object#toString()
     */
    @Override
    public String toString();

    /**
     * Returns the index of a given element in the list 
     * @param value - value in list to retrieve the index of 
     * @return the index of the given value, or -1 if given value does not exist
     */
	public int getIndex(Type value);

	/**
	 * Insert an element at a particular element in the list
	 * @param index the index to insert the element at
	 * @param value the value to insert at that index
	 */
	public void insertAtIndex(int index, Type value);

	/**
	 * Set the element at a particular index in the list 
	 * @param index the index to set element at
	 * @param value the element to set
	 */
	public void set(int index, Type value);

	/**
	 * Retrieve the element at a particular index
	 * @param index - index of element to retrieve
	 * @return the element at that index
	 */
	public Type get(int index);

	/**
	 * Returns an iterator for this list 
	 * @return an iterator for this list
	 */
	public Iterator<Type> iterator();

}