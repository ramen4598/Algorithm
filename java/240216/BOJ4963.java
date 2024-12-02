import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4963 {

	static int w, h;
	static boolean[][] vis;
	static char[][] map;
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1}; 
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();

		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			// 종료
			if(w == 0 && h == 0) break;

			// 초기화
			map = new char[h][w];
			vis = new boolean[h][w];
			
			// 지형 정보 입력
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			
			// bfs로 섬 개수 구하기
			int ret = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j]=='0') continue; //땅만
					if(vis[i][j]) continue; // 한 번도 안 간적 없는
					bfs(new int[]{i, j});
					ret++;
				}
			}
			
			sb.append(ret).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	private static int bfs(int[] start) {
		Queue<int[]> queue = new ArrayDeque<>();
			
		queue.offer(start);
		vis[start[0]][start[1]] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			// 8방위 탐색 후 연결된 좌표를 큐에 삽입
			for(int i=0; i<8; i++) {
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];
				boolean underflow = ny<0 || nx<0;
				boolean overflow = ny>=h || nx>=w;
				if(underflow||overflow) continue;
				if(map[ny][nx]=='0') continue; // 바다
				if(vis[ny][nx]) continue;
				queue.offer(new int[] {ny,nx}); // 땅
				vis[ny][nx] = true; // 방문체크
			}

		}
		
		return 0;
	}

}
