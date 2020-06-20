package dynamicDataStructure;

public interface DynamicDS<T> extends Iterable<T> {
	public int size();
	public boolean isEmpty();
	public void clear();
	public void add(T element);
	public void remove(T element);
	public int indexOf(T element);
	public boolean contains(T element);
	public void addLast(T element);
	public void addFirst(T element);
	public T removeLast();
	public T removeFirst();
	public T get(int index);
	public void set(int index,T element);
}
