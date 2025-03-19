import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 키순서
public class SWEA5643 {

	static final int INF = 999;
	static int N, M, ret;
	static int[][] small, tall;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();		

		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++){
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
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		ret = 0;

		small = new int[N+1][N+1];
		tall = new int[N+1][N+1];
		for(int i=1; i<=N; i++){
			Arrays.fill(small[i], INF);
			Arrays.fill(tall[i], INF);
			small[i][i] = 0;
			tall[i][i] = 0;
		}

		int from, to;
		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());		
			to = Integer.parseInt(st.nextToken());		
			small[from][to] = 1;
			tall[to][from] = 1;
		}
		//debug
		// System.out.println("----- small");
		// for(int[] arr : small) System.out.println(Arrays.toString(arr));
		// System.out.println("----- tall");
		// for(int[] arr : tall) System.out.println(Arrays.toString(arr));
	}
	private static void solve() {
		floydWarshall(small);
		floydWarshall(tall);
		count();
	}
	private static void floydWarshall(int[][] arr) {
		for(int k=1; k<=N; k++){
			for(int i=1; i<=N; i++){
				for(int j=1; j<=N; j++){
					if(arr[i][k]+arr[k][j] < arr[i][j])
						arr[i][j] = arr[i][k] + arr[k][j];
				}
			}
		}
	}
	private static void count() {
		int cnt;
		for(int i=1; i<=N; i++){
			cnt = 0;
			for(int j=1; j<=N; j++){
				if(small[i][j] != INF || tall[i][j] != INF) cnt++;
			}
			if(cnt == N) ret++;
		}
	}
}
