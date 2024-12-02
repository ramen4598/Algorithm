import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 탈출
public class BOJ3055 { // 84ms

	static int R, C, ret;
	static char[][] map;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx =  {0, 1, 0, -1};
	static Queue<int[]> s, water; // 고슴도치, 물
	
	public static void main(String[] args) throws Exception {
		init();
		solve();
		System.out.println((ret != -1) ? ret : "KAKTUS");
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ret = -1;
	
		s = new ArrayDeque<>();
		water = new ArrayDeque<>();
		
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0; j<C; j++) { // 고슴도치와 물 위치 저장
				if(map[i][j] == 'S') s.offer(new int[]{i, j});
				if(map[i][j] == '*') water.offer(new int[]{i, j});
			}
		}
		// debug
//		for(char[] arr : map) {
//			System.out.println(Arrays.toString(arr));
//		}
//		while(!s.isEmpty()) {
//			System.out.println("s : " + Arrays.toString(s.poll()));
//		}
//		while(!water.isEmpty()) {
//			System.out.println("water : " + Arrays.toString(water.poll()));
//		}
		br.close();
	}
	
	static void solve() {
		int wCnt, sCnt, cnt = 0;
		while(!s.isEmpty()) { // 너비단위 BFS
			cnt++;
			wCnt = water.size();
			sCnt = s.size();
			int[] cur;
			int ny, nx;
			// 물
			for(int i=0; i<wCnt; i++) {
				cur = water.poll();
				for(int d=0; d<4; d++) {
					ny = cur[0] + dy[d];
					nx = cur[1] + dx[d];
					boolean under = ny<0||nx<0;
					boolean over = ny>=R||nx>=C;
					if(under||over) continue;
					if(map[ny][nx]=='D' || map[ny][nx]=='*' || map[ny][nx]=='X') continue;
					map[ny][nx] = '*'; // 물 참.
					water.offer(new int[] {ny,nx});
				}
			}
			// 고슴도치
			for(int i=0; i<sCnt; i++) {
				cur = s.poll();
				for(int d=0; d<4; d++) {
					ny = cur[0] + dy[d];
					nx = cur[1] + dx[d];
					boolean under = ny<0||nx<0;
					boolean over = ny>=R||nx>=C;
					if(under||over) continue;
					if(map[ny][nx]=='S' || map[ny][nx]=='*' || map[ny][nx]=='X') continue;
					if(map[ny][nx]=='D') { // 비버 집에 도착함.
						ret = cnt;
						return;
					}
					map[ny][nx] = 'S'; // 물 참.
					s.offer(new int[] {ny,nx});
				}
			}
			// debug
			//System.out.println("--------------------" + cnt);
			//for(char[] arr : map) System.out.println(Arrays.toString(arr));
		}
	}

}
