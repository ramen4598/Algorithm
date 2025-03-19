import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 사람 네트워크2
public class SWEA1263 { // 2740ms

	static final int INF = 1001;
	static int n, ret;
	static int[][] g;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++) {
			init(br, st);
			solve();
			sb.append("#").append(tc).append(" ").append(ret).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void init(BufferedReader br, StringTokenizer st) throws Exception {
		ret = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); 
		
		g = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				g[i][j] = Integer.parseInt(st.nextToken()); 
				if(g[i][j] == 0) g[i][j] = INF;
			}
			g[i][i] = 0;
		}
		
		// debug
		//for(int[] arr : g) System.out.println(Arrays.toString(arr));
	}
	
	static void solve() { // floyd-warshall algorithm으로 
		for(int k=0; k<n; k++) { // 경유지
			for(int i=0; i<n; i++) { // 시작지
				for(int j=0; j<n; j++) { // 도착지
					if(g[i][j] > g[i][k] + g[k][j]) { // 경유해서 가는 것이 더 비용이 적다면 갱신
						g[i][j] = g[i][k] + g[k][j];
					}
				}
			}
		}
		
		// 최소 CC 찾기
		int sum;
		for(int[] arr : g) {
			sum = 0;
			for(int i=0; i<n; i++) {
				sum += arr[i];
			}
			ret = Math.min(ret,  sum);
			//debug
			//System.out.println(sum);
			//System.out.println(Arrays.toString(arr));
		}
	}

}
