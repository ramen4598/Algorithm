import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA1767_2 {
	// 멕시노스 크기, 최대코어수, 비가장자리코어수, 최소 전선 길이합
	static int N, max, totalCnt, min;
	static int[][] map;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	static ArrayList<int[]> list; // 비가장자리 코어 리스트
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			list = new ArrayList<int[]>();
			max = 0;
			totalCnt = 0;
			min = Integer.MAX_VALUE;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i>0 && i<N-1 && j>0 && j<N-1 && map[i][j]==1) {
						list.add(new int[] {i,j});
						totalCnt++;
					}
				}
			} // 멕시노스 셀 정보 입력 및 비가장자리 코어리스트 생성
			
			solve(0, 0, 0);
			System.out.println("#"+tc+" "+min);
		}
		
	}
	
	static void solve(int idx, int cCnt, int lCnt) {// 현재 코더, 코어갯수, 전선길이 합
		if(cCnt+(totalCnt-idx)<max) return; // 남은 모든 코어를 더해도 최대 코어개수를 갱신할 수 없으면 가지치기
		
		if(idx==totalCnt) {
			if(max < cCnt) { // 코어의 수가 최대
				max = cCnt;
				min = lCnt;
			}else if(max == cCnt) {
				if(min > lCnt) {
					min = lCnt;
				}
			}
			return;
		}

		int[] cur = list.get(idx);
		int y = cur[0];
		int x = cur[1];
		// 4방 탐색
		for(int d=0; d<4; d++) {
			if(isAvailable(y, x, d)) {
				int len = setStatus(y, x, d, 2); // 전선 놓는 경우
				solve(idx+1, cCnt+1, lCnt+len);
				setStatus(y, x, d, 0); // 원복
			}
		}
		// 전선 안 놓는 경우
		solve(idx+1, cCnt, lCnt);
	}
	
	static boolean isAvailable(int y, int x, int d) {
		int ny = y;
		int nx = x;
		while(true) {
			ny += dy[d];
			nx += dx[d];
			boolean under = ny<0||nx<0;
			boolean over = ny>=N||nx>=N;
			if(under||over) return true;
			if(map[ny][nx] > 0) return false;
		}
	}
	
	static int setStatus(int y, int x, int d, int s) { // map[y][x]의 d 방향으로 이동하며 s로 상태 변경
		int ny = y;
		int nx = x;
		int cnt = 0;
		while(true) {
			ny += dy[d];
			nx += dx[d];
			boolean under = ny<0||nx<0;
			boolean over = ny>=N||nx>=N;
			if(under||over) break;
			map[ny][nx] = s;
			cnt++;
		}
		return cnt;
	}
}
