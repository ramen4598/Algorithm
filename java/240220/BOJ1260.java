import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {

	static int N, M, V;
	static List<Integer>[] lists; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		// 인접 행렬
		lists = new List[N+1];
		for(int i=0; i<=N; i++) {
			lists[i] = new ArrayList<Integer>();
		}

		int from, to;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			// 양방향 간선
			lists[from].add(to);
			lists[to].add(from);
		}
		// 연결된 노드들을 오름차순으로 정렬
		for(List<Integer> list : lists) {
			Collections.sort(list);
		}
		
		dfs(V, new boolean[N+1], sb);
		sb.append("\n");
		bfs(V, sb);
		System.out.println(sb);

		br.close();
	}
	
	static void dfs(int idx, boolean[] vis, StringBuffer sb) {
		vis[idx] = true;
		sb.append(idx).append(" ");

		for(Integer next : lists[idx]) {
			if(vis[next]) continue;
			dfs(next, vis, sb);
		}
	}

	static void bfs(int idx, StringBuffer sb) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		boolean[] vis = new boolean[N+1];
		q.offer(idx);
		vis[idx] = true;

		int cur;
		while(!q.isEmpty()) {
			cur = q.poll();
			sb.append(cur).append(" ");
			
			for(Integer i : lists[cur]) {
				if(vis[i]) continue;
				q.offer(i);
				vis[i] = true;
			}
		}
	}

}
