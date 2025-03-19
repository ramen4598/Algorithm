import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dfs로 풀기 + 별도의 방문체크 배열을 생성하지 않고 풀기
public class BOJ4963_2 {

	static int w, h, cnt;
	static int[][] map;
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0 ,-1};
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h==0) break; // 종료
			
			// map 초기화
			map = new int[h][w];
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 섬의 개수 세기
			cnt = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j]==0) continue;
					if(map[i][j]>1) continue;
					solve(i, j);
					cnt++;
				}
			}

			sb.append(cnt).append("\n");
		}

		System.out.println(sb);
		br.close();
	}
	
	// dfs
	static void solve(int y, int x) {
		map[y][x]++;
		// 8방향 탐색
		for(int d=0; d<8; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			boolean under = ny < 0 || nx < 0;
			boolean over = ny >= h || nx >= w;
			if(under || over) continue;
			
			if(map[ny][nx]==0) continue; // 바다다.
			if(map[ny][nx] > 1) continue; // 방문한 적 있다.
			solve(ny, nx);
		}
	}

}
