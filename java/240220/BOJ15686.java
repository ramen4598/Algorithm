import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 비트마스킹 사용
public class BOJ15686 {

	static int N, M, ret;
	static List<Point> homes, chickens;
	static final int HOME = 1, CHICKEN = 2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ret = Integer.MAX_VALUE;
		homes = new ArrayList<Point>();
		chickens = new ArrayList<Point>();
		
		for(int y=0; y<N;  y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<N; x++) {
				int type = Integer.parseInt(st.nextToken());
				if(type == HOME) homes.add(new Point(y, x));
				if(type == CHICKEN) chickens.add(new Point(y, x));
			}
		}
		
		// 가능한 치킨집 조합을 모두 구하고 각각의 치킨 거리를 비교하여 최소 거리 ret를 구한다.
		solve(0, 0, 0);
		
		System.out.println(ret);
		br.close();
	}
	
	// 선택한 치킨집 조합을 비트마스킹으로 저장
	static void solve(int depth, int start, int vis) {
		if(depth == M) {
			ret = Math.min(ret, getDistance(vis));
			return;
		}
		
		int end = chickens.size();
		for(int i=start; i<end; i++) {
			solve(depth+1, i+1, vis | 1<<i);
			solve(depth, i+1, vis);
		}
	}
	
	static int getDistance(int vis) {
		int min = 0;
		int h_end = homes.size();
		int c_end = chickens.size();
		int dis; 
		for(int i=0; i<h_end; i++) { // 모든 집에 대하여
			dis = Integer.MAX_VALUE; 
			for(int j=0; j<c_end; j++) { // 모든 치킨집에 대하여
				if((vis & 1<<j) == 0) continue; // 선택하지 않은 치킨집 통과 
				int tmp = Math.abs(homes.get(i).y - chickens.get(j).y) + Math.abs(homes.get(i).x - chickens.get(j).x);
				dis = Math.min(dis, tmp); //각 집의 치킨 거리 구하기
			}
			min += dis; // 각 집의 치킨거리를 전체 치킨 거리에 더한다.
		}
		return min;
	}
	
	static class Point {
		int y, x;
		
		Point(int y, int x){
			this.y = y;
			this.x = x;
		}
	}

}
