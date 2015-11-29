import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;


public class MyQueueTest {
	private MyQueue<Integer> queue;
	@Before
	public void setUp() throws Exception {
		queue = new MyQueue<Integer>();
		queue.enqueue(5);
		queue.enqueue(9);
		queue.enqueue(7);
	}
	@Test
	public void testIterator() {
		Iterator<Integer> iter = queue.iterator();
		int r1 = iter.next();
		int r2 = iter.next();
		int r3 = iter.next();
		assertEquals(r1, 5);
		assertEquals(r2, 9);
		assertEquals(r3, 7);
		assertFalse(iter.hasNext());


	}
	@Test
	public void testEnqueue() {
		assertEquals(queue.getSize(), 3);
	}

	@Test
	public void testDequeue() {
		Integer firstElement = queue.dequeue();
		Integer secondElement = queue.dequeue();
		assertEquals(firstElement.intValue(), 5);
		assertEquals(secondElement.intValue(), 9);
		assertEquals(1, queue.getSize());

	}

}
