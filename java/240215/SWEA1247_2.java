import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// DP로 풀어보기
public class SWEA1247_2 {

	static int n, ret;
	static Point work, home;
	static Point[] points;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb= new StringBuffer();

		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++) {
			//초기화
			ret = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			points = new Point[n+1]; // 직장 + 고객
			n++;

			//dp 초기화
			dp = new int[n][(1<<n)-1]; // y : 가장 최근에 방문한 고객, x : 방문한 모든 고객
			for(int i=0; i<n; i++) Arrays.fill(dp[i], -1); // 가본적 없음을 표시

			// 좌표 저장
			st = new StringTokenizer(br.readLine());
			work = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for(int i=1; i<n; i++) {
				points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}			
			points[0]=work;
			
			// 직장 -> 고객 -> 집 최소 비용
			ret = solve(0, 1);

			sb.append("#").append(tc).append(" ").append(ret).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	// now -> vis 하지 않은 도시들 -> 집 최소 거리 반환.
	private static int solve(int now, int vis){
		if(vis == (1<<n)-1) { // 모든 고객 방문 후 집까지 가는 비용
			return getDistance(points[now], home);
		}
		// 이미 계산했으면 값을 재사용.
		if(dp[now][vis] != -1) return dp[now][vis];

		// 처음이자 마지막으로 계산
		dp[now][vis] = Integer.MAX_VALUE; // 초기화
		for(int next=0; next<n; next++){
			if((vis & (1<<next)) != 0) continue; // 가본적 있으면 패스
			int newDistance = solve(next, vis | (1<<next)) + getDistance(points[now], points[next]);
			dp[now][vis] = Math.min(dp[now][vis], newDistance);
		}

		// 새로 계산한 값 반환
		return dp[now][vis];
	}

	private static int getDistance(Point from, Point to){
		return Math.abs(from.y - to.y)+Math.abs(from.x - to.x);
	}
	
	private static class Point {
		int y;
		int x;
		Point(int y, int x){
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Home [y=" + y + ", x=" + x + "]";
		}
		
	}	

}
