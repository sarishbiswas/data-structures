package dynamicDataStructure.stack;

import dynamicDataStructure.stack.exception.StackEmptyException;

public class TestStack {

	public static void main(String[] args) throws StackEmptyException {
		Stack<String> s = new Stack<String>();
		s.push("[");
		s.push("{");
		s.push("(");
		s.push(")");
		s.push("}");
		s.push("]");
		System.out.println(s);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}

}
