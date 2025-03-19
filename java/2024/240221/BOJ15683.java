import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15683 {

	static int N, M, blank, ret; // 가로, 세로, 빈 공간의 수, 사각 지대의 최소
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1}; 
	static int[][] map;
	static List<Cctv> cctvs;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		blank = 0;
		ret = Integer.MAX_VALUE;
		map = new int[N][M];
		cctvs = new ArrayList<Cctv>();

		// 사무실 초기화
		for(int y=0; y<N; y++){
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<M; x++){
				map[y][x] = Integer.parseInt(st.nextToken());
				if(map[y][x] > 0){
					if(map[y][x] == 6){ // 벽일 때
 						map[y][x] = -2;
					}else{ // cctv일 때
						cctvs.add(new Cctv(y, x, map[y][x]));
						map[y][x] = -1;
					}
				}else{ // 빈 공간
					blank++;
				}
			}
		}
		solve(0, 0);

		System.out.println(ret);
		br.close();
	}

	static void solve(int depth, int cnt){ // sum = 감시 중인 공간의 수
		if(depth == cctvs.size()){
			ret = Math.min(ret, blank - cnt);
			return;
		}

		Cctv cctv = cctvs.get(depth);
		for(int i=0; i<cctv.option; i++){ // 회전 가능한 수
			cnt += cctv.count(1); // 감시하는 공간의 수
			solve(depth+1, cnt);
			cnt -= cctv.count(-1); // 원복
			cctv.turn(); // 회전
		}
	}

	static class Cctv{
		int y, x, option; // 좌표, 회전을 통해서 만들 수 있는 경우의 수
		int[] dir; // 감시 방향. 시계방향. 상-우-하-좌

		Cctv(int y, int x, int type){
			this.y=y;
			this.x=x;
			switch(type){
				case 1:
					dir = new int[]{0,1,0,0};
					option = 4;
					break;
				case 2:
					dir = new int[]{0,1,0,1};
					option = 2;
					break;
				case 3:
					dir = new int[]{1,1,0,0};
					option = 4;
					break;
				case 4:
					dir = new int[]{1,1,0,1};
					option = 4;
					break;
				case 5:
					dir = new int[]{1,1,1,1};
					option = 1;
					break;
			}	
		}

		public int count(int num) {
			int cnt = 0;
			for(int i=0; i<4; i++){ // 상우하우
				if(dir[i] == 0) continue;

				int ny = this.y;
				int nx = this.x;
				boolean under, over;
				while(true){ // 해당 방향으로 감시할 수 있는 공간의 수를 센다.
					ny += dy[i];
					nx += dx[i];
					under = ny<0 || nx<0;
					over = ny>=N||nx>=M;
					if(under || over) break;
					if(map[ny][nx] == -2) break; // 벽
					if(map[ny][nx] == -1) continue; // cctv

					if(num==1 && map[ny][nx] == 0) cnt++; // 해당 공간을 처음으로 감시한다면
					map[ny][nx] += num; // 처음에는 +1 원복은 -1
					if(num==-1 && map[ny][nx] == 0) cnt++; // 원복
				}
			}
			return cnt;
		}

		public void turn() { // 감시 방향을 시계방향으로 회전
			int tmp = dir[3];
			dir[3] = dir[2];
			dir[2] = dir[1];
			dir[1] = dir[0];
			dir[0] = tmp;
		}

	}

}
