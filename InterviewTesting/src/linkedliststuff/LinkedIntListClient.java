package linkedliststuff;


public class LinkedIntListClient {

	public static void main(String[] args) {

		LinkedIntList list = new LinkedIntList();
		list.add(60);
		list.add(50);
		list.add(4);
		list.add(20);
		list.add(5);

		System.out.println(list.toString());
		list.partNode(10);
		System.out.println(list.toString());

	}

}
