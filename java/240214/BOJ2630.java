import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630 {
	static int white, blue, n;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(n, 1, 1);
		
		System.out.println(white);
		System.out.println(blue);
		br.close();
	}
	
	private static void solve(int depth, int y, int x) {
		if(depth == 1) {
			if(map[y][x]==0) white++;
			else blue++;
			return;
		}

		if(check(depth, y, x)) { // 모두 파란색 혹은 하얀색
			if(map[y][x]==0) white++;
			else blue++;
			return;
		}
		
		solve(depth/2, y, x);
		solve(depth/2, y, x+depth/2);
		solve(depth/2, y+depth/2, x);
		solve(depth/2, y+depth/2, x+depth/2);
		
		return;
	}

	// 정사각형 모두 같은 색인지 확인
	private static boolean check(int depth, int y, int x) {
		int color = map[y][x];
		for(int ny=y; ny<y+depth; ny++) {
			for(int nx=x; nx<x+depth; nx++) {
				if(map[ny][nx]==color) continue;
				return false;
			}
		}
		return true;
	}
}
