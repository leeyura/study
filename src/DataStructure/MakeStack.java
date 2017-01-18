package DataStructure;

/**
 * @author yul
 */
public class MakeStack {
	public static void main(String[] args) {
		Stack st = new Stack(5);
		System.out.println("empty : " + st.empty());
		st.push(10);
		st.peak();
		st.push(20);
		st.peak();
		st.push(30);
		System.out.println("search : " + st.search(20));
		System.out.println("empty : " + st.empty());
		st.peak();
		st.pop();
		st.peak();
		st.pop();
		st.peak();
		st.pop();
		System.out.println("empty : " + st.empty());
		/*
		 * 결과 empty : true peak =10 peak =20 search : 2 empty : false peak =30
		 * peak =20 peak =10 empty : true
		 */
	}
}

class Stack {
	int top = 0;
	int[] stack;
	int size;

	/**
	 * stack생성.
	 * 
	 * @param size
	 */
	public Stack(int size) {
		top = -1;
		stack = new int[size];
		this.size = size;
	}

	/**
	 * stack의 공백 여부.
	 * 
	 * @return
	 */
	public boolean empty() {
		return (top + 1 == 0);
	}

	/**
	 * stack의 최상위 요소를 알려줌.
	 */
	public void peak() {
		if (top == -1) {
			System.out.println("null");
		} else {
			System.out.println("peak =" + stack[top]);
		}
	}

	/**
	 * stack에 값을 추가.
	 * 
	 * @param value
	 */
	public void push(int value) {
		stack[++top] = value;
	}

	/**
	 * stack에서 최상위요소 제거.
	 * 
	 * @return
	 */
	public int pop() {
		return stack[top--];
	}

	/**
	 * 최상위요소를 1로 시작하여 찾고자하는 요소까지 count한 숫자를 반환.
	 * 
	 * @param value
	 * @return result
	 */
	public int search(int value) {
		int result = 0;
		for (int i = 0; i < stack.length; i++) {
			if (stack[i] == value) {
				result = (top - 1) + 1;
			}
		}
		return result;
	}
}
