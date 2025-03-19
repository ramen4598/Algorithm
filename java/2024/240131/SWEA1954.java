import java.util.Scanner;

public class SWEA1954 {
	static int n;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			n = sc.nextInt();
			map = new int[n][n];

			solve(n, 1, 0, 0);
			System.out.println("#"+tc);
			myPrint();
		}
		sc.close();
	}
	
	public static void solve(int num, int cnt, int y, int x) {
		if(num==1) {
			map[y][x]=cnt;
			return;
		}
		if(num==0) {
			return;
		}
		//가로로 num만큼 이동
		for(int nx=x; nx<x+num; nx++) {
			map[y][nx] = cnt;
			cnt++;
		}
		//세로로 num-1 만큼 이동
		for(int ny=y+1; ny<y+num; ny++) {
			map[ny][x+num-1] = cnt;
			cnt++;
		}
		//가로로 num-1만큼 이동. 역방향
		for(int nx=x+num-2; nx>=x; nx--) {
			map[y+num-1][nx] = cnt;
			cnt++;
		}
		//세로로 num-2 만큼 이동. 역방향
		for(int ny=y+num-2; ny>=y+1; ny--) {
			map[ny][x] = cnt;
			cnt++;
		}
		//재귀호출
		//myPrint();
		solve(num-2, cnt, y+1, x+1);
	}
	public static void myPrint() {
		for(int i=0; i<n; i++) {
			StringBuffer sb = new StringBuffer();
			for(int j=0; j<n;j++) {
				sb.append(map[i][j]).append(" ");
			}
			System.out.println(sb);
		}
	}

}
