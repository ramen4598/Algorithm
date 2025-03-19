
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 키순서 : DFS+인접행렬로 풀기
public class SWEA5643_2 { // 3093ms

	static int N, M, cnt, ret;
	static int adj[][];

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
		for(int i=0; i<M; i++) { // a의 키 < b의 키
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			adj[a][b] = 1;
		}
	}
	static int solve() {
		int ans = 0;
		for(int i=1; i<=N; i++) {
			cnt = 0;
			gtDFS(i, new boolean[N+1]);
			ltDFS(i, new boolean[N+1]);
			if(cnt == N-1) ans++;
		}
		return ans;
	}
	static void gtDFS(int cur, boolean[] vis) {
		vis[cur] =true;
		for(int i=1; i<=N; i++) {
			if(adj[cur][i]==1 && !vis[i]) {
				cnt++;
				gtDFS(i, vis);
			}
		}
	}
	static void ltDFS(int cur, boolean[] vis) {
		vis[cur] =true;
		for(int i=1; i<=N; i++) {
			if(adj[i][cur]==1 && !vis[i]) {
				cnt++;
				ltDFS(i, vis);
			}
		}
	}
}
