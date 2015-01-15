package linkedliststuff;

/**
 * Represents MyList interface.
 * 
 * @author Monika
 * @version Jan. 2, 2015
 * @param <Type> is of any object type.
 */
public interface MyList<Type> {

    /**
     * Returns the current number of elements in the list.
     * 
     * @return the current number of elements in the list >= 0
     */
    public int getSize();

    /**
     * Returns whether the list is empty.
     * 
     * @return true if list is empty, false otherwise.
     */
    public boolean isEmpty();

    /**
     * Returns whether value is in the list.
     * 
     * @param value assigned
     * @return true if value in the list, false otherwise.
     */
    public boolean contains(Type value);

    /**
     * Inserts an element in the back of the list.
     * 
     * @param value assigned
     */
    public void insert(Type value);

    /**
     * Removes an element from the list.
     * 
     * @param value assigned
     */
    public void remove(Type value);

    /**
     * Clears the list.
     */
    public void clear();

    /**
     * Returns a string representation of list contents.
     * 
     * @return a string representation of list contents.
     * @see Object#toString()
     */
    @Override
    public String toString();

}