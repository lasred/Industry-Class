package linkedliststuff;

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
