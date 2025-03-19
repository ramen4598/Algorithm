import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// ArrayList 사용
public class BOJ15686_2 {

	static int N, M, ret;
	static List<Point> homes, chickens, comb; // 가정집, 치킨집, 치킨집 조합
	static final int HOME = 1, CHICKEN = 2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ret = Integer.MAX_VALUE;
		homes = new ArrayList<Point>();
		chickens = new ArrayList<Point>();
		comb = new ArrayList<Point>();
		
		for(int y=0; y<N;  y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<N; x++) {
				int type = Integer.parseInt(st.nextToken());
				if(type == HOME) homes.add(new Point(y, x));
				if(type == CHICKEN) chickens.add(new Point(y, x));
			}
		}
		
		// 가능한 치킨집 조합을 모두 구하고 각각의 치킨 거리를 비교하여 최소 거리 ret를 구한다.
		solve(0, 0);
		
		System.out.println(ret);
		br.close();
	}
	
	// 선택한 치킨집 조합을 List로 저장
	static void solve(int depth, int start) {
		if(depth == M) {
			getDistance();
			return;
		}
		
		int end = chickens.size();
		for(int i=start; i<end; i++) {
			comb.add(chickens.get(i));
			solve(depth+1, i+1);
			comb.remove(chickens.get(i));
			solve(depth, i+1);
		}
	}
	
	static void getDistance() {
		int sum = 0;
		
		int tmp, dis;
		for(Point h : homes) {
			dis = Integer.MAX_VALUE;
			for(Point p : comb) {
				tmp = Math.abs(p.y - h.y) + Math.abs(p.x - h.x);
				dis = Math.min(dis, tmp);
			}
			sum += dis;
		}
		
		ret = Math.min(ret,  sum);
	}
	
	static class Point {
		int y, x;
		
		Point(int y, int x){
			this.y = y;
			this.x = x;
		}
	}

}
