import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ13023 {

	static int N, M, flag;
	static List<Integer>[] list;
	static boolean[] vis;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		vis = new boolean[N];

		// 인접 리스트 초기화
		list = new List[N];
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		int x, y;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			list[x].add(y);
			list[y].add(x);
		}
		
		flag = 0;
		for(int i=0; i<N; i++) {
			vis[i] =true;
			solve(0, i);
			vis[i] = false;
			if(flag == 1) break;
		}
		
		System.out.println(flag);
		br.close();
	}
	
	private static void solve(int depth, int cur) {
		if(flag == 1) return;
		if(depth == 4) {
			flag = 1;
			return;
		}

		for(Integer next : list[cur]) {
			if(vis[next]) continue;
			vis[next] = true;
			solve(depth+1, next);
			vis[next] = false;
		}
	}

}
