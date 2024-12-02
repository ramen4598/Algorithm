import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1247 {

	static int n, ret;
	static boolean[] vis;
	static Point work, home;
	static Point[] custs;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();

		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=T; tc++) {
			//초기화
			ret = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			custs = new Point[n];
			vis= new boolean[n];
			
			// 좌표 저장
			st = new StringTokenizer(br.readLine());
			work = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for(int i=0; i<n; i++) {
				custs[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			// 정렬 - 최대한 빠른 횟수 안에 최소값을 찾기 위해서
			Arrays.sort(custs);
			
			solve(0, 0, work);
			
			sb.append("#").append(tc).append(" ").append(ret).append("\n");
		}

		System.out.println(sb);
		br.close();
	}
	
	// 순열
	private static void solve(int depth, int sum, Point cur) {
		// 가지치기
		if(sum > ret) return;

		// 기저조건
		if(depth==n) {
			// sum에 집까지 거리 더하기
			sum += Math.abs(cur.y - home.y) + Math.abs(cur.x - home.x);
			ret = Math.min(ret, sum);
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(cur == custs[i]) continue;
			if(vis[i]) continue;

			vis[i]=true;
			int dis = Math.abs(cur.y - custs[i].y) + Math.abs(cur.x - custs[i].x);
			solve(depth+1, sum+dis, custs[i]);
			vis[i]=false;
		}
	}
	
	private static class Point implements Comparable<Point> {
		int y;
		int x;
		Point(int y, int x){
			this.y = y;
			this.x = x;
		}

		@Override
		public int compareTo(Point o) {
			return (this.y==o.y) ? this.x - o.x : this.y - o.x;
		}

		@Override
		public String toString() {
			return "Home [y=" + y + ", x=" + x + "]";
		}
		
	}

}
