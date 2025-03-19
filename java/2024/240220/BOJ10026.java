import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ10026 {

	static int N, ret1, ret2;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static char[][] map;
	static boolean[][] vis1, vis2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine().trim());
		map = new char[N][N];
		vis1 = new boolean[N][N];
		vis2 = new boolean[N][N];

		for(int y=0; y<N; y++) {
			map[y] = br.readLine().trim().toCharArray();
		}
		
		for(int y=0; y<N; y++) {
			for(int x=0; x<N; x++) {
				if(!vis1[y][x]) {
					dfs1(y, x); // 일반인
					ret1++;
				}
				if(!vis2[y][x]) {
					dfs2(y, x); // 적녹색약
					ret2++;
				}
			}
		}
		
		System.out.println(ret1+" "+ret2);
		br.close();
	}
	
	static void dfs1(int y, int x) {
		vis1[y][x] = true;
		
		for(int d=0; d<4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			boolean under = ny<0||nx<0;
			boolean over = ny>=N||nx>=N;
			if(over||under) continue;
			
			if(vis1[ny][nx]) continue;
			if(map[y][x] == map[ny][nx]) {
				dfs1(ny, nx);
			}
		}
	}

	static void dfs2(int y, int x) {
		vis2[y][x] = true;
		
		for(int d=0; d<4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			boolean under = ny<0||nx<0;
			boolean over = ny>=N||nx>=N;
			if(over||under) continue;
			
			if(vis2[ny][nx]) continue;
			
			boolean blue = (map[y][x] == 'B') && (map[ny][nx] == 'B'); 
			boolean redGreen = ((map[y][x] == 'R') || (map[y][x]=='G')) && ((map[ny][nx] == 'R') || (map[ny][nx]=='G'));
			if(blue || redGreen) { //적녹으로 한 구역이면
				dfs2(ny, nx);
			}
		}
	}

}
