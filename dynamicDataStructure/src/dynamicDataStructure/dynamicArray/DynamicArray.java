package dynamicDataStructure.dynamicArray;

import java.util.Iterator;
/*
 * 1.size()
 * 2.isEmpty()
 * 3.get(index)
 * 4.set(index,element)
 * 5.clear()
 * 6.add(element)
 * 7.removeAt(index)
 * 8.remove(element)
 * 9.indexOf(element)
 * 10.contains(element)
 * 11.hasNext()
 * 12.next()
 * */

import dynamicDataStructure.DynamicDS;

public class DynamicArray<T> implements DynamicDS<T> {
	private T[] arr;
	private int len = 0; // length user thinks array is
	private int capacity = 0; // Actual array size

	public DynamicArray() {
		this(16);
	}

	public DynamicArray(int capacity) {
		if (capacity < 0)
			throw new IllegalArgumentException("Illegal Capacity: " + capacity);
		this.capacity = capacity;
		arr = (T[]) new Object[capacity];
	}

	public int size() {
		return len;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public T get(int index) {
		return arr[index];
	}

	public void set(int index, T element) {
		arr[index] = element;
	}

	public void clear() {
		for (int i = 0; i < size(); i++)
			arr[i] = null;
		len = 0;
	}

	public void add(T element) {
		if (len + 1 >= capacity) {
			if (capacity == 0)
				capacity = 1;
			else
				capacity *= 2;
			T[] arr1 = (T[]) new Object[capacity];
			for (int i = 0; i < len; i++)
				arr1[i] = arr[i];
			arr = arr1;
		}
		arr[len++] = element;
	}

	public T removeAt(int rm_index) {
		if (rm_index >= len || rm_index < 0)
			throw new IndexOutOfBoundsException();
		T data = arr[rm_index];
		T[] new_arr = (T[]) new Object[len - 1];
		for (int i = 0, j = 0; i < len; i++, j++) {
			if (i == rm_index)
				j--;
			else
				new_arr[j] = arr[i];
		}
		arr = new_arr;
		capacity = --len;
		return data;
	}

	public void remove(Object element) {
		int idx = indexOf(element);
		if (idx != -1)
			removeAt(idx);
		else throw new RuntimeException("Element is not present in the Array");
	}

	public int indexOf(Object element) {
		for (int i = 0; i < len; i++) {
			if (arr[i].equals(element))
				return i;
		}
		return -1;
	}

	public boolean contains(Object obj) {
		return indexOf(obj) != -1;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int index = 0;

			@Override
			public boolean hasNext() {
				return index < len;
			}

			@Override
			public T next() {
				return arr[index++];
			}
		};
	}

	@Override
	public String toString() {
		if(len==0) return "[]";
		StringBuilder sb = new StringBuilder(len).append("[");
		for(int i=0;i<len-1;i++) sb.append(arr[i]+",");
		sb.append(arr[len-1]+"]");
		return sb.toString();
	}

	@Override
	public void addLast(T element) {
		add(element);
	}

	@Override
	public void addFirst(T element) {
		if (len + 1 >= capacity) {
			if (capacity == 0)
				capacity = 1;
			else
				capacity *= 2;
			T[] arr1 = (T[]) new Object[capacity];
			arr1[0] = element;
			for (int i = 0,j=1; i < len; i++,j++) {
				arr1[j] = arr[i];
			}
			arr = arr1;
		}
		else {
			for(int i=len;i>0;i++)
				arr[i]=arr[i-1];
			arr[0]=element;
		}
		len+=1;
	}

	@Override
	public T removeLast() {
		return removeAt(len-1);
	}

	@Override
	public T removeFirst() {
		return removeAt(0);
	}


}
