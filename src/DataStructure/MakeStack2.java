package DataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yul
 */
public class MakeStack2 {
	public static void main(String[] args) {

		Stack2<String> st2 = new Stack2<String>(25);
		st2.push("hi");
		st2.peak();
		st2.push("15");
		st2.peak();
		st2.pop();
		st2.peak();
		/*
		 * 결과 peak : hi peak : 15 peak : hi
		 */
	}
}

class Stack2<T> {
	int top = 0;
//	Object[] stack;
	private List<T> stack;
	int size;

	public Stack2(int size) {
		top = -1;
		stack = new ArrayList<T>(size);
		this.size = size;
	}

	public void peak() {
		System.out.println("peak : " + stack.get(top));
	}

	public void push(T value) {
		stack.add(value);
		top++;
	}

	public T pop() {
		T data = stack.remove(top);
		top--;
		return data;
	}
}
