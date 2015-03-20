package linkedliststuff;


public class LinkedIntListClient {

	public static void main(String[] args) {
		AdditionalLinkedList list1 = new AdditionalLinkedList();
		ListNode node0 = new ListNode(0);
		list1.front = node0;
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
//		ListNode node5 = new ListNode(5);
		node0.next = node1; 
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
//		node4.next = node5;
		AdditionalLinkedList list2 = new AdditionalLinkedList();
		ListNode node10 = new ListNode(10);
		list2.front = node10;
		ListNode node11 = new ListNode(11);
		node10.next = node11;
		node4.next = node10;
//		ListNode node12 = new ListNode(12);
//		node11.next = node12;
//		node12.next = node4;
		System.out.println(list1.converge(list2));
	}
}


