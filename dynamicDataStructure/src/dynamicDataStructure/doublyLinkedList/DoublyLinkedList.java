package dynamicDataStructure.doublyLinkedList;
import java.util.Iterator;
import dynamicDataStructure.DynamicDS;

public class DoublyLinkedList<T> implements DynamicDS<T> {
	
	private int size = 0;
	private Node<T> head = null;
	private Node<T> tail = null;
	
	private static class Node<T> {
		private T data;
		private Node<T> prev = null;
		private Node<T> next = null;
		
		public Node(T data, Node<T> prev, Node<T> next) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}

		@Override
		public String toString() {
			return data.toString();
		}

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public void clear() {
		Node<T> trav = head;
		while (trav != null) {
			trav.data = null;
			trav = trav.next;
		}
		head = tail = trav = null;
		size = 0;
	}
	
	@Override
	public void addLast(T element) {
		if(isEmpty())
			head = tail = new Node<T>(element,null,null);
		else {
			Node<T> trav = tail;
			Node<T> temp = new Node<T>(element,trav,trav.next);
			trav.next = temp;
			tail = temp;
		}
		size++;
	}
	
	@Override
	public void addFirst(T element) {
		if(isEmpty())
			head = tail = new Node<T>(element,null,null);
		else {
			Node<T> trav = head;
			Node<T> temp = new Node<T>(element,trav.prev,trav);
			trav.prev = temp;
			head = temp;
		}
		size++;
	}

	@Override
	public void add(T element) {
		addLast(element);
	}
	
	@Override
	public T removeLast() {
		if(size()<=0) throw new RuntimeException("No Element is available in the List.");
		if(size()==1) {
			T data = tail.data;
			head = tail = null;
			size=0;
			return data;
		}
		Node<T> temp = tail;
		tail=tail.prev;
		tail.next = temp.next;
		size--;
		return temp.data;
	}
	
	@Override
	public T removeFirst() {
		if(size()<=0) throw new RuntimeException("No Element is available in the List.");
		if(size()==1) {
			T data = head.data;
			head = tail = null;
			size=0;
			return data;
		}
		Node<T> temp = head;
		head = head.next;
		head.prev = temp.prev;
		size--;
		return temp.data;
	}

	@Override
	public void remove(T element) {
		if(size()<=0) throw new RuntimeException("No Element is available in the List.");
		if(head.data.equals(element)) removeFirst();
		else if(tail.data.equals(element)) removeLast();
		else {
			Node<T> trav = head;
			while(!trav.data.equals(element))
				trav = trav.next;
			trav.prev.next = trav.next;
			trav.next.prev = trav.prev;
			trav = null;
			size--;
		}
	}

	@Override
	public int indexOf(T element) {
		int idx = 0;
		if(size()<=0) throw new RuntimeException("No Element is available in the List.");
		if(head.data.equals(element)) return 0;
		else if(tail.data.equals(element)) return size-1;
		else {
			Node<T> trav = head;
			while(!trav.data.equals(element)) {
				if(trav.next == null) {
					return -1;
				}
				trav = trav.next;
				idx+=1;
			}
			return idx;
		}
	}

	@Override
	public boolean contains(T element) {
		return indexOf(element)!=-1;
	}



	@Override
	public T get(int index) {
		int idx = 0;
		if(index<0 || index>=size()) new RuntimeException("Index out of Bound or Invalid Index.");
		if(size()<=0) throw new RuntimeException("No Element is available in the List.");
		if(index==0) return head.data;
		if(index==size()-1) return tail.data;
		else {
			Node<T> trav = head;
			while(idx<index) {
				trav = trav.next;
				idx+=1;
			}
			return trav.data;
		}
	}

	@Override
	public void set(int index, T element) {
		if(index<0 || index>=size()) new RuntimeException("Index out of Bound or Invalid Index.");
		else {
			int idx = 0;
			Node<T> trav = head;
			while(idx<index) {
				trav = trav.next;
				idx+=1;
			}
			trav.data = element;
		}
	}


	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Node<T> trav = head;
			@Override
			public boolean hasNext() {
				return trav!=null;
			}

			@Override
			public T next() {
				T data = trav.data;
				trav = trav.next;
				return data;
			}
		};
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		if(size==0) {
			sb.append("]");
			return sb.toString();
		}
		Node<T> trav = head;
		while (trav.next != null) {
			sb.append(trav.data + ", ");
			trav = trav.next;
		}
		sb.append(trav.data);
		sb.append(" ]");
		return sb.toString();
	}

}
