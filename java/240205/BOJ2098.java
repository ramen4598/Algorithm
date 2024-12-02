import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2098 {

	static int N, min;
	static boolean[] vis;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		N = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		vis = new boolean[N];
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(1, 0, 0);// 0번 도시에서 시작
		
		System.out.println(min);
	}
	
	public static void solve(int depth, int cur, int sum) {
		// 가지치기
		if(sum > min){
			return;
		}

		if(depth==N) {
			sum += map[cur][0]; // 마지막은 0번 도시로
			min = Math.min(min, sum);
			return;
		}

		for(int i=1; i<N; i++) { // 0번 도시는 도중에 가면 안된다.
			if(vis[i])continue; // 이미 갔으면 안됨.
			if(map[cur][i]>0) { // 갈 수 없거나 자기 자신이면 안됨.
				vis[i]=true;
				solve(depth+1, i, sum+map[cur][i]);
				vis[i]=false;
			}
		}

	}

}
