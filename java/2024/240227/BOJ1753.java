import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1753 {

	//static final int INF = Integer.MAX_VALUE;를 하면 안되는 이유
	static final int INF = 200001; // 최대 가중치 * 정점의 수 + 여유값
	static int V, E, K; // 정점 수, 간선 수, 시작점
	static int[] D; // 최단 경로를 저장하는 배열
	static List<Vertex>[] g;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());

		// 인접 리스트 초기화
		g = new List[V+1];
		for(int i=1, size=V+1; i<size; i++) {
			g[i] = new ArrayList<Vertex>();
		}
		int u, v, w;
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			g[u].add(new Vertex(v, w));
		}

		// 최단 경로 찾기
		solve();
		
		StringBuffer sb = new StringBuffer();
		for(int i=1, size=V+1; i<size; i++) {
			sb.append((D[i]==INF) ? "INF" : D[i]).append("\n");
		}

		System.out.println(sb);
		br.close();
	}
	
	// Dijkstra algoritm으로 최단 경로 비용 구하기
	static void solve() {
		boolean[] vis = new boolean[V+1];
		D = new int[V+1]; // 최단 경로를 저장하는 배열
		Arrays.fill(D,  INF);
		D[K] = 0; // 시작점 비용 초기화
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(K, D[K]));
		
		int cnt = 0;
		Vertex min;
		while(!pq.isEmpty()) {
			min = pq.poll();
			if(vis[min.v]) continue;
			vis[min.v]=true; 
			if(++cnt == V) break;
			
			for(Vertex tmp : g[min.v]) {
				if(vis[tmp.v]) continue;
				//final int INF = Integer.MAX_VALUE;를 하면 안되는 이유
				// Dijkstra에선 가중치를 더 하기 때문에 overflow가 발생할 수 있다.
				if(D[tmp.v] > D[min.v] + tmp.w) { 
					D[tmp.v] = D[min.v] + tmp.w;
					pq.offer(new Vertex(tmp.v, D[tmp.v]));
				}
			}
		}
	}
	
	static class Vertex implements Comparable<Vertex> {
		int v, w;
		
		public Vertex(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.w,  o.w);
		}
	}
}
