import java.util.Scanner;


class BOJ2961 {

	static int n, ret = Integer.MAX_VALUE;
	static int[] ssn, sin;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		ssn = new int[n];
		sin = new int[n];
		
		for(int i=0; i<n; i++) {
			sin[i] = sc.nextInt();
			ssn[i] = sc.nextInt();
		}
		
		solve(0, 0, 0, 1);
		
		System.out.println(ret);
		sc.close();
	}

	public static void solve(int depth, int cnt, int ssnSum, int sinSum) {
		int num = Math.abs(ssnSum - sinSum);
		if(depth==n) {
			if(cnt > 0) { // 최소 하나의 재료는 사용
				ret = Math.min(ret, num); // 최소값 갱신
			}
			return;
		}
		
		solve(depth+1, cnt+1, ssnSum+ssn[depth], sinSum*sin[depth]);
		solve(depth+1, cnt, ssnSum, sinSum);
	}

}
