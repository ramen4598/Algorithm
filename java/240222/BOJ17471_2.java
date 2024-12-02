import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 불필요한 dfs 탐색을 줄이고 
// 바이너리 카운팅이 아닌 재귀 함수로 부분집합 생성
public class BOJ17471_2 {

	static int N, ret;
	static int[] people; // 인구수 저장
	static List<Integer>[] g; // 인접 리스트
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		ret = Integer.MAX_VALUE;
		people = new int[N+1]; // 1 ~ N
		g = new List[N+1];

		// 인구수 저장
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		// 인접 리스트 초기화
		int num;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			g[i] = new ArrayList<>();
			num = Integer.parseInt(st.nextToken());
			for(int j=0; j<num; j++) {
				g[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		// 부분집합을 생성하고 최소 인구차를 찾는다.
		solve(1, new int[N+1]);
		
		if(ret == Integer.MAX_VALUE) ret = -1;
		System.out.println(ret);
		br.close();
	}
	
	// 재귀함수로 부분집합을 생성한다.
	static void solve(int depth, int[] comb) {
		if(depth == N+1) {
			if(!check(comb, 0) || !check(comb, 1)) return; // 한 선거구의 구역은 모두 연결되었는가?
			ret = Math.min(ret,  count(comb));
			// if(ret > count(comb)){
			// 	ret = count(comb);
			// 	System.out.println(Arrays.toString(comb) + " : " + ret);
			// }
			return;
		}
		
		// 부분집합을 생성한다.
		comb[depth] = 1;
		solve(depth+1, comb);
		// 원복
		comb[depth] = 0;
		solve(depth+1, comb);
	}

	static boolean check(int[] comb, int group) {

		int same = 0;
		for(int i=1; i<=N; i++){
			if(comb[i] == group) same++;
		}
		if(same == N) return false; // 몰빵 금지

		int cnt = 0;
		boolean[] vis = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			if(comb[i] != group) continue; // 같은 선거구
			if(vis[i]) continue;
			if(cnt>0) return false; // 같은 선거구에서 연결될 수 없는 구역 존재
			dfs(i, vis, comb, group);
			cnt++;
		}
		return true;
	}
	
	static void dfs(int cur, boolean[] vis, int[] comb, int group) {
		vis[cur] = true;
		
		for(Integer next : g[cur]) {
			if(comb[next] != group) continue;
			if(vis[next]) continue;
			dfs(next, vis, comb, group);
		}
	}
	
	static int count(int[] comb) {
		int sum0 = 0;
		int sum1 = 0;
		
		for(int i=1; i<=N; i++) { // 1 ~ N
			if(comb[i] == 0) sum0 += people[i];
			if(comb[i] == 1) sum1 += people[i];
		}
		
		return Math.abs(sum0 - sum1);
	}
}
