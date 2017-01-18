package DataStructure;

public class LinkedList {
	private Node head;
	private Node tail;
	private int size = 0;

	private class Node {
		private Object data;
		private Node next;

		public Node(Object inputData) {
			this.data = inputData;
			this.next = null;
		}

		public String toString() {
			return String.valueOf(this.data);
		}

	}

	public void addFirst(Object inputData) {
		Node newNode = new Node(inputData);
		newNode.next = head;
		head = newNode;
		size++;
		if (head.next == null) {
			tail = head;
		}
	}

	public void addLast(Object inputData) {
		Node newNode = new Node(inputData);
		if (size == 0) {
			addFirst(inputData);
		} else {
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}

	public String toString() {
		if (head == null) {
			return "[]";
		}
		Node temp = head;
		String str = "[";
		while (temp.next != null) {
			str += temp.data + ",";
			temp = temp.next;
		}
		str += temp.data;
		return str + "]";
	}

	public Node get(int idx) {
		Node x = head;
		for (int i = 0; i < idx; i++) {
			x = x.next;
		}
		return x;
	}

	public Object removeFirst() {
		Node temp = head;
		head = temp.next;
		Object returnData = temp.data;
		temp = null;
		size--;
		return returnData;
	}

}
