package linkedliststuff;

import java.util.HashSet;
import java.util.Set;

public class AdditionalLinkedList extends LinkedIntList{
	public boolean equals(AdditionalLinkedList other) {
		ListNode curr1 = front;
		ListNode curr2 = other.front;
		while(curr1 != null && curr2 != null) {
			if(curr1.data != curr2.data) {
				//know because one of the element sis not equal 
				return false;
			}
		}
		return curr1 == null && curr2 == null;
	}
	public int converge(LinkedIntList other){
		if(front == null || other.front == null) {
			//no way they converge
			return -999;
		} else if(front == other.front) {
			return front.data;
		}else {
			ListNode pointer1 = front;
			ListNode pointer2 = other.front;
			for (;;) {
				if(pointer1 == pointer2) 
					return pointer1.data;
				//some while loop 
				//reach the end of the journey 
				if(pointer1.next==null) {
					pointer1 = other.front;
				} else {
					pointer1 = pointer1.next;
				}
				if(pointer2.next == null) {
					pointer2 = front;
				} else {
					pointer2 = pointer2.next;
				}
			}
			
		}
	}
	
	public void rotate() {
		//should have no effect if list has 0 or 1 element
		if(front != null && front.next != null) {
			ListNode rt = front;
			front = front.next;
			ListNode curr = front;
			//Get to the end of the list
			while(curr.next!= null) {
				curr = curr.next;
			}
			curr.next = rt;
			rt.next = null;
		}
	}
}
