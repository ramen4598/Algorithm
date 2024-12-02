import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 미세먼지 안녕!
public class BOJ17144 { // 276ms
	static int R, C, T, c1, c2, ret; // 세로, 가로, 시간, 청정기 상부, 하부
	static int[][] map, cur; // 현재, 최근
	static int[] dy = {-1, 0, 1, 0}, dx= {0, 1, 0, -1};
	public static void main(String[] args) throws Exception {
		init();
		solve();
		ret = count();
		System.out.println(ret);
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		for(int y=0; y<R; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<C; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if(map[y][x] == -1) {
					if(c1 == 0) c1 = y;
					else c2 = y;
				}
			}
		}
		//debug
		//for(int[] arr : map) System.out.println(Arrays.toString(arr));
		br.close();
	}
	static void solve() {
		for(int i=0; i<T; i++) {
			cur = map;
			map = new int[R][C];
			spread();
			clean();
		}
	}

	private static void spread() {
		int ny, nx, cnt, mod5;
		for(int y=0; y<R; y++) {
			for(int x=0; x<C; x++) {
				if(cur[y][x]==0) continue; // 이어있으면 통과
				if(cur[y][x]==-1) {
					map[y][x] = -1; // 공기청정기
					continue;
				}
				cnt = 0; mod5 = cur[y][x]/5;
				for(int d=0; d<4; d++) {
					ny = y + dy[d];
					nx = x + dx[d];
					if(ny<0||nx<0||ny>=R||nx>=C)continue;
					if(cur[ny][nx]==-1)continue;
					map[ny][nx] += mod5;
					cnt++;
				}
				map[y][x] += cur[y][x] - cnt*mod5;
			}
		}
		//debug
		//System.out.println("-------------------------------------");
		//System.out.println("before");
		//for(int[] arr : cur) System.out.println(Arrays.toString(arr));
		//System.out.println("after");
		//for(int[] arr : map) System.out.println(Arrays.toString(arr));
	}

	private static void clean() {
		// 회전의 꼭짓점에 위치한 값 일시 저장
		int lt, lb, rt, rb; // left top, left Bottom, right top, right bottom
		// 상
		lt = map[0][0];
		lb = 0;
		rt = map[0][C-1];
		rb = map[c1][C-1];
		// >
		for(int x=C-1; x>1; x--) {
			map[c1][x] = map[c1][x-1];
		}
		map[c1][1] = lb;
		// ^
		for(int y=0; y<c1-1; y++) {
			map[y][C-1] = map[y+1][C-1];
		}
		map[c1-1][C-1] = rb;
		// <
		for(int x=0; x<C-2; x++) {
			map[0][x] = map[0][x+1];
		}
		map[0][C-2] = rt;
		// v
		for(int y=c1; y>1; y--) {
			map[y][0] = map[y-1][0];
		}
		map[1][0] = lt;

		// 하
		lt = 0;
		lb = map[R-1][0];
		rt = map[c2][C-1];
		rb = map[R-1][C-1];
		// >
		for(int x=C-1; x>1; x--) {
			map[c2][x] = map[c2][x-1];
		}
		map[c2][1] = lt;
		// v
		for(int y=R-1; y>c2+1; y--) {
			map[y][C-1] = map[y-1][C-1];
		}
		map[c2+1][C-1] = rt;
		// <
		for(int x=0; x<C-2; x++) {
			map[R-1][x] = map[R-1][x+1];
		}
		map[R-1][C-2] = rb;
		// ^
		for(int y=c2; y<R-2; y++) {
			map[y][0] = map[y+1][0];
		}
		map[R-2][0] = lb;

		map[c1][0] = -1;
		map[c2][0] = -1;
		//debug
		//for(int[] arr : map) System.out.println(Arrays.toString(arr));
	}

	private static int count() {
		int cnt = 0;
		for(int[] arr : map) {
			for(int i : arr) {
				cnt += i;
			}
		}
		return cnt + 2; // 공기청정기 제외
	}

}
