
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 키순서 
public class SWEA5643_3 { // 2023ms

	static int N, M, cnt, ret;
	static int[][] adj, radj;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=T; tc++) {
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

		int a, b;
		adj = new int[N+1][N+1];
		radj = new int[N+1][N+1];
		for(int i=0; i<M; i++) { // a의 키 < b의 키
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			adj[a][b] = 1;
			radj[b][a] = 1;
		}
	}
	static int solve() {
		int ans = 0;
		for(int i=1; i<=N; i++) {
			cnt = 0;
			dfs(i, new boolean[N+1], adj);
			dfs(i, new boolean[N+1], radj);
			if(cnt == N-1) ans++;
		}
		return ans;
	}
	static void dfs(int cur, boolean[] vis, int[][] graph) {
		vis[cur] =true;
		for(int i=1; i<=N; i++) {
			if(graph[cur][i]==1 && !vis[i]) {
				cnt++;
				dfs(i, vis, graph);
			}
		}
	}
}