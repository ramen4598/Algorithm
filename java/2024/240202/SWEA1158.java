import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Scanner;

public class SWEA1158 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Integer> queue = new ArrayDeque<>();
		int idx = 0;
		while(idx < N){
			idx++;
			queue.offer(idx);
		}

		StringBuffer sb = new StringBuffer();
		sb.append("<");
		while(!queue.isEmpty()){
			for(int i=K; i>1; i--){
				queue.offer(queue.poll());
			}
			sb.append(queue.poll());
			if(!queue.isEmpty())
				sb.append(", ");
		}
		sb.append(">");

		System.out.println(sb);
		sc.close();
	}
}
