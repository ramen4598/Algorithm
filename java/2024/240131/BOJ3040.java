import java.util.Scanner;

public class BOJ3040 {

	static int[] arr = new int[9];
	static int[] ret = new int[7];
	static boolean done = false;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<9; i++) {
			arr[i]=sc.nextInt();
		}
		
		solve(0, 0, 0);
		
		sc.close();
	}

	// 중복없는 조합
	public static void solve(int depth, int start, int sum) {
		if(done) return; // 이미 찾았으면 빠르게 통과
		if(sum > 100) return;
		if(depth==7) {
			if(sum != 100) return; // 합이 100이 아니면 리턴
			for(int num : ret) {
				System.out.println(num);
			}
			//System.exit(0);
			done = true; // 찾았음
			return;
		}
		for(int i=start; i<9; i++) {
			ret[depth] = arr[i];
			solve(depth+1, i+1, sum+arr[i]);
		}
		return;
	}
	
}
