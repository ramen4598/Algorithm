import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N  = sc.nextInt();
		Queue<Integer> queue = new ArrayDeque<>();
		
		//카드 초기화
		for(int i=1; i<=N; i++) {
			queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			//마지막 카드
			if(queue.size()==1) {
				System.out.println(queue.poll());
				break;
			}
			queue.poll();
			queue.offer(queue.poll());
		}
		sc.close();
	}
}
