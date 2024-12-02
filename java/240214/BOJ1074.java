import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int ret =  solve(n, r, c);
		
		System.out.println(ret);
		br.close();
	}

	// 위치한 4분면에 따라서 순서를 계산
	// 재귀함수
	private static int solve(int n, int r, int c) {
		if(n == 0) { // 더 이상 4분면을 나눌 수 없을 때.
			return 0;
		}
		int seq = 0;
		
		int half = (int)Math.pow(2, n-1);
		if(r/half==1) seq += 2*half*half; // 4분면의 세로
		if(c/half==1) seq += half*half; // 4분면의 가로

		int nr = r%half; // 속한 4분면에서의 상대적 r
		int nc = c%half; // 속한 4분면에서의 상대적 r
		return seq + solve(n-1, nr, nc); // 4분면의 4분면의 4분면의 4분면의 ....
	}

}
