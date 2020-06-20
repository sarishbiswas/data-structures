package dynamicDataStructure.singlyLinkedList;

import java.util.Iterator;
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

import dynamicDataStructure.DynamicDS;

public class SinglyLinkedList<T> implements DynamicDS<T> {

	private int size = 0;
	private Node<T> head = null;
	private Node<T> tail = null;

	private static class Node<T> {
		private T data;
		private Node<T> next = null;

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}

		@Override
		public String toString() {
			return data.toString();
		}

	}

	public void clear() {
		Node<T> trav = head;
		while (trav != null) {
			trav.data = null;
			trav = trav.next;
		}
		head = tail = trav = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void addLast(T element) {
		if (isEmpty())
			head = tail = new Node<T>(element, null);
		else {
			tail.next = new Node<T>(element, null);
			tail = tail.next;
		}
		size += 1;
	}

	public void addFirst(T element) {
		if (isEmpty())
			head = tail = new Node<T>(element, null);
		else {
			Node<T> temp = new Node<T>(element, null);
			temp.next = head;
			head.data = temp.data;
			head.next = temp.next;
		}
		size += 1;
	}

	public void add(T element) {
		addLast(element);
	}

	public T pickFirst() {
		if (isEmpty())
			throw new RuntimeException("Eempty List");
		else
			return head.data;
	}

	public T pickLast() {
		if (isEmpty())
			throw new RuntimeException("Eempty List");
		else
			return tail.data;
	}

	public T removeLast() {
		if (isEmpty())
			throw new RuntimeException("Eempty List");
		else if (size == 1) {
			T data = head.data;
			head.data = null;
			size = 0;
			return data;
		}
		Node<T> trav1 = head;
		Node<T> trav2 = head.next;

		while (trav2.next != null) {
			trav1 = trav1.next;
			trav2 = trav2.next;
		}
		T data = trav2.data;
		trav1.next = null;
		tail.data = trav1.data;
		size -= 1;
		return data;

	}

	public T removeFirst() {
		if (isEmpty())
			throw new RuntimeException("Eempty List");
		else if (size == 1) {
			T data = head.data;
			head.data = null;
			size = 0;
			return data;
		}
		T data = head.data;
		head = head.next;
		size -= 1;
		return data;
	}

	public void remove(T element) {
		if (isEmpty())
			throw new RuntimeException("Eempty List");
		else if (size == 1) {
			T data = head.data;
			if (data != element)
				throw new RuntimeException("Element is not available in the list");
			head.data = null;
			size = 0;
		}
		if (contains(element)) {
			Node<T> trav1 = head;
			Node<T> trav2 = head.next;
			while (trav2.data != element) {
				trav1 = trav1.next;
				trav2 = trav2.next;
			}
			trav2 = trav2.next;
			trav1.next = trav2;
			size -= 1;
		}
	}

	public int indexOf(T data) {
		int idx = 0;
		Node<T> trav = head;
		while (trav.data != data) {
			if (trav.next == null)
				return -1;
			trav = trav.next;
			idx += 1;
		}
		return idx + 1;
	}

	public boolean contains(T element) {
		return indexOf(element) == -1;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		Node<T> trav = head;
		while (trav.next != null) {
			sb.append(trav.data + ", ");
			trav = trav.next;
		}
		sb.append(trav.data);
		sb.append(" ]");
		return sb.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Node<T> trav = head;

			@Override
			public boolean hasNext() {
				return trav != null;
			}

			@Override
			public T next() {
				T data = trav.data;
				trav = trav.next;
				return data;
			}
		};
	}

	@Override
	public T get(int index) {
		if (index == 0)
			return head.data;
		if (index == 1)
			return head.next.data;
		if (index + 1 > size || index < 0)
			throw new RuntimeException("Invalid Index");
		int idx = 0;
		Node<T> trav = head;
		while (idx != index) {
			trav = trav.next;
			idx += 1;
		}
		return trav.data;
	}

	@Override
	public void set(int index, T element) {
		if (index + 1 > size || index < 0)
			throw new RuntimeException("Invalid Index");
		int idx = 0;
		Node<T> trav = head;
		while (idx != index) {
			trav = trav.next;
			idx += 1;
		}
		trav.data = element;
	}

}
