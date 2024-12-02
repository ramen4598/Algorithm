import java.util.Arrays;
import java.util.Scanner;

// 상향식 DP 
public class BOJ1464_2 {
	static int N, ret = Integer.MAX_VALUE; // 입력받은 수
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// dp 초기화
		dp = new int[N+1]; // i까지의 수의 최소 연산 횟수
		Arrays.fill(dp,  Integer.MAX_VALUE);

		dp[1] = 0; // 기저 조건
		for(int i=2, end=N+1; i<end; i++) { // 2부터 N까지 최소 연산 횟수를 구한다.
			// 저장된 계산 결과 활용
			dp[i] = dp[i-1] + 1;
			if(i%3==0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
			if(i%2==0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
		}

		System.out.println(dp[N]);
		sc.close();
	}
}
