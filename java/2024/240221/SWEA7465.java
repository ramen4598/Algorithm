import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA7465 {

	static int N, M, ret;
	static List<Integer>[] g; // 인접 리스트
	static boolean[] vis;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();

		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			ret = 0;
			vis = new boolean[N+1]; // 1 ~ N

			// 인접리스트 초기화
			g = new List[N+1];
			for(int i=0; i<=N; i++) {
				g[i] = new ArrayList<Integer>();
			}
			int x, y;
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				g[x].add(y);
				g[y].add(x);
			}
			

			for(int i=1; i<=N; i++) { // 1 ~ N
				if(vis[i]) continue;
				dfs(i);
				ret++;
			}
			
			sb.append("#").append(tc).append(" ").append(ret).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	private static void dfs(int idx) {
		vis[idx] = true;
		
		for(Integer next : g[idx]) {
			if(vis[next]) continue;
			dfs(next);
		}
	}

}
