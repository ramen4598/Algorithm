import java.util.Scanner;

//시간 초과
public class BOJ2023 {

	static int N;
	static StringBuffer sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sb = new StringBuffer();

		// 1. 왼쪽부터 1번째 자리에 들어올 수 있는 수 → 2, 3, 5, 7
		int[] arr = {2, 3, 5, 7};
		for(int first : arr){
			solve(1, first);
		}

		System.out.println(sb);
		sc.close();
	}

	public static void solve(int depth, int num){
		if(depth==N){
			sb.append(num).append("\n");
			return;
		}
		// 2. 2 번째 ~ N 번째 자리에 들어올 수 있는 수 → 홀수
		int next = num * 10;
		for(int i=1; i<10; i+=2){
			if(!check(next+i)) continue; //소수가 아니면 통과
			solve(depth+1, next+i);
		}
	}
	// 3. 어떤 수 `num`이 소수인지 확인하는 방법 → 2부터 `num`의 제곱근까지 나누어 떨어지면 안된다.
	public static boolean check(int num){
		int limit = (int)Math.sqrt(num);
		for(int i=2; i<=limit; i++){
			if(num%i==0) return false; // 아니면 false;
		}
		return true;// 소수면 true
	}
}
