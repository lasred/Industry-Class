package amazonquestions;



import java.util.Stack;

/**
 *  a stack that could return the largest number 
 *  in the stack at anytime. Push, pop, get min should
 *  all return the largest number in the stack
 * @author chris
 *
 */
public class MaxStack<T extends Comparable<? super T>> {
	//widely used 
	private T max;
	private Stack<T> originalElements;
	private Stack<T> maxes;
	public MaxStack() {
		originalElements = new Stack<T>();
		maxes = new Stack<T>();
	}
	public T Pop() {
		if(originalElements.isEmpty()){
			//Max Stack not in a state to remove
			throw new IllegalStateException();
		}
		T element = originalElements.pop();
		if(element.equals(max) ) {
			maxes.pop();
			//because the max could have changed, we need to update
			if(maxes.isEmpty()) {
				max = null;
			} else {
				max = maxes.peek();
			}
		}
		return element;
	}
	public void Push(T element) {
		if(max==null||element.compareTo(max) > 0) {
			//reassign max
			max = element;
		}
		originalElements.push(element);
		//only push on maxes
		//for a little optimization
		if(element.equals(max))
			maxes.push(max);
	}
	private T getMax() {
		return max;
	}
	public static void main(String[] args) {
		MaxStack<Integer> stack = new MaxStack<Integer>();
		stack.Push(2);
		stack.Push(3);
		stack.Push(6);	
		stack.Push(1);
		stack.Push(5);
		stack.Push(5);
		System.out.println("max is " + stack.getMax());
		stack.Pop();
		System.out.println("max is " + stack.getMax());
	}
   

   
}
