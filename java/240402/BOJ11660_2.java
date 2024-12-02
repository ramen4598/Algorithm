import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 구간 합 구하기 5
public class BOJ11660_2 { // 1108ms

	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		init(br);
		solve(br, sb);
		System.out.println(sb.toString());
		br.close();
	}

	static void init(BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		for (int x = 1, end = N + 1; x < end; x++) {
			st = new StringTokenizer(br.readLine());
			for (int y = 1; y < end; y++) { // 누적합
				map[x][y] = map[x][y - 1] + Integer.parseInt(st.nextToken());
			}
		}
		// debug
		//for(int[] arr : map)System.out.println(Arrays.toString(arr));
	}

	static void solve(BufferedReader br, StringBuffer sb) throws Exception {
		int x1, x2, y1, y2, sum;
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// x행 y열
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			sum = 0;
			for(int x=x1; x<=x2; x++) {
				sum += map[x][y2] - map[x][y1-1];
			}
			sb.append(sum).append("\n");
		}
	}

}
