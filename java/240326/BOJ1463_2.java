import java.util.Arrays;
import java.util.Scanner;

// 1로 만들기
public class BOJ1463_2 {
	
	static int N, ret;
	static final int INF = Integer.MAX_VALUE;
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ret = Integer.MAX_VALUE;

		//solve1();
		//System.out.println(ret);
		solve2();
		System.out.println(ret);
	}

	private static void solve1() { // 상향  -> 140ms
		dp = new int[N+1];
		for(int i=2; i<=N; i++) {
			dp[i] = dp[i-1];
			if(i%3==0)dp[i] = Math.min(dp[i], dp[i/3]);
			if(i%2==0)dp[i] = Math.min(dp[i], dp[i/2]);
			dp[i]++;
			//System.out.println(i + " : " + dp[i]);
		}
		ret = dp[N];
	}

	private static void solve2() { // 하향  -> 160ms
		dp = new int[N+1];
		Arrays.fill(dp, INF);
		dp[1] = 0;
		ret = go(N);
	}
	private static int go(int depth) {  // 재귀 함수
		if(dp[depth] != INF) {
			return dp[depth];
		}

		if(depth%3==0)dp[depth] = Math.min(dp[depth], go(depth/3));
		if(depth%2==0)dp[depth] = Math.min(dp[depth], go(depth/2));
		dp[depth] = Math.min(dp[depth], go(depth-1));

		return ++dp[depth];
	}
}
