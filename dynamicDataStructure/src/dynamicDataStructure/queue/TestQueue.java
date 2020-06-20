package dynamicDataStructure.queue;

public class TestQueue {

	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();
		System.out.println(queue);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue);
//		System.out.println(queue.dequeue());
	}

}
