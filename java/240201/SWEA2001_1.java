import java.io.*;
import java.util.StringTokenizer;

public class SWEA2001_1 {

	static int n, m, ret;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++){
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			ret = 0;

			// 입력
			// 누적합
			map = new int[n+1][n+1];
			for(int i=1; i<=n; i++){
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=n; j++){
					map[i][j] = map[i][j-1] + Integer.parseInt(st.nextToken());
				}
			}
			
			solve();

			System.out.printf("#%d %d%n", tc, ret);
		}
		br.close();
	}

	public static void solve(){
		int sum;
		int limit = n-m+2;
		for(int y=1; y<limit; y++){
			for(int x=1; x<limit; x++){
				sum = 0;
				for(int i=0; i<m; i++){
					sum += map[y+i][x+m-1] - map[y+i][x-1];
				}
				ret = Math.max(ret, sum);
			}
		}
	}

}

