import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2644 {

	static int n, p1, p2, m;
	static Node[] adjList;
	static boolean[] vis;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 초기화
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		p1 = Integer.parseInt(st.nextToken());
		p2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		adjList = new Node[n+1]; // 인덱스는 1번 부터 시작
		vis = new boolean[n+1];
		
		// 관계 저장 - 연결 리스트
		int x, y;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken()); // 부모
			y = Integer.parseInt(st.nextToken()); // 자식

			// 양방향 그래프
			adjList[x] = new Node(y, adjList[x]);
			adjList[y] = new Node(x, adjList[y]);
		}
		
		System.out.println(bfs(p1));
		br.close();
		
	}
	
	private static int bfs(int p1) {
		Queue<Integer> queue = new ArrayDeque<>();
		
		queue.offer(p1);
		vis[p1] = true;

		int size, cur, cnt=0;
		while(!queue.isEmpty()) {
			size = queue.size();
			for(int i=0; i<size; i++) { // breath(= 1촌) 단위로 탐색 
				cur = queue.poll();
				if(cur==p2) return cnt; // p2 도달

				for(Node tmp=adjList[cur]; tmp!=null; tmp=tmp.next) {
					if(vis[tmp.to]) continue;
					queue.offer(tmp.to);
					vis[tmp.to]=true;
				}
			}
			cnt++;// 촌수 증가
		}
		return -1;	
	}
	
	static class Node{
		int to;
		Node next;
		
		Node(int to, Node next){
			this.to = to;
			this.next = next;
		}
		
		@Override
		public String toString() {
			return " to="+to+next;
		}
	}

}
