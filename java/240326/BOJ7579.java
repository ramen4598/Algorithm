import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 앱
public class BOJ7579 {
	// 앱의 수, 필요한 메모리의 크기, 전체 비용의 합, 그래도 유지할 수 있는 메모리의 최대 크기
	static int N, M, cSum, limit, ret; 
	static int[] m, c; // 앱의 메모리 크기, 비활성화 비용
	static int dp[][]; // 발생하지 않는 비활성화 비용의 최대값을 구하는 DP tabel
	
	public static void main(String[] args) throws Exception {
		init();
		solve();
		System.out.println(ret);
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int mSum = 0;
		m = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			m[i] = Integer.parseInt(st.nextToken());
			mSum += m[i];
		}
		limit = mSum - M;

		c = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			c[i] = Integer.parseInt(st.nextToken());
			cSum += c[i];
		}
	
		dp = new int[N+1][limit + 1];
	}
	
	static void solve() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=limit; j++) {
				if(j >= m[i]) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-m[i]] + c[i]);
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		ret = cSum - dp[N][limit];
	}
}
