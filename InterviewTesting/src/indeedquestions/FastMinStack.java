package indeedquestions;

import java.util.Stack;
/**
 * 
 *How do you optimize getting minimum of the stack in O(1) runtime and O(n) space.  
 * @param <T>
 */
public class FastMinStack<T extends Comparable<T>>
{
	public static void main(String[] args) {
		FastMinStack<Integer> stack = new FastMinStack<Integer>();
		stack.Push(2);
		stack.Push(6);
		stack.Push(4);	
		stack.Push(1);
		stack.Push(5);
		System.out.println("min is " + stack.getMin());
		stack.Pop();
		stack.Pop();
		System.out.println("min is " + stack.getMin());
	}
    private Stack<T> stack = new Stack<T>();

    private T currentMin;

    public T getMin(){
        return currentMin; 
    }

    public void Push(T element)
    {
        if (stack.size() == 0 ||
        		element.compareTo(currentMin) <=0 )
        {
            stack.push(currentMin);
            stack.push(element);
            currentMin = element;
        }
        else
        {
            stack.push(element);
        }
    }

    public T Pop()
    {
        T ret = stack.pop();
        if (ret.compareTo(currentMin) == 0)
        {
            currentMin = stack.pop();
        }
        return ret;
    }
}