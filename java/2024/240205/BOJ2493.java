import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력 
		int N = Integer.parseInt(st.nextToken());
		int[] map = new int[N+1];
		int[] ret = new int[N+1];

		// 높이
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		// 수신받는 타워 구하기
		Stack<Integer> stk = new Stack<>();
		for(int i=N; i>0; i--) { // 뒤에서부터
			while(!stk.isEmpty()) {
				// 감소세
				if(map[i] < map[stk.peek()]) break;
				//상승세
				ret[stk.pop()] = i;
			}
			stk.push(i);
		}
		//출력
		StringBuffer sb = new StringBuffer();
		for(int i=1; i<=N; i++) {
			sb.append(ret[i]).append(" ");
		}
		System.out.println(sb.toString());

		br.close();
	}

}
