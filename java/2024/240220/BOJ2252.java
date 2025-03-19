import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2252 {

	static int N, M; // 정점의 수, 간선의 수
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점
		M = Integer.parseInt(st.nextToken()); // 간선
		
		ArrayList<Integer>[] list = new ArrayList[N+1]; // 1 ~ N
		int size = N+1;
		for(int i=0; i<size; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		// 진입 차수 관리
		int[] inDegree = new int[N+1];
		// 연결 리스트
		int from, to;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			list[from].add(to); 
			inDegree[to]++; // 진입 차수 개수를 센다.

		}
		// 구현 (위상 정렬)(BFS로 구현)
		ArrayList<Integer> res = new ArrayList<>();
		Queue<Integer> q = new ArrayDeque<>();
		// 1. 진입 차수가 0인 노드를 큐에 넣는다.
		for(int i=1; i<size; i++) { // 1 ~ N
			if(inDegree[i]==0) q.offer(i);
		}
		while(!q.isEmpty()) {
			// 2. 꺼낸 노드와 인접한 모든 노드들에 대하여 간선을 제거한다. (= 진입 차수를 1 감소)
			int cur = q.poll();
			res.add(cur);
			for(int idx : list[cur]) {
				inDegree[idx]--;
				// 3. 간선 제거 후 진입 차수가 0이 된 노드를 큐에 넣는다.
				if(inDegree[idx] == 0)
					q.offer(idx);
			}
		}
		// res.size() == N이면 위상 정렬 성공
		// res.size() != N이면 위상 정렬 실패
		
		// 출력
		StringBuffer sb = new StringBuffer();
		for(Integer i : res) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
		br.close();
	}
}
