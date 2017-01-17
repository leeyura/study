package DataStructure;

public class MakeQueue {
	public static void main(String [] args){
		Queue qu = new Queue(50);
		
		qu.peak();
		qu.offer(10);
		qu.offer(20);
		qu.offer(30);
		qu.peak();
		qu.poll();
		qu.peak();
		qu.poll();
		qu.peak();
		/*   결과
		    peak :  null
			peak : 0
			peak : 10
			peak : 20
			peak : 30
		 */
	}
}

class Queue{
	// head & insert
	int front = 0;
	//delete
	int rear = -1;
	int[] queue;
	int size;
	
	public Queue(int size){
		queue = new int [size];
		this.front = 0;
		this.rear = -1;
		this.size = size;
	}
	
	 public boolean empty(){
	        return (front == rear+1);
	    }

	public void peak (){
		if(empty()){
			System.out.println("peak :  null");
		}
		System.out.println("peak : " + queue[front]);
	}
	
	public void offer(int value){
		queue[++rear] = value;
	}
	
	public int poll(){
		int item = queue[front];
		front++;
		return item;
	}
}
