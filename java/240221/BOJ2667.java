import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ2667 {

	static int N;
	static int[][] map;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static boolean[][] vis;
	static List<Integer> list; // 단지별로 속하는 집의 수를 저장
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		vis = new boolean[N][N];
		list = new ArrayList<Integer>();
		
		char[] input;
		for(int y=0; y<N; y++) {
			input = br.readLine().trim().toCharArray();
			for(int x=0; x<N; x++) {
				map[y][x] = input[x] - '0';
			}
		}

		// 단지로 나누고 각 단지멸 집의 수를 저장
		for(int y=0; y<N; y++) {
			for(int x=0; x<N; x++) {
				if(map[y][x]==0) continue;
				if(vis[y][x]) continue;
				list.add(solve(y, x));
			}
		}
		Collections.sort(list); // 정렬
		
		StringBuffer sb = new StringBuffer();
		sb.append(list.size()).append("\n");
		for(Integer cnt : list) {
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	// dfs 탐색 후 같은 단지에 속한 집의 수 반환
	private static int solve(int y, int x) {
		vis[y][x] = true;
		int cnt = 1;

		int ny, nx;
		for(int d=0; d<4; d++) {
			ny = y + dy[d];
			nx = x + dx[d];
			
			boolean under = ny<0||nx<0;
			boolean over = ny>=N||nx>=N;
			if(under||over) continue;
			
			if(map[ny][nx]==0) continue;
			if(vis[ny][nx]) continue;
			cnt += solve(ny, nx);
		}
		
		return cnt;
	}
}
