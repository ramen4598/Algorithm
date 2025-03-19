import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 키순서 : DFS+인접행렬+메모이제이션으로 풀기
public class SWEA5643_5 { // 721 ms

	static int N, M, ret;
	static int[][] adj;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			init(br, st);
			ret = solve();
			sb.append("#").append(tc).append(" ").append(ret).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	static void init(BufferedReader br, StringTokenizer st) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());

		adj = new int[N + 1][N + 1];
		for(int i=1;i<=N;i++) {
			adj[i][0] = -1;
		}

		int a, b;
		for (int i = 0; i < M; i++) { // a의 키 < b의 키
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			adj[a][b] = 1;
		}
	}

	static int solve() {
		int ans = 0;
		// 자신보다 작은 사람
		for (int i = 1; i <= N; i++) 
			dfs(i);
		// 자신보다 큰 사람
		for (int i = 1; i <= N; i++) {
			for(int j=1; j<=N; j++) {
				adj[0][i] += adj[j][i];
			}
		}
		for(int i=1; i<=N; i++) {
			if (adj[i][0] + adj[0][i] == N - 1) ans++;
		}
		return ans;
	}

	static void dfs(int cur) {
		if (adj[cur][0] != -1) return;
		for (int i = 1; i <= N; i++) {
			if (adj[cur][i] != 1) continue;
			dfs(i);
			for (int j = 1; j <= N; j++) { // 나보다 작은 사람의 작은 사람 표시
				adj[cur][j] = (adj[i][j] == 1 || adj[cur][j] ==1) ? 1 : 0;
			}
		}
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			cnt += adj[cur][i];
		}
		adj[cur][0] = cnt;
		return;
	}
}