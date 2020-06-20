package dynamicDataStructure.doublyLinkedList;

import dynamicDataStructure.DynamicDS;

public class DoublyLinkedlistTest {

	public static void main(String[] args) {
		DynamicDS<Integer> dll = new DoublyLinkedList<Integer>();
//		dll.add(1);
//		dll.add(2);
//		dll.add(3);
//		dll.add(4);
//		dll.remove(1);
//		System.out.println(dll.size());
//		System.out.println(dll);
//		dll.remove(2);
//		System.out.println(dll.size());
//		System.out.println(dll);
//		dll.remove(3);
//		System.out.println(dll.size());
//		System.out.println(dll);
//		dll.remove(4);
//		System.out.println(dll.size());
//		System.out.println(dll);
		dll.add(1);
		dll.add(2);
		dll.add(3);
		dll.add(4);
//		System.out.println(dll.indexOf(4));
		System.out.println(dll);
//		System.out.println(dll.indexOf(100));
//		System.out.println(dll);
//		System.out.println(dll.indexOf(1));
//		System.out.println(dll);
		dll.set(0, 5);
		System.out.println(dll);
		dll.set(1, 4);
		System.out.println(dll);
		dll.set(2, 3);
		System.out.println(dll);
		dll.set(3, 2);
		System.out.println(dll);

	}

}
