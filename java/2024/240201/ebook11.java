
public class ebook11 {
	
	static int[] arr = {-7, -3, -2, 5, 8};
	static boolean[] vis = new boolean[5];
	public static void main(String[] args) {
		solve(0, 0);
	}
	public static void solve(int depth, int sum) {
		if(depth==5) { // 기저조건
			if(sum!=0) return; //합이 0인지 확인
			StringBuffer sb = new StringBuffer();
			for(int i=0; i<5; i++) {
				if(vis[i]) { // 포함했다면 출력
					sb.append(arr[i]).append(" ");
				}
			}
			System.out.println(sb);
			return;
		}
		// 포함
		vis[depth] = true;
		solve(depth+1, sum+arr[depth]);
		// 미포함
		vis[depth] = false;
		solve(depth+1, sum);
	}

}
