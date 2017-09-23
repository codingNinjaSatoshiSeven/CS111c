import java.util.*;

public class HomeworkW13Driver {

	public static void main(String[] args) {

		// Q5 splice client
		QueueInterface<Integer> q1 = new LinkedQueue<Integer>();
		q1.enqueue(4);
		q1.enqueue(8);
		q1.enqueue(9);
		q1.enqueue(2);
		QueueInterface<Integer> q2 = new LinkedQueue<Integer>();
		q2.enqueue(1);
		q2.enqueue(3);
		q2.enqueue(7);
		q2.enqueue(6);
		splice(q1, q2);
		System.out.println("q1 contains: \n4 8 9 2 1 3 7 6");
		((LinkedQueue)q1).display();
		System.out.println("q2 still contains: \n1 3 7 6");
		((LinkedQueue)q2).display();
		
		// Q6 splice ArrayQueue
		ArrayQueue<Integer> aq1 = new ArrayQueue<Integer>();
		aq1.enqueue(4);
		aq1.enqueue(8);
		aq1.enqueue(9);
		aq1.enqueue(2);
		ArrayQueue<Integer> aq2 = new ArrayQueue<Integer>();
		aq2.enqueue(1);
		aq2.enqueue(3);
		aq2.enqueue(7);
		aq2.enqueue(6);
		aq1.splice(aq2);
		System.out.println("q1 contains: \n4 8 9 2 1 3 7 6");
		aq1.display();
		System.out.println("q2 still contains: \n1 3 7 6");
		aq2.display();
		
		// Q7 splice LinkedQueue
		LinkedQueue<Integer> lq1 = new LinkedQueue<Integer>();
		lq1.enqueue(4);
		lq1.enqueue(8);
		lq1.enqueue(9);
		lq1.enqueue(2);
		LinkedQueue<Integer> lq2 = new LinkedQueue<Integer>();
		lq2.enqueue(1);
		lq2.enqueue(3);
		lq2.enqueue(7);
		lq2.enqueue(6);
		lq1.splice(lq2);
		System.out.println("q1 contains: \n4 8 9 2 1 3 7 6");
		lq1.display();
		System.out.println("q2 still contains: \n1 3 7 6");
		lq2.display();

		// Q8
		DequeQueue<Integer> dq = new DequeQueue<Integer>();
		dq.enqueue(1);
		dq.enqueue(2);
		dq.display();

		DequeStack<Integer> ds = new DequeStack<Integer>();
		ds.push(1);
		ds.push(2);
		ds.display();

		DQList<Integer> dl = new DQList<Integer>();
		dl.addToFront(1);
		dl.addToFront(2);
		dl.addToBack(3);
		dl.display();
	}		

	public static void splice(QueueInterface firstQueue, QueueInterface secondQueue) {
		QueueInterface<Integer> tempQueue = new LinkedQueue<Integer>();
		while (!secondQueue.isEmpty()){
			Integer num = (Integer) secondQueue.dequeue();
			firstQueue.enqueue(num);
			tempQueue.enqueue(num);
		}
		while (!tempQueue.isEmpty()){
			secondQueue.enqueue(tempQueue.dequeue());
		}
	}

}