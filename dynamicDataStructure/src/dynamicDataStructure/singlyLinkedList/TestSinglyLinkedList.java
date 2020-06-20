package dynamicDataStructure.singlyLinkedList;

/*
 * Singly Linked List Methods
 * 1.clear()
 * 2.size()
 * 3.isEmpty()
 * 4.addLast()
 * 5.addFirst()
 * 6.add
 * 7.pickFirst()
 * 8.pickLast()
 * 9.removeLast()
 * 10.removeFirst()
 * 10.remove()
 * 11.indexOf()
 * 12.contains()
 * 
 * */
public class TestSinglyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList<Integer> ll = new SinglyLinkedList<Integer>();
		ll.addFirst(1);
		ll.addLast(2);
		ll.addLast(3);
//		System.out.println(ll.toString());
//		System.out.println(ll.pickFirst());
//		System.out.println(ll.pickLast());
//		System.out.println(ll.removeLast());
//		System.out.println(ll);
//		System.out.println(ll.removeFirst());
//		System.out.println(ll.size());
//		System.out.println(ll);
//		System.out.println(ll.indexOf(3));
//		System.out.println(ll.size());
//		for(Iterator<Integer> itr = ll.iterator();itr.hasNext();)
//			System.out.println(itr.next());
		System.out.println(ll.get(1));
		ll.set(3, 100);
		System.out.println(ll);
	}

}
