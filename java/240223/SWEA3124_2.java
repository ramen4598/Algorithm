import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// PQ를 활용한 Prim algorithm으로 구현하기
public class SWEA3124_2 {

	static int V, E;
	static List<Vertex>[] g;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			// 인접 리스트 초기화
			g = new List[V+1]; // 1 ~ V
			for(int i=1; i<=V; i++) {
				g[i] = new ArrayList<>();
			}
			int A, B, C;
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				A = Integer.parseInt(st.nextToken());
				B = Integer.parseInt(st.nextToken());
				C = Integer.parseInt(st.nextToken());
				g[A].add(new Vertex(B, C));
				g[B].add(new Vertex(A, C));
			}
			
			// 최소 신장 트리의 비용 구하기
			long ret = solve();
			sb.append("#").append(tc).append(" ").append(ret).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	static long solve() {
		boolean[] vis = new boolean[V+1];
		int[] D = new int[V+1];
		Arrays.fill(D,  Integer.MAX_VALUE);
		D[1] = 0;

		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(1, D[1]));

		Vertex cur;
		int cnt = 0;
		long ret = 0;
		while(!pq.isEmpty()) {
			cur = pq.poll();
			if(vis[cur.no]) continue;

			vis[cur.no]=true; 
			ret += D[cur.no];
			if(++cnt == V) break;

			for(Vertex vertex : g[cur.no]) {
				if(vis[vertex.no]) continue;
				if(D[vertex.no] > vertex.weight) { // D에 저장된 기존의 비용보다 작은 새로운 비용이 있다면...
					D[vertex.no] = vertex.weight; // D를 갱신하고
					pq.offer(vertex);// PQ에 삽입한다.
				}
			}
		}
		return ret;
	}
	
	static class Vertex implements Comparable<Vertex> {
		int no, weight;
		
		Vertex (int no, int weight){
			this.no = no;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);	
		}
	}

}
