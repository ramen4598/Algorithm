import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ17471 {

	static int N, ret;
	static int[] person, parent;
	static List<Integer>[]  g; // 인접 리스트
	static List<List<Integer>> groups;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		ret = Integer.MAX_VALUE;
		int end = N+1;

		// 인구 수 저장
		st = new StringTokenizer(br.readLine());
		person = new int[end];
		for(int i=1; i<end; i++) {
			person[i] = Integer.parseInt(st.nextToken());
		}
		
		// 인접 리스트
		int num; // 연결된 구역의 수
		g = new ArrayList[end];
		for(int i=1; i<end; i++) {
			g[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			for(int j=0; j<num; j++) {
				g[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		solve();
		
		System.out.println(ret);
		br.close();
	}
	
	static void solve() {
		groups = new ArrayList<>();
		// 전체에 대하여 연결된 구역의 수를 구한다.
		List<Integer> group;
		boolean[] vis = new boolean[N+1];
		for(int i=1; i<N+1; i++) {
			if(vis[i]) continue;
			group = new ArrayList<Integer>();
			dfs(i, vis, group);
			groups.add(group);
		}
		
		// 두 선거구로 나눌 수 없는 경우
		if(groups.size() > 2) {
			ret = -1;
			return;
		}else if(groups.size() == 2){ // 이미 두 선거구인 경우
			ret = Math.abs(count(groups.get(0)) - count(groups.get(1)));
			return;
		}else { // 모든 선거구가 연결되어있을 때
			divide();
		}
	}
	
	private static void divide() { // 2개의 선거구로 나누고 인구 차이의 최소값 찾기
		List<Integer> g1 = new ArrayList<Integer>();
		List<Integer> g2 = new ArrayList<Integer>();
		int tmp;
		int end = 1<<N;
		next : for(int comb=0; comb<end; comb++) { // 부분집합 : 바이너리카운팅
			if(comb == 0 || comb == end-1) continue; // 몰빵 방지
			g1 = new ArrayList<Integer>(); // 1번 선거구
			g2 = new ArrayList<Integer>(); // 2번 선거구
			for(int j=0; j<N; j++) {
				if((comb & (1 << j)) != 0) { // 1번 선거구 
					g1.add(j+1); // 1 ~ N
				}else { // 2번 선거구
					g2.add(j+1); // 1 ~ N
				}
			}
			// 같은 선거구에 속한 구역은 서로 연결되어야 한다.
			groups.clear(); groups.add(g1); groups.add(g2);
			for(List<Integer> group : groups) {
				int cnt = 0;
				boolean[] vis = new boolean[N+1]; // 1 ~ N
				for(int i=0; i<group.size(); i++) {
					int cur = group.get(i);
					if(vis[cur]) continue;
					if(cnt > 0) continue next; // 불가능한 선거구 조합
					dfs2(cur, vis, group);
					cnt++;
				}
			}

			// 모든 조건 통과 : 2개의 선거구로 나누고 각 선거구의 구역은 연결되어있다.
			//System.out.println(g1 + ", " + g2);
			tmp = Math.abs(count(g1) - count(g2)); // 양 선거구의 인구 차이 계산
			ret = Math.min(ret, tmp); // 최소 인구 차이 찾기
		}
	}

	static void dfs(int cur, boolean[] vis, List<Integer> res) {
		vis[cur] = true;
		res.add(cur);
		
		for(Integer next : g[cur]) {
			if(vis[next]) continue;
			dfs(next, vis, res);
		}
	}

	static void dfs2(int cur, boolean[] vis, List<Integer> group) {
		vis[cur] = true;
		
		for(Integer next : g[cur]) {
			if(vis[next]) continue;
			if(!group.contains(next))continue; // 같은 선거구가 아니면 못지나간다. 
			dfs2(next, vis, group);
		}
	}
	
	static int count(List<Integer> list) {
		int cnt = 0;
		
		for(Integer i : list) {
			cnt += person[i];
		}
		
		return cnt;
	}

}
