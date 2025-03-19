import java.util.Scanner;

// 시간 초과
public class BOJ9663 {

	static int[] visited;
	public static void main(String[] args) {
		//long time = System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// 체스판을 1차원 배열로 표현
		// y행 x열 -> map[y*n + x]
		visited = new int[n*n]; 
		
		int ret = solve(n, 0, 0);
		System.out.println(ret);
		//long secDiff = System.currentTimeMillis() - time;
		//System.out.println(secDiff);
		sc.close();
	}
	
	private static int solve(int n, int depth, int start) {
		//기저조건
		if(depth==n) {
			return 1;
		}
		
		//중복없는 조합 생성
		int sum = 0;
		int end = (n*n);
		for(int i=start; i<end; i++) {
			if(visited[i]>0)continue;
			go(n, i, 1);
			sum += solve(n, depth+1, i+1);
			go(n, i, -1);
		}
		
		return sum; 
	}
	
	//더 이상 사용할 수 없는 위치를 방문 체크 혹은 체크 해제
	private static void go(int n, int pos, int num){
		// y행 x열 -> map[y*n + x]
		visited[pos]+=num;
		//가로
		for(int y=pos/n, x=0; x<n; x++) {
			int idx = (y*n)+x;
			if(idx == pos) continue;
			visited[idx] += num;
		}
		//세로
		for(int x=pos%n, y=0; y<n; y++) {
			int idx = (y*n)+x;
			if(idx == pos) continue;
			visited[idx] += num;
		}
		//대각
		int y=pos/n;
		int x=pos%n;
		for(int i=0; i<n; i++) { // 왼쪽 위 -> 오른쪽 아래
			int ny = y - x + i;
			int nx = i;
			if(ny < 0 || ny >= n) continue;
			int idx = ny*n + nx;
			if(idx == pos) continue;
			visited[idx] += num;
		}
		for(int i=0; i<n; i++) { // 왼쪽 아래 -> 오른쪽 위
			int ny = y + x - i;
			int nx = i;
			if(ny < 0 || ny >= n) continue;
			int idx = ny*n + nx;
			if(idx == pos) continue;
			visited[idx] += num;
		}

	}
	
}
