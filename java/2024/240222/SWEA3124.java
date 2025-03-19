import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA3124 {

	static int V, E; 
	static long ret; // int overflow 발생
	static int[] p; // 노드의 부모 노드 인덱스를 저장
	static Edge[] edgeList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();

		int T = Integer.parseInt(st.nextToken());

		for(int tc=1; tc<=T; ++tc) {
			st  = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			ret = 0; // MST의 최소 비용
			
			// 간선 리스트 초기화
			edgeList = new Edge[E];
			int from, to, weight;
			for(int i=0; i<E; i++) {
				st  = new StringTokenizer(br.readLine());
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				weight = Integer.parseInt(st.nextToken());
				edgeList[i] = new Edge(from, to, weight);
			}
			Arrays.sort(edgeList);
			
			// Union-Find을 활용한 MST의 최소 비용 구하기
			make();
			int cnt = 0;
			for(Edge edge : edgeList) {
				if(!union(edge.from, edge.to)) continue;
				ret += edge.weight;
				if(++cnt > V-1) break;
			}
			
			sb.append("#").append(tc).append(" ").append(ret).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void make() {
		p = new int[V+1]; // 1 ~ V
		for(int i=0; i<V; i++) {
			p[i] =i;
		}
	}
	
	static int find(int x) {
		return (x==p[x]) ? x : (p[x] = find(p[x]));
	}
	
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) return false;
		p[y] = x;
		return true;
	}
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}

}
