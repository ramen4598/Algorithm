import java.io.*;
import java.util.StringTokenizer;


public class SWEA5215 {

	static int n , l, ret;
	static int[] cals, scores; //칼로리, 점수를 저장하는 배열
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			ret = 0;
			
			//입력
			scores = new int[n];
			cals = new int[n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				scores[i] = Integer.parseInt(st.nextToken());
				cals[i] = Integer.parseInt(st.nextToken());
			}
			
			solve(0, 0, 0);
			
			//조건을 만족하는 최대 점수 출력
			System.out.printf("#%d %d%n", tc, ret);
			
		}
		br.close();
	}
	
	public static void solve(int depth, int calSum, int scoreSum) {
		if(calSum > l) return; //가지치기
		if(depth == n) {
			//if(calSum > l) return; // 제한 칼로리보다 이하만 가능.
			ret=Math.max(ret, scoreSum);
			return;
		}
		
		//포함
		solve(depth+1, calSum+cals[depth], scoreSum + scores[depth]);
		//미포함
		solve(depth+1, calSum, scoreSum);
	}

}
