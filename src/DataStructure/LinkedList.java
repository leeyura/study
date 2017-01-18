package DataStructure;

/**
 * @author yul
 */
public class LinkedList<T> {
	private Node head;
	private Node tail;
	private int size = 0;

	private class Node {
		private Object data;
		private Node next;

		/**
		 * Node 생성.
		 * 
		 * @param inputData
		 */
		public Node(T inputData) {
			this.data = inputData;
			this.next = null;
		}

		public String toString() {
			return String.valueOf(this.data);
		}

	}

	/**
	 * 첫번째로 node를 추가.
	 * 
	 * @param inputData
	 */
	public void addFirst(T inputData) {
		Node newNode = new Node(inputData);
		newNode.next = head;
		head = newNode;
		size++;
		if (head.next == null) {
			tail = head;
		}
	}

	/**
	 * 마지막으로 node를 추가.
	 * 
	 * @param inputData
	 */
	public void addLast(T inputData) {
		Node newNode = new Node(inputData);
		if (size == 0) {
			addFirst(inputData);
		} else {
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}

	/**
	 * node의 값들을 [] 안의 String형태로 나타냄. return nodeValue
	 */
	public String toString() {
		if (head == null) {
			return "[]";
		}
		Node temp = head;
		String nodeValue = "[";
		while (temp.next != null) {
			nodeValue += temp.data + ",";
			temp = temp.next;
		}
		nodeValue += temp.data;
		return nodeValue + "]";
	}

	/**
	 * 해당 인덱스의 노드값을 반환.
	 * 
	 * @param idx
	 * @return node
	 */
	public Node get(int idx) {
		Node node = head;
		for (int i = 0; i < idx; i++) {
			node = node.next;
		}
		return node;
	}

	/**
	 * 첫번쨰 head가 가르키는 요소를 제거.
	 * 
	 * @return removeData
	 */
	public Object removeFirst() {
		Node temp = head;
		head = temp.next;
		Object removeData = temp.data;
		temp = null;
		size--;
		return removeData;
	}
}