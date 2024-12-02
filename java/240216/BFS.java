import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {

	static int n, m;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static boolean[][] vis;
	static char[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//n,m,vis 초기화
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		vis = new boolean[n+1][m+1];
		
		// map 초기화
		char[] input;
		map = new char[n+1][m+1];
		for(int i=1; i<=n; i++) {
			input = br.readLine().toCharArray();
			for(int j=1; j<=m; j++) {
				map[i][j] = input[j-1];
			}
		}

		System.out.println(bfs());
		br.close();
	}
	
	private static int bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		
		queue.offer(new int[] {1,1});
		vis[1][1] = true;

		int[] cur;
		int size, cnt=0;
		while(!queue.isEmpty()) {
			size = queue.size();

			for(int i=0; i<size; i++) {
				cur = queue.poll();

				if(cur[0]==n && cur[1]==m) // 탐색 종료
					return cnt;

				for(int dir=0; dir<4; dir++) { // 너비 단위로 처리
					int ny = cur[0] + dy[dir];
					int nx = cur[1] + dx[dir];
					boolean underflow = ny<1 || nx<1;
					boolean overflow = ny>n || nx>m;
					if(underflow||overflow) continue;

					if(map[ny][nx]=='0') continue; // 못 감
					if(vis[ny][nx]) continue; // 방문 체크
					queue.offer(new int[] {ny, nx});
					vis[ny][nx] = true;
				}
			}
			cnt++;
		}
		
		return -1;
	}

}
