package dynamicDataStructure.stack;

import java.util.Iterator;

import dynamicDataStructure.DynamicDS;
import dynamicDataStructure.doublyLinkedList.DoublyLinkedList;
import dynamicDataStructure.stack.exception.StackEmptyException;

public class Stack<T> implements Iterable<T> {
	DynamicDS<T> dll = null;
	public Stack() {
		super();
		this.dll = new DoublyLinkedList<T>();
	}
	public Stack(T firstElement) {
		push(firstElement);
	}
	public int size() {
		return dll.size();
	}
	public boolean isEmpty() {
		return dll.size()==0;
	}
	public void push(T firstElement) {
		dll.addLast(firstElement);
	}
	public T pop() throws StackEmptyException {
		if(isEmpty())
			throw new StackEmptyException();
		return dll.removeFirst();
	}
	public T peek() {
		return dll.get(size()-1);
	}
	public int search(T element) {
		return dll.indexOf(element);
	}
	public boolean contains(T element) {
		return dll.contains(element);
	}
	public void clear() {
		dll.clear();
		System.out.println("Stack is now Empty");
	}
	@Override
	public Iterator<T> iterator() {
		return dll.iterator();
	}
	@Override
	public String toString() {
		return "stack =" + dll;
	}
	

}
