package gree;

import java.util.Stack;

/**
 * Implement a queue with two stacks
 * @author chris
 *
 */
public class MyQueue{
	private Stack<Integer> aux;
	private Stack<Integer> actual;
	public MyQueue() {
		aux = new Stack<Integer>();
		actual = new Stack<Integer>();
	}
	public boolean isEmpty() {
		return actual.isEmpty();
	}
	public void enqueue(int toE) {
		while(!actual.isEmpty()) {
			aux.push(actual.pop());
		}
		actual.push(toE);
		while(!aux.isEmpty()) {
			actual.push(aux.pop());
		}
	}
	public int getSize() {
		return actual.size();
	}
	public int peek() {
		return actual.peek();
	}
	public int dequeue(){
		if(!isEmpty()) {
			return actual.pop();
		} else {
			return -1;
		}
	}
}
