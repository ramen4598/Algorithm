import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 평범한 배낭
public class BOJ12865 {
	static int N, K, ret; // 개수, 최대 무게, 출력값
	static int[] W, V; // 물건의 무게, 가치
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		init();
		solve();
		System.out.println(ret);
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		ret = 0;
		
		// dp 초기화
		dp = new int[N+1][K+1];
	}
	
	static void solve() {
		// 상향식 dp
		for(int y=1; y<=N; y++) {
			for(int x=1; x<=K; x++) {
				if(x >= W[y]) { // y번 물건을 추가할 수 있다면
					dp[y][x] = Math.max(dp[y-1][x], dp[y-1][x-W[y]] + V[y]);
				}else { // 추가할 수 없다면
					dp[y][x] = dp[y-1][x];
				}
			}
		}
		ret = dp[N][K];
	}

}
