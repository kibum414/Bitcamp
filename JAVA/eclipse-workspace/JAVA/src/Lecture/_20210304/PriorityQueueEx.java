package Lecture._20210304;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueEx {

	public static void main(String[] args) {
		Queue pq = new PriorityQueue();
		
		// PriorityQueue는 무작위로 삽입됨 (Queue는 add 순서대로)
		pq.offer(3); // add 써도 됨
		pq.offer(1);
		pq.offer(5);
		pq.offer(2);
		pq.offer(4);
		
		System.out.println(pq); // pq의 내부 배열을 출력
		
		Object obj = null;
		
		// PriorityQueue에 저장된 요소를 하나씩 꺼낸다.
		while ((obj = pq.poll()) != null)
			System.out.println(obj);
		// while (!pq.isEmpty())
		// 	System.out.println(pq.remove());
	}

}
