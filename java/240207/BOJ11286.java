import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ11286 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(new MyComparator());
		StringBuffer sb =new StringBuffer();

		int N = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());

			if(num==0) { // 삭제
				Integer tmp = pq.poll();
				tmp = tmp==null ? 0 : tmp; // 배열이 비었으면 0 출력
				sb.append(tmp).append("\n");
			}else { // 삽입
				pq.offer(num);
			}
		}
		
		// 출력
		System.out.println(sb.toString());
		br.close();
	}
	
	static class MyComparator implements Comparator<Integer>{
		@Override
		public int compare(Integer o1, Integer o2) {
			int ao1 = Math.abs(o1);
			int ao2 = Math.abs(o2);
			if(ao1 == ao2) {
				return Integer.compare(o1, o2);
			}
			return Integer.compare(ao1, ao2);
		}
	}

}
