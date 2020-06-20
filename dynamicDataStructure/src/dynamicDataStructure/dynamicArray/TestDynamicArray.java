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
public class TestDynamicArray {

	public static void main(String[] args) {
		DynamicArray<Integer> arr1 = new DynamicArray<Integer>();
		System.out.println(arr1.isEmpty());
		for(int i = 0;i<10;i++)
			arr1.add(i);
		System.out.println(arr1);
		System.out.println(arr1.size());
		System.out.println(arr1.get(3));
		arr1.set(0, 100);
		System.out.println(arr1);
		arr1.remove(1);
		System.out.println(arr1);
		System.out.println(arr1.removeAt(0));
		System.out.println(arr1);
		System.out.println(arr1.contains(100));
		System.out.println(arr1.indexOf(10));
		for (Iterator<Integer> itr2=arr1.iterator(); itr2.hasNext();) {
			System.out.println(itr2.next());
		}
	}

}
