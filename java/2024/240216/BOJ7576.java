import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {

	static int n, m, ret; 
	static int[][] map;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static boolean[][] vis; // bfs 시작점으로 사용했는가?
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 초기화
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		vis =  new boolean[n][m];
		
		// 토마토 상자 초기화
		boolean already = true; // 처음부터 모두 익었다?
		map =new int[n][m];
		for(int y=0; y<n; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<m; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if(map[y][x]==0) already = false; // 덜 익은 토마토 있음
			}
		}
		if(already) {
			System.out.println(0);
			return;
		}
		
		// 토마토 상자가 익는데 필요한 시간
		ret = bfs();

		// 덜 익었으면 -1
		check();
				
		System.out.println(ret);
		br.close();
	}
	
	// 토마토가 익는데 필요한 시간
	private static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		
		// 시작부터 익어있는 모든 토마토 추적
		for(int y=0; y<n; y++) {
			for(int x=0; x<m; x++) {
				if(map[y][x] != 1) continue;
				q.offer(new int[] {y,x});
				vis[y][x]=true;
			}
		}
		
		int[] cur;
		int size, cnt=0;
		while(!q.isEmpty()) {
			size = q.size();

			for(int i=0; i<size; i++) {
				cur = q.poll();

				int ny, nx;
				for(int d=0; d<4; d++) { // 4방위 탐색
					ny = cur[0] + dy[d];
					nx = cur[1] + dx[d];
					
					boolean underflow = ny<0 || nx<0;
					boolean overflow = ny>=n || nx>=m;
					if(underflow || overflow) continue;
					
					// 익은 토마토 주변 덜익은 토마토 탐색
					if(map[ny][nx]!=0) continue; 
					if(vis[ny][nx]) continue;
					q.offer(new int[] {ny, nx});
					vis[ny][nx] = true;
				}
			}
			cnt++;
		}

		return cnt-1;
	}
	
	// 안 익은 토마토가 있는가
	private static void check() {
		for(int y=0; y<n; y++) {
			for(int x=0; x<m; x++) {
				if((map[y][x] ==0) && !vis[y][x]) { 
					ret = -1;
					return;
				}
			}
		}
	}

}
