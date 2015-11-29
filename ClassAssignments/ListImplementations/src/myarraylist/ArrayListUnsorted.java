package myarraylist;

/**
 * Represents basic unsorted array-based list.
 * 
 * @author Letian Sun
 * @version Jan. 2, 2015
 * @param <E> is of any object type
 */
public class ArrayListUnsorted<E> extends AbstractArrayMyList<E> {
	
	/** 
	 * Constructs a unsorted array list with a default capacity
	 */
	public ArrayListUnsorted() {
		super(DEFAULT_CAPACITY);
	}
	
	/**
	 * Constructs a unsorted array list with a given capacity.
	 * @param capacity the given capacity
	 * @throws IllegalArgumentException if capacity <= 0
	 */
	public ArrayListUnsorted(int capacity) {
		super(capacity);
	}
	
    /**
     * Insert a value into the unsorted array list.
     * @see mylistpackage.MyList#insert(java.lang.Object)
     * @param value the value to insert into the array list.
     */
    public void insert(E value) {
        ensureCapacity(size + 1);
        elementData[size] = value;
        size++;
    }

    /**
     * Remove the first occurrence of an element in unsorted array list.
     * @param value the value to remove the first occurrence of.
     * @see mylistpackage.MyList#remove(java.lang.Object)
     */
    public void remove(E value) {
        int index = getIndex(value);
        //if the element is in the array, take action.
        if (index >= 0) {
            elementData[index] = elementData[size - 1];
            elementData[size - 1] = null;
            size--;
        }
    }
    
    /**
     * Returns the index of value.
     * @param value assigned.
     * @see mylistpackage.MyList#getIndex(Object)
     * @return index of value if in the list, -1 otherwise.
     */
    @Override
    public int getIndex(E value) {
    	//Linear search
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Remove a value at a specific index in unsorted array list 
     * @see mylistpackage.MyList#removeAtIndex(int)
     * @param index index of the element to remove
     * @throws IndexOutOfBoundsException if index < 0 or index >= size, not a valid index in the list
     */
	@Override
	public void removeAtIndex(int index) {
		checkInBoundsOfArray(index);
		elementData[index] = elementData[size-1];
		//make element eligible for garbage collection
		elementData[size - 1] = null;
		size --;
	}

	 /**
     * Inserts the given value at the given index with non shifting approach.
     * @param index <= size() and index >= 0
     * @param value to insert at index
     * @see mylistpackage.MyList#insertAtIndex(int, Object)
     * @throws IndexOutOfBoundsException if 0 < index > size
     */
    @Override
    public void insertAtIndex(int index, E value) {
    	checkOkToInsertAtIndex(index);
    	ensureCapacity(size + 1);
    	elementData[size] = elementData[index];
    	elementData[index] = value;
        size++;
    }
}