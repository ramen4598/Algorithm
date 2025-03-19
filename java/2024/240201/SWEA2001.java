import java.io.*;
import java.util.StringTokenizer;

public class SWEA2001 {

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
			map = new int[n][n];
			for(int i=0; i<n; i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++){
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			solve();

			System.out.printf("#%d %d%n", tc, ret);
		}
		br.close();
	}

	public static void solve(){
		int sum=0;
		int limit = n-m;
		for(int y=0; y<=limit; y++){
			for(int x=0; x<=limit; x++){
				sum =0;
				for(int i=0; i<m; i++){
					for(int j=0; j<m; j++){
						//System.out.println(y+i + " : " + (x+j));
						sum += map[y+i][x+j];
					}
				}
				ret = Math.max(ret, sum);
			}
		}
	}

}

