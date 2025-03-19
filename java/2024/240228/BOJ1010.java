import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DP - 조합
public class BOJ1010 {
	
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			sb.append(solve()).append("\n");
		}

		System.out.println(sb);
		br.close();
	}
	// DP로 mCr을 구한다.	
	static int solve() {
		int[][] dp = new int[M+1][N+1]; // 파스칼의 삼각형로 mCn 구하기

		for(int i=0; i<=M; i++) {
			for(int j=0, end=Math.min(i, N); j<=end; j++) {
				if(j==0 || j==i) dp[i][j] = 1;
				else dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		
		return dp[M][N];	
	}

}
