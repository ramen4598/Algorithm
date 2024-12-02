import java.util.Scanner;

public class BOJ11726_2 { // 108ms

	static int N;
	static int[] dp;
	public static void main(String[] args) throws Exception {
		init();
		solve();
	}
	static void init() throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new int[N+1];
	}
	static void solve() {
		dp[1] = 1; 
		if(N>1)dp[2] = 2;
		for(int i=3, end=N+1; i<end; i++) {
			dp[i] = (dp[i-2] + dp[i-1]) % 10007;
		}
		System.out.println(dp[N]);
	}
}
