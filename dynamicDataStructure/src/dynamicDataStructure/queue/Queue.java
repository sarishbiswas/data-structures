package dynamicDataStructure.queue;

import java.util.Iterator;

import dynamicDataStructure.DynamicDS;
import dynamicDataStructure.doublyLinkedList.DoublyLinkedList;

public class Queue<T> implements Iterable<T> {
	DynamicDS<T> dll = null;
	public Queue(){
		this.dll = new DoublyLinkedList<T>();
	}
	@Override
	public Iterator<T> iterator() {
		return dll.iterator();
	}
	public Queue(T element) {
		enqueue(element);
	}
	public void enqueue(T element) {
		dll.addLast(element);
	}
	public T dequeue() {
		if(isEmpty())
			throw new RuntimeException("Queue is Empty");
		return dll.removeFirst();
	}
	public boolean isEmpty() {
		return size()==0;
	}
	public int size() {
		return dll.size();
	}
	public T peek() {
		if(isEmpty())
			throw new RuntimeException("Queue is Empty");
		return dll.get(0);
	}
	public boolean contains(T element) {
		return dll.contains(element);
	}
	public void clear() {
		dll.clear();
		System.out.println("Queue is now Empty");
	}
	public String toString() {
		return "queue = " + dll;
	}
}
