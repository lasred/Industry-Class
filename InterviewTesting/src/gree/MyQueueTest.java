package gree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyQueueTest {
	private MyQueue queue;
	@Before
	public void setUp() throws Exception {
		queue = new MyQueue();
	}
	@Test 
	public void testEnqueue() {
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		assertEquals(2, queue.peek());
	}
	@Test 
	public void testDequeue() {
		for(int c=500;c>=0;c--) {
			queue.enqueue(c);
		}
		for(int y=0;y<=100;y++) {
			queue.dequeue();
		}
		assertEquals(399, queue.peek());
		queue.dequeue();
		assertEquals(398, queue.peek());
	}
	@Test
	public void testSize() {
		queue.enqueue(9);
		queue.enqueue(2);
		queue.enqueue(10);
		assertEquals(3, queue.getSize());
	}

}
