package DataStructure;

public class MakeLinkedList {

	private Node header;
	private int size;
	
	public MakeLinkedList(){
		header = new Node(null);
		size = 0;
	}
	
	private class Node {
		private Object data;
		private Node nextNode;
		
		Node(Object data){
			this.data = data;
			this.nextNode = null;
		}
	}
	
	/**
	 * ADD
	 * data, nextNode(addr)
	 */
	
	/**
	 * remove
	 * nextNode
	 */
	
	/**
	 * search
	 */
	public static void main(String[] args){
		
		MakeLinkedList list = new MakeLinkedList();
		
	}
}