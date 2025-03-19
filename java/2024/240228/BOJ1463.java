import java.util.Arrays;
import java.util.Scanner;

// 하향식 DP 
public class BOJ1463 {
	static int N, ret = Integer.MAX_VALUE; // 입력받은 수
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// dp 초기화
		dp = new int[N+1];
		Arrays.fill(dp,  Integer.MAX_VALUE);

		ret = solve(N);

		System.out.println(ret);
		sc.close();
	}
	
	static int solve(int num) {
		//if(cnt > ret) return;
		if(num == 1) {
			return 0;
		}

		// 중복된 계산을 방지한다.
		if(dp[num] != Integer.MAX_VALUE) {
			return dp[num];
		}

		// 최초 1회 실행
		int min = Integer.MAX_VALUE;
		if(num%3==0) min = Math.min(min, solve(num/3) + 1);
		if(num%2==0) min = Math.min(min, solve(num/2) + 1);
		min = Math.min(min,  solve(num-1)+1);
		
		return dp[num] = min;
	}
}
