import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Union-Find로 풀기
public class BOJ7465_2 {

	static int N, M, ret;
	static int[] p; // 부모 노드를 저장
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			ret = 0;
			p = new int[N+1];
			
			make();

			int x, y;
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				union(x,y);
			}
			for(int i=1; i<=N; i++) { // 서로소 집합의 수를 센다.
				if(find(i)==i) ret++;
			}
			
			sb.append("#").append(tc).append(" ").append(ret).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	private static void make() {
		for(int i=1; i<=N; i++) {
			p[i] = i;
		}
	}
	
	private static int find(int x) {
		return (x == p[x]) ? x : (p[x] = find(p[x]));
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return;
		
		p[y] = x;
	}

}
