import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 키순서 : DFS+인접행렬+메모이제이션으로 풀기
public class SWEA5643_4 { // 1342ms

	static int N, M, ret;
	static int[][] adj;
	static int[][] radj;
	// static int[] small; // 자신보다 작은 학생 수 저장
	// static int[] tall; // 자신보다 큰 학생 수 저장
	// small, tall은 adj의 0열, 0행으로 대체할 수 있다.

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
		radj = new int[N + 1][N + 1];
		// small과 tall에는 자신보다 키 작은 사람과 큰 사람의 수를 저장한다.
		// Arrays.fill(small, -1); // 아직 탐색하지 않았음을 표시
		// Arrays.fill(tall, -1); // 아직 탐색하지 않았음을 표시
		for(int i=1;i<=N;i++) {
			adj[i][0] = -1;
			radj[i][0] = -1;
		}

		int a, b;
		for (int i = 0; i < M; i++) { // a의 키 < b의 키
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			adj[a][b] = 1;
			radj[b][a] = 1;
		}

		// debug
		// for(int[] arr : adj)System.out.println(Arrays.toString(arr));
		// System.out.println("small : " + Arrays.toString(small));
		// System.out.println("tall : " + Arrays.toString(tall));
	}

	static int solve() {
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if (dfs(i, adj) + dfs(i, radj) == N - 1)
				ans++;
		}
		// debug
		//System.out.println("small : " + Arrays.toString(small));
		//System.out.println("tall : " + Arrays.toString(tall));
		return ans;
	}

	static int dfs(int cur, int[][] g) {
		if (g[cur][0] != -1) return g[cur][0];
		for (int i = 1; i <= N; i++) {
			if (g[cur][i] != 1) continue;
			dfs(i, g);
			for (int j = 1; j <= N; j++) { // 나보다 작은 사람의 작은 사람 표시
				g[cur][j] = (g[i][j] == 1 || g[cur][j] ==1) ? 1 : 0;
			}
		}
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			cnt += g[cur][i];
		}
		return g[cur][0] = cnt;
	}
}