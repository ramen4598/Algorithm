import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FloydWarshallTest {

	static final int INF = 1000000;
	static int[][] dp;
	static int n, m; // 노드의 수, 간선의 수
	public static void main(String[] args) throws Exception {
		init();
		solve();
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		dp = new int[n][n];
		for(int i=0; i<n; i++) {
			Arrays.fill(dp[i],  INF);
			dp[i][i] = 0;
		}
		
		int from ,to;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			dp[from][to] = Integer.parseInt(st.nextToken()); // 간선 정보 입력
		}
	}
	
	static void solve() {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
		for(int k=0; k<n; k++) {
					if(dp[i][k]+dp[k][j] < dp[i][j]) {
						dp[i][j] = dp[i][k] + dp[k][j];
					}
					print(i, j);
				}
			}
		}
	}
	
	static void print(int curY, int curX) {
		StringBuffer sb = new StringBuffer();
		for(int y=0; y<n; y++) {
			for(int x=0; x<n; x++) {
				if(y==curY && x==curX) sb.append("* ");
				else if(dp[y][x] == INF) sb.append("~ ");
				else sb.append(dp[y][x] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
