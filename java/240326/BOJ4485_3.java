import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 녹색 옷 입은 애가 젤다지?
public class BOJ4485_3 {

	static int tc, N;  // testcases, 동굴의 너비 
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int[][] map;
	static int[][] D; // 가중치 저장
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();

		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			init(br, st);
			solve(sb);
		}

		System.out.println(sb.toString());
		br.close();
	}
	
	static void init(BufferedReader br, StringTokenizer st) throws Exception {
		map = new int[N][N];
		D = new int[N][N];
		for(int y=0; y<N; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				//D[y][x] = Integer.MAX_VALUE;
				D[y][x] = 200000;
			}
		}
		// debug
		//for(int[] arr : map) System.out.println(Arrays.toString(arr));
		for(int[] arr2 : D) System.out.println(Arrays.toString(arr2));
		
	}
	
	static void solve(StringBuffer sb) {
		//sb.append(N);
		boolean[][] vis = new boolean[N][N];
		PriorityQueue<Data> pq = new PriorityQueue<Data>();
		
		D[0][0] = map[0][0];
		pq.offer(new Data(0, 0, D[0][0]));
		
		Data cur;
		while(!pq.isEmpty()) {
			cur = pq.poll();

			if(cur.y == N-1 && cur.x == N-1) break; // 가지치기
			if(vis[cur.y][cur.x]) continue;
			vis[cur.y][cur.x] = true; 
			//System.out.println(cur);
			
			int ny, nx;
			for(int i=0; i<4; i++) {
				ny = cur.y + dy[i];
				nx = cur.x + dx[i];
				boolean under = ny<0 || nx<0;
				boolean over = ny >= N || nx >= N;
				if(under || over) continue;
				if(vis[ny][nx]) continue;
				int tmp = D[cur.y][cur.x] + map[ny][nx]; 
				if(tmp < D[ny][nx]) {
					pq.offer(new Data(ny, nx, tmp));
					D[ny][nx] = tmp;
				}
			}
		}
		// 출력
		sb.append("Problem ").append(++tc).append(": ").append(D[N-1][N-1]).append("\n");
	}
	
	static class Data implements Comparable<Data>{
		int y, x, w; // 좌표 y, x, 가중치
		
		Data(int y, int x, int w){
			this.y = y;
			this.x = x;
			this.w = w;
		}

		@Override
		public int compareTo(Data o) {
			return Integer.compare(this.w, o.w);
		}

		@Override
		public String toString() {
			return y + " : " + x + " : " + w;
		}
	}

}
