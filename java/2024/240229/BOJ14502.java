import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 {

	static int N, M, wall, max; // 세로, 가로, 초기 벽의 수, 안전공간의 최대 크기
	static int[][] map;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	static ArrayList<int[]> v; // 바이러스 좌표 저장
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		v = new ArrayList<int[]>();
		
		// 연구소 초기화
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 바이러스를 찾는다.
				if(map[i][j]==2) v.add(new int[] {i, j});
				if(map[i][j]==1) wall++; // 초기 벽의 수 세기
			}
		}
	
		solve(0, 0);
		
		System.out.println(max);
		br.close();
	}
	
	// 모든 0 즉 빈 공간에 대하여 벽을 3개 세운다.
	static void solve(int depth, int start) {
		if(depth == 3) {
			// 안전 공간의 최댓값을 구한다.
			max = Math.max(max, count());
			return;
		}
		
		// 2차원 배열의 좌표로 조합
		int y, x;
		for(int i=start, end=N*M; i<end; i++) {
			y = i/M;
			x = i%M;
			if(map[y][x] == 1 || map[y][x]== 2 || map[y][x] == 3) continue;
			map[y][x] = 3; // 벽 세우기
			solve(depth+1, i+1); // 재귀
			map[y][x] = 0;// 원복
		}
	}
	// 안전 공간의 크기를 센다
	static int count() {
		int cnt = 0; // 감염되는 공간
		// 모든 바이러스를 시작점으로 BFS 탐색
		boolean[][] vis = new boolean[N][M];
		Queue<int[]> q = new ArrayDeque<>();
		for(int[] yx : v) {
			vis[yx[0]][yx[1]] = true;
			q.add(yx);
		}
		// 감염 공간의 수를 센다.
		int[] cur;
		while(!q.isEmpty()) {
			cur = q.poll();
			cnt++;

			int ny, nx;
			for(int d=0; d<4; d++) { //4방 탐색으로 새로 감염될 안전공간을 찾는다.				ny = cur[0] + dy[d];
				ny = cur[0] + dy[d];
				nx = cur[1] + dx[d];
				if(ny<0||nx<0||ny>=N||nx>=M) continue;
				if(vis[ny][nx]) continue;
				if(map[ny][nx] != 0) continue; // 안전 공간만
				//큐에 추가
				vis[ny][nx] = true;
				q.add(new int[] {ny, nx});
			}
		}
//		if((N*M - cnt - 3 - wall)!=0) {
//			System.out.println("N*M : " + N*M + " 감염공간 : " + cnt + " 초기 벽의 수 : " + wall);
//			System.out.println("안전공간 : " + (N*M - cnt - 3 - wall));
//			System.out.println("--------------------");
//		}
		return N*M - cnt - 3 - wall; // 전체 - 감염공간 - 새로 세운 벽 - 처음에 주어진 벽 = 안전 공간
	}
}
