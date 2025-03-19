import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 이 문제는 모든 노드가 서로 연결될 수 있는 완전 그래프다.
// 매우 많은 간선이 생길 수 있다. E = ((V-1)V)/2
// Kruskal으로 풀기 ->  시간 복잡도 O(ElogE + V) -> 간선이 많은 밀집 그래프에서 불리
// PQ로 구현한 Prim -> 시간 복잡도 O(ElogE) -> 간선이 많은 밀집 그래프에서 불리
// 반복문으로 구현한 Prim -> 시간 복잡도 O(E*V^2) -> 밀집 그래프에 유리!

// 반복문으로 구현한 Prim 알고리즘으로 풀기
// But! PQ로 구현한 Prim 알고리즘으로 풀면 더 빠르다! -> 가지치기의 효과

// 반복문으로 구현한 Prim
public class SWEA1251 {

	static int N; // 섬의 수
	static double E;
	static int[][] points; // 섬의 x, y 좌표를 저장하는 배열
	static long[][] adjMatrix; // 섬 간의 거리의 제곱을 저장하는 인접 행렬 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++){
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			// 섬들의 좌표를 저장
			points = new int[N][2]; // N번째 섬의 x, y 좌표
			for(int i=0; i<2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					points[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 인접 행렬 생성
			adjMatrix = new long[N][N];
			for(int from=0; from<N; from++) {
				for(int to=0; to<N; to++) {
					adjMatrix[from][to] = adjMatrix[to][from] = getDis(from, to); // 무방향 그래프
				}
			}
			
			st = new StringTokenizer(br.readLine());
			E = Double.parseDouble(st.nextToken());

			sb.append("#").append(tc).append(" ").append(Math.round(solve()*E)).append("\n");	
		}

		System.out.println(sb);
		br.close();
	}

	static long getDis(int from, int to) {
		int dx = points[from][0] - points[to][0];
		int dy = points[from][1] - points[to][1];
		return (long)(Math.pow(dx, 2) + Math.pow(dy, 2));
	}
	
	static long solve() {
		long ret = 0;

		boolean[] vis = new boolean[N];
		long[] D = new long[N]; // 비트리 정점 기준으로 트리 정점과 연결하기 위한 최소 간선 비용 저장
		Arrays.fill(D,  Long.MAX_VALUE);
		D[0] = 0;
		
		long min;
		int cnt = 0, minVertex;
		for(cnt = 0; cnt<N; cnt++) {
			min = Long.MAX_VALUE;
			minVertex = -1;
			
			for(int i=0; i<N; i++) { // 새로 연결할 비트리 정점 선택
				if(vis[i]) continue;
				if(min > D[i]) {
					min = D[i];
					minVertex = i;
				}
			}
			
			if(minVertex == -1) break;

			vis[minVertex] = true;
			ret += min;
			
			// D 배열 업데이트
			for(int i=0; i<N; i++) {
				if(vis[i]) continue;
				//if(adjMatrix[minVertex][i] == 0) continue;
				if(D[i] > adjMatrix[minVertex][i]) {
					D[i] = adjMatrix[minVertex][i];
				}
			}
		}
		return (cnt == N) ? ret : -1;
	}

}
