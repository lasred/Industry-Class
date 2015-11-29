import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Represents a queue. 
 * 
 * @author Letian Sun
 * @param <T> is any object type 
 * @version 1/25/15
 */
public class MyQueue<T> {
	/**
	 * Default capacity of the my queue.
	 */
	private static final int DEFAULT_CAPACTY = 25;
	
	/**
	 * Do not want to keep an array after the first resizing that uses less than 30% of
	 * its contents
	 */
	private static final int PERCENTAGE = 30;
	
	/**
	 * elements the queue is keeping track of 
	 */
	private T[] elementData; 
	
	/**
	 * Current size of the queue
	 */
	private int size;
	
	/**
	 * Index of the front element of the queue.
	 */
	private int front;
	
	/**
	 * Where the next element should be inserte into the queue.
	 */
	private int back;
	
	/**
	 * Constructs a MyQueue instance with default capacity.
	 */
	public MyQueue() {

		/*
		 * from http://courses.cs.washington.edu/courses/cse332/15wi/projects/genericArrays.html
		*Cannot create generic array with new E[size] bc E is not known, code does not know
		*how to identify elements for this array. this is the workaround
		*/
		elementData =  (T[])new Object[DEFAULT_CAPACTY];
		//front, size, back should all be set to zero
		front = back = size = 0;
	}
	
	/**
	 *Return if the queue is empty 
	 * @return if the queue is empty 
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Return the size of the queue
	 * @return the size of the queue
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Enqueues an element into the queue
	 * @param element to enqueue into the queue
	 */
	public void enqueue(T element) {
		//if the array is full
		if(size == elementData.length){
			resizeToLargerArray();
		} else {
			size ++;
			elementData[back] = element;
			//circular queue
			back = (back + 1) % elementData.length;
		}
	}
	
	/**
	 * Dequeue an element out of the queue.
	 * @return the dequeued element
	 */
	public T dequeue() {
		if(size == 0) {
			throw new IllegalAccessError();
		}
		T dequed = elementData[front];
		elementData[front] = null;
		//increment the front
		front = (front + 1) % elementData.length;
		size --;
		/*
		 * After the first resizing in enqueue, we do not want an array that uses less than 
		 * 30% of its contents. Should shrink underlying array to half its size
		 */
		if(size < ((float)PERCENTAGE / 100 ) * elementData.length
				&& elementData.length / 2 >= 25) {
			shrinkToHalfSize();
		}
		return dequed;
	}
	
	/**
	 * Creates a new array of given capacity and assigns it to the underlying array of the queue
	 * 
	 * @param capacity the new capacity of the array 
	 */
	private void assignToDifferentArray(int capacity) {
		//array allows any object
		T[] newSize = (T[]) new Object[capacity];
		//to use to iterate through the queue and move elements to smaller array 
		int current = front;
		for(int newIndex = 0; newIndex < size; newIndex ++) {
			newSize[newIndex] = elementData[current];
			//iteration through circular array 
			current = (current + 1 ) % elementData.length;
		}
		front = 0;
		back = size;
		elementData = newSize;
	}
	
	/**
	 * Will shrink the underlying array to half its size
	 */
	private void shrinkToHalfSize() {
		assignToDifferentArray(size / 2);
	}
	
	/**
	 * When array back end is full, resize to an array that can hold 50 more elements
	 */
	private void resizeToLargerArray() {
		assignToDifferentArray(size + 50);
	}
	
	/**
     * Returns an iterator for this queue.
     * @return an iterator for the queue.
     */
    public Iterator<T> iterator() {
        return new MyQueueIterator();
    }
    
    /**
     * 
     * @author Letian
     *
     */
	private class MyQueueIterator implements Iterator<T> {

		/**
        * current position within the circular array 
        */
        private int position;
        /**
         * increment
         */
        private int increment;
        /**
         * Constructs a new queue iterator.
         */
        public MyQueueIterator() {
        	position = front;
        }
        /**
         * Returns whether there are more queue elements.
         * @return true if there are more elements left, false otherwise
         */
        @Override
		public boolean hasNext() {
        	return increment < size;
        }
        /**
         * Returns the next element in the iteration.
         * @throws NoSuchElementException if no more elements.
         * @return the next element in the iteration.
         */
		@Override
		public T next() {
			if (!hasNext()) {
				throw new IllegalStateException();
	        }
	        T result = elementData[position];
	        increment ++;
	        position = (position + 1) % elementData.length;
	        return result;
		}
		
		/**
		 * Remove an element of the queue. Should not remove from middle of queue
		 *@throws IllegalStateException  if removal from middle of queue is attempted
		 */
		@Override
		public void remove() {
			//should only remove from front(after one call to next has been made)
			if(position == front + 1) {
				MyQueue.this.dequeue();
			} else {
				throw new IllegalStateException("Do not want "
		          + "to support middle of the queue removal");
			}
		}
		
	}
//MVP Print out code
//	public void printOut() {
//		// TODO Auto-generated method stub
//		System.out.printf("front: %d back: %d size:%d  capacity:%d\n", front,
//				back, size, elementData.length);
////		int start = front;
////    	for(int count = 0; count < size; count ++ ) {
////    		if(elementData[start] == null) {
////    			System.out.println("mudurfuckor null");
////    		} else {
////    			System.out.println(elementData[start]);
////    		}
////    		start = (start + 1) % elementData.length;
////    	}
//	}
}
