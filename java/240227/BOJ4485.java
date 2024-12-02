import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Dijkstra algorithm 
// FOR문으로 구현 -> 774ms
public class BOJ4485 {
	
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
	
	// Dijkstra algorithm - FOR문으로 구현 O(V^2)
	static void solve() {
		final int INF = 200000;
		int[][] D = new int[N][N]; // 시작점에서 부터 최단 거리 비용을 저장하는 배열
		boolean[][] vis = new boolean[N][N];

		for(int[] arr : D){
			Arrays.fill(arr, INF); // 125*125*10 = 156250
		}
		D[0][0] = map[0][0]; // 시작점
		
		// 방문하지 않은 정점 중에서 시작점에서 가장 가까운 정점 선택
		while(true){
            int[] min = {-1, -1};
            int minDistance = INF;
            for(int y=0; y<N; y++) {
                for(int x=0; x<N; x++) {
                    if(vis[y][x]) continue;
                    if(minDistance > D[y][x]) {
                        min = new int[] {y, x};
                        minDistance = D[y][x];
                    }
                }
            }
			if(min[0] == N-1 && min[1] == N-1) break;
            vis[min[0]][min[1]] = true;
            
            // 갱신
            int ny, nx;
            for(int j=0; j<4; j++) {
                // 4방향 탐색 
                ny = min[0] + dy[j];
                nx = min[1] + dx[j];
                
                boolean under  = ny<0||nx<0;
                boolean over = ny>= N||nx>=N;
                if(under||over) continue;
                if(vis[ny][nx]) continue;
                
                // D 갱신
                if(D[ny][nx] > D[min[0]][min[1]] + map[ny][nx]){
                    D[ny][nx] = D[min[0]][min[1]] + map[ny][nx];
                }
            }
		}
		
		ret = D[N-1][N-1];
	}
}
