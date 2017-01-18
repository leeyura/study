package DataStructure;

public class LinkedListMain {
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.addFirst(30);
		linkedList.addFirst(20);
		linkedList.addFirst(10);
		linkedList.addLast(40);
		linkedList.addLast(50);
		System.out.println(linkedList.get(4));
		linkedList.removeFirst();
		System.out.println("linkedList : " + linkedList.toString());
	}
}
