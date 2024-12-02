
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 활주로 건설
public class SWEA4014 {

	static int N, X, ret;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			init(br, st);
			solve();
			sb.append("#").append(tc).append(" ").append(ret).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static void init(BufferedReader br, StringTokenizer st) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		ret = 0;
		map = new int[N][N];
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		//debug
		// for(int[] arr : map) System.out.println(Arrays.toString(arr));
	}

	private static void solve() {
		for(int i=0; i<N; i++) {
			if(row(i)) ret++;
			if(col(i)) ret++;
		}
	}

	// 조건 1. 인접한 지형의 높이차는 1보다 클 수 없다.
	// 조건 2. 경사로는 지형을 벗어날 수 없다.
	// 조건 3. 이미 경사로가 존재한다면 경사로를 둘 수 없다.
	private static boolean row(int y) { // 가로로 조건을 만족하는가?
		boolean[] vis = new boolean[N];
		int diff; // 높이차
		for(int x=0; x<N-1; x++) {
			diff = map[y][x] - map[y][x+1];
			if(diff == 0) continue;
			if(Math.abs(diff)>=2) return false; // 조건 1
			if(diff > 0) { // 높 -> 낮
				if(x>=N-X)return false; // 조건 2
				for(int i=1; i<=X; i++) {
					if(vis[x+i]) return false; // 조건 3
					vis[x+i] = true;
				}
			}
			if(diff < 0) { // 낮 -> 높
				if(x<X-1)return false; // 조건 2
				for(int i=0; i<X; i++) {
					if(vis[x-i]) return false; // 조건 3
					vis[x-i] = true;
				}
			}
		}
		return true;
	}

	private static boolean col(int x) { // 세로로 조건을 만족하는가?
		boolean[] vis = new boolean[N];
		int diff; // 높이차
		for(int y=0; y<N-1; y++) {
			diff = map[y][x] - map[y+1][x];
			if(diff == 0) continue;
			if(Math.abs(diff)>=2) return false; // 조건 1
			if(diff > 0) { // 높 -> 낮
				if(y>=N-X)return false; // 조건 2
				for(int i=1; i<=X; i++) {
					if(vis[y+i]) return false; // 조건 3
					vis[y+i] = true;
				}
			}
			if(diff < 0) { // 낮 -> 높
				if(y<X-1)return false; // 조건 2
				for(int i=0; i<X; i++) {
					if(vis[y-i]) return false; // 조건 3
					vis[y-i] = true;
				}
			}
		}
		return true;
	}

}
