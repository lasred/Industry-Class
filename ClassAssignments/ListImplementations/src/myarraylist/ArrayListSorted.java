package myarraylist;

/**
 * Represents a sorted array list.
 * @author Letian Sun
 * @version 1/15/2015

 * @param <E> is any object type that can be compared(implements Comparable)
 */
public class ArrayListSorted<E extends Comparable<E>> extends 
           AbstractArrayMyList<E> {
	
	/**
	 * Constructs a sorted array list with a given capacity.
	 * @param capacity or the number of elements the sorted array list can hold
	 * @throws IllegalArgumentException if capacity <= 0
	 */
	public ArrayListSorted(int capacity) {
		//so elements in the array are comparable.
		super((E[]) new Comparable[capacity]);
	}
	
	/**
	 * Constructs a sorted array list with default capacity.
	 */
	public ArrayListSorted() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Return the index of a given element.
	 * @see mylistpackage.MyList#getIndex(Object)
	 * @param the value to return the index of
	 * @return the index of the given element, or where it would be inserted
	 */
	@Override
	public int getIndex(E value) {
		 //lowest element in the region of possibility 
		 int lo = 0;
		 //highest element in the region of possibility 
	     int hi = size - 1;
	     //While region of possibility still exists
	     //binary search
	     while (lo <= hi && size!=0) {
	        int middle = (lo + hi) / 2; 
	        if(value.equals(elementData[middle])) {
	        	return middle;
	        } else if(value.compareTo(elementData[middle]) < 0) {
	        	hi = middle - 1;
	        } else {
	        	lo = middle + 1;
	        }
	     }
	     //not in list
	     return -(lo  + 1);
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
	public void set(int index, E value) {
		if(Math.abs(getInsertionPoint(value) - index) > 1) {
			throwSortException();
		}
		//if you make it past the check
		super.set(index, value);
	}
	
	/**
	 * Throw a exception that expresses how sort property of list would be broken
	 * @throws IllegalArgumentException
	 */
	private void throwSortException() {
		throw new IllegalArgumentException("Cannot set here, would break sorted property of list");
	}
	
	/**
	 * Insert an element at a particular element in the list
	 * @param index the index to insert the element at, if inserted, must maintain sorted property 
	 * of the array list, throw IllegalArgumentException if not
	 * @param value the value to insert at that index
	 * @throws IllegalArugmentException if inserting that value at that index would break the sorted
	 * property of the list
	 * @throws IndexOutOfBoundsException if 0 < index > size
	 */
	@Override
	public void insertAtIndex(int index, E value) {
		checkOkToInsertAtIndex(index);
		if(getInsertionPoint(value) != index) {
			throwSortException();
		}
		ensureCapacity(size + 1);
        for (int i = size; i >= index + 1; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = value;
        size++;
	}
	
	/**
	 * Return the index of the value in the array or where it would be inserted
	 * @param value the value to find or get insertion point in array 
	 * @return index of the value of the exists or index where it would be inserted
	 */
	private int getInsertionPoint(E value) {
		return getIndex(value) >= 0? getIndex(value): Math.abs(getIndex(value) + 1);
	}
	
	/**
	 * Insert a value into its proper place in the sorted array list 
	 * @param value value to insert into the sorted array list
	 * @see mylistpackage.MyList#insert(Object)
	 */
	@Override
	public void insert(E value) {
		int indexToInsert = getIndex(value);
		if(indexToInsert >= 0) {
			insertAtIndex(indexToInsert, value);
		} else {
			//negative, reverse the formula
			insertAtIndex(Math.abs(indexToInsert +1), value);
		}
	}
	
	/**
     * Removes value at the given index, shifting subsequent values up.
     * @param index < size and index >= 0
     * @throws IndexOutOfBoundsException if index < 0 or index >= size
     * @see mylistpackage.MyList#removeAtIndex(int)
     * @throws IndexOutOfBoundsException if index < 0 or index > size, not a valid index
     */
    public void removeAtIndex(int index) {
    	checkInBoundsOfArray(index);
        //Have to shift to maintain sorted property
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData[size - 1] = null;
        size--;
    }
}
