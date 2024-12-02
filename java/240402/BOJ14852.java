import java.util.Scanner;

// 타일 채우기 3
public class BOJ14852 {
	static int N;
	static final int p = 1000000007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		long[] dp = new long[N+1];
		// dp[1] = 2;
		// for(int i=2; i<=N; i++) {
		// 	dp[i] = (dp[i-1] * 3 + 1) % p;
		// }
		System.out.println(dp[N]);
	}
}
