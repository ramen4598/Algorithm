import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Dijkstra algorithm 
// PQ로 구현 -> 176ms
public class BOJ4485_2 {
	
	static int N, ret;
	static int[][] map;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		
		int tc = 0;
		while(true) {
			ret = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			
			// 동굴 초기화
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			solve();

			sb.append("Problem ").append(++tc).append(": ").append(ret).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	// Dijkstra algorithm - PQ로 구현 O(ElogE)
	static void solve() {
		final int INF = 200000;
		int[][] D = new int[N][N]; // 시작점에서 부터 최단 거리 비용을 저장하는 배열
		boolean[][] vis = new boolean[N][N];

		for(int[] arr : D){
			Arrays.fill(arr, INF); // 125*125*10 = 156250
		}
		D[0][0] = map[0][0]; // 시작점
		
		PriorityQueue<Data> pq = new PriorityQueue<>();
		pq.offer(new Data(0, 0, D[0][0]));

		// 방문하지 않은 정점 중에서 시작점에서 가장 가까운 정점 선택
		Data min;
		while(!pq.isEmpty()){
			min = pq.poll();	

			if(min.y == N-1 && min.x == N-1) break;
            vis[min.y][min.x] = true;
            
            // 갱신
            int ny, nx;
            for(int j=0; j<4; j++) {
                // 4방향 탐색 
                ny = min.y + dy[j];
                nx = min.x + dx[j];
                
                boolean under  = ny<0||nx<0;
                boolean over = ny>= N||nx>=N;
                if(under||over) continue;
                if(vis[ny][nx]) continue;
                
                // D 갱신
                if(D[ny][nx] > D[min.y][min.x] + map[ny][nx]){
                    D[ny][nx] = D[min.y][min.x] + map[ny][nx];
					pq.offer(new Data(ny, nx, D[ny][nx]));
                }
            }
		}
		
		ret = D[N-1][N-1];
	}

	static class Data implements Comparable<Data> {
		int y, x;
		int weight;

		Data(int y, int x, int weight){
			this.y = y;
			this.x = x;
			this.weight = weight;
		}

		@Override
		public int compareTo(Data o){
			return Integer.compare(this.weight, o.weight);
		}
	}
}
