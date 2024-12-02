import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10972 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] input = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		next_Permutation(input);
		br.close();
	}
	
	public static void next_Permutation(int[] input) {
		int last = input.length - 1;
		int i = last;
		while(i>0 && input[i-1] >= input[i]) i--;
		if(i==0) {
			System.out.println(-1);
			return;
		}
		
		int j = last;
		while(input[i-1] >= input[j]) j--;
		
		swap(input, i-1, j);
		
		int k = last;
		while(i<k) swap(input, i++, k--);
		
		StringBuffer sb = new StringBuffer();
		for(int num : input) {
			sb.append(num).append(" ");
		}
		System.out.println(sb);
	}
	public static void swap(int[] input, int i, int j) {
		int tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
	}

}
