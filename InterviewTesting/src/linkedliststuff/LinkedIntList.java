package linkedliststuff;

// Simple version of LinkedIntList with the appending add method

public class LinkedIntList {
	private static final int BASE_OF_INTEGER = 10;
	protected ListNode front;
    public static LinkedIntList sumToReverse(LinkedIntList L1,
    		LinkedIntList L2) {
    	int sum = L1.convReverse() + L2.convReverse();
    	LinkedIntList list = new LinkedIntList();
    	do {
    		list.add(sum % 10);
    		sum = sum / 10;
    	} while(sum > 0);
    	return list;
    }
    public int convReverse() {
    	int curr = 0;
    	int valueOf = 0;
    	ListNode current = front;
    	while(current != null) {
    		valueOf += current.data * Math.pow(BASE_OF_INTEGER
    				, curr);
    		curr ++;
    		current = current.next;
    	}
    	return valueOf;
    }
    // post: appends the value to the end of the list
    public void add(int value) {
        if (front == null)
            front = new ListNode(value);
        else {
            ListNode current = front;
            while (current.next != null)
                current = current.next;
            current.next = new ListNode(value);
        }
    }
 // Returns a text representation of this list, such as "[42, -3, 17]"
 	// or "[]" for an empty list.
 	public String toString() {
 		if (front == null) {
 			return "[]";
 		} else {
 			String result = "[" + front.data;
 			ListNode current = front.next;
 			while (current != null) {
 				result += ", " + current.data;
 				current = current.next;
 			}
 			result += "]";
 			return result;
 		}
 	}
 	public void partNode(int x) {
 		ListNode nLF = null;
 		ListNode nLB = null;
 		while(front!= null && front.data>=x) {
 			if(nLF == null) {
 				nLF = front;
 				nLB = front;
 			} else {
 				nLB = aTB(nLB, front);
 			}
 			front = front.next;
 			nLB.next = null;
 		}
 		ListNode curr = front;
 		if(front != null) {
 			while(curr.next != null) {
 				if(curr.next.data >= x) {
 					if(nLF == null) {
 		 				nLF = curr.next;
 		 				nLB = curr.next;
 		 			} else {
 		 				nLB = aTB(nLB, curr.next);
 		 			}
 					curr.next = curr.next.next;
 					nLB.next = null;
 				} else {
 					 curr = curr.next;
 				}
 			}
 		}
 		if(front == null) {
 			front = nLB;
 		} else {
 			curr.next = nLF;
 		}
 	}
 	private ListNode aTB(ListNode back, ListNode attach) {
 		back.next = attach;
 		back = attach;
 		return back;
 	}
 	
}