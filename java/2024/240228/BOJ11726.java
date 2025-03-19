import java.util.Scanner;

public class BOJ11726 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N+2];
		
		dp[1] = 1;
		dp[2] = 3;
		for(int i=3, end=N+1; i<end; i++) {
			dp[i] = (dp[i-1] + 2 * dp[i-2]) % 10007;
		}
		
		System.out.println(dp[N]);
		sc.close();
	}
}
