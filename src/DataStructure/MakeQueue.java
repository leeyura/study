package DataStructure;

/**
 * @author yul
 */
public class MakeQueue {
	public static void main(String[] args) {
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
		/*
		 * 결과 peak : null peak : 0 peak : 10 peak : 20 peak : 30
		 */
	}
}

class Queue {
	// head & insert
	int front = 0;
	// delete
	int rear = -1;
	int[] queue;
	int size;

	/**
	 * queue 생성
	 * 
	 * @param size
	 */
	public Queue(int size) {
		queue = new int[size];
		this.front = 0;
		this.rear = -1;
		this.size = size;
	}

	/**
	 * queue의 공백 여부
	 * 
	 * @return boolean
	 */
	public boolean empty() {
		return (front == rear + 1);
	}

	/**
	 * queue의 front 값을 알려줌
	 */
	public void peak() {
		if (empty()) {
			System.out.println("peak :  null");
		}
		System.out.println("peak : " + queue[front]);
	}

	/**
	 * queue에 값을 추가
	 * 
	 * @param value
	 */
	public void offer(int value) {
		queue[++rear] = value;
	}

	/**
	 * queue의 (front)값을 제거
	 * 
	 * @return item
	 */
	public int poll() {
		int item = queue[front];
		front++;
		return item;
	}
}
