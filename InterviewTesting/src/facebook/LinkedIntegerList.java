package facebook;

import java.util.Random;
/*
 * Letian Sun
 * WhatsApp Android Intern
 */
public class LinkedIntegerList {
	 private ListNode front;
	public static void main(String[] args) {
		LinkedIntegerList list = new LinkedIntegerList();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(10);
		ListNode node3 = new ListNode(20);
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(12);
		ListNode node6 = new ListNode(15);
		node1.next = node2;
		node2.next = node3;
		node4.next = node5;
		node5.next = node6;
		list.front = merge(node1, node4);
		printList(list.front);
		list.printReverseSpace();
		list.printReverseConstantSpace();
		printList(list.front);
	}
	//O(n) time O(1) space
	public void printReverseConstantSpace() {
		reverse();
		printList(front);
		reverse();
	}
	//O(n) time O(n) space
	public void printReverseSpace() {
		System.out.print("Elements:");
		printReversedSpace(front);
		System.out.println();
	}
	private void printReversedSpace(ListNode curr) {
		if(curr!=null){
			printReversedSpace(curr.next);
			System.out.print(" " +curr.data);
		}
	}
	public void reverse() {
		if(front!=null && front.next != null) {
			ListNode originalFront = front;
			while(front.next!=null) 
				front = front.next;
			ListNode curr = originalFront;
			ListNode previous = null;
			while(curr!=null) {
				ListNode temp;
				if(curr.next!=null) {
					temp = curr.next.next;
					curr.next.next = curr;
				} else {
					temp = null;
				}
				ListNode nextPrevious = curr.next;
				//assign to the previous previous
				curr.next = previous;
				previous = nextPrevious;
				curr = temp;
			}
		}
		
	}
	private boolean isSorted() {
		ListNode curr = front;
		if(curr!=null) {
			while(curr.next != null) {
				if(curr.next.data < curr.data)
					return false;
				curr = curr.next;
			}
		}
		return true;
	}
	private static void addElements(ListNode toAddTo, int n) {
		Random random = new Random();
		for(int c=0;c<n;c++) {
			toAddTo.next = new ListNode(random.nextInt(99));
			toAddTo = toAddTo.next;
		}
	}
	public void mergeSort() {
		front = mergeSort(front);
	}
	private ListNode mergeSort(ListNode front) {
		if(front == null || front.next == null) 
			return front;
		int size = findSize(front);
		ListNode divide = front;
		for(int inc=0;inc<size/2 - 1;inc++)
			divide = divide.next;
		ListNode startOfOtherList = divide.next;
		divide.next = null;
		front = mergeSort(front);
		startOfOtherList = mergeSort(startOfOtherList);
		return merge(front, startOfOtherList);
	}
	private int findSize(ListNode frontOfList) {
		int size = 0;
		//ok to move local variable around
		while(frontOfList != null) {
			size ++;
			frontOfList = frontOfList.next;
		}
		return size;
	}
	//for debugging
	private static void printList(ListNode front) {
		ListNode current = front;
		System.out.print("Elements:");
		while(current!=null) {
			System.out.print(" " + current.data);
			current = current.next;
		}
		System.out.println();
	}
	private static ListNode merge(ListNode front1, 
			ListNode front2) {
		ListNode newFront;
		if(front1 == null) {
			return front2;
		} else if(front2==null) {
			return front1;
		} else {
			ListNode pointer1, pointer2;
			if(front2.data < front1.data) {
				pointer1 = front2.next;
				newFront = front2;
				pointer2 = front1;
			} else {
				pointer1 = front1.next;
				pointer2 = front2;
				newFront = front1;
			}
			ListNode current = newFront;
			while(pointer1!=null&&pointer2!=null) {
				if(pointer1.data < pointer2.data) {
					current.next = pointer1;
					pointer1 = pointer1.next;
				} else {
					current.next = pointer2;
					pointer2 = pointer2.next;
				}
				current = current.next;
			}
			if(pointer1!=null) {
				current.next = pointer1;
			}
			if(pointer2!=null) {
				current.next = pointer2;
			}
			return newFront;
		} 
		
	}
	private static class ListNode {
		public int data; 
		private ListNode next;
		
	    public ListNode(int data) {
	    	this(data, null);
	    }
	       public ListNode(int data, ListNode next) {
	           this.data = data;
	           this.next = next;
	       }
	   }
}
