import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3289 {

	static int N, M; // 노드 수, 연산 수
	static int[] p; // 부모 노드 저장
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");

			// 초기화
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			p = new int[N+1];
			
			// 1. p 배열 초기화 
			make();
			
			int oper, x, y;
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				oper = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				if(oper == 0) { // 2. union
					union(x, y);
				}else{ // 3. find
					sb.append(check(x,y));
				}
			}
			sb.append("\n");
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

	private static int check(int x, int y) {
		if(x == y) return 1;
		int xRoot = find(x);
		int yRoot = find(y);
		if(xRoot == yRoot) return 1; // 같은 집합
		return 0; // 다른 집합
	}

	private static void union(int x, int y) {
		if(check(x, y)==1) return;
		int xRoot = find(x);
		int yRoot = find(y);
		
		p[yRoot] = xRoot;
		return;
	}

}
