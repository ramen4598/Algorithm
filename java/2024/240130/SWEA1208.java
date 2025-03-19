import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1208 {

	static int dump, max, min;
	static int[] arr = new int[100];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for(int tc=1; tc<=10; tc++) {
			Arrays.fill(arr, 0);
			max = 0;
			min = 0;
			
			st = new StringTokenizer(br.readLine());
			dump = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for(int i=0; i<100; i++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i] = num;			
				find();
			}

			solve();
				
			int ret = arr[max] - arr[min];
			System.out.println("#"+tc+" "+ret);
		}
	}
	
	public static void solve() {
		for(int i=dump; i>0; i--) {
			if((arr[max]-arr[min])<=1) {
				return;
			}
			arr[max]--; arr[min]++;
			find();
		}
	}

	public static void find() {
		for(int i=0; i<100; i++) {
			if(arr[i] > arr[max]){
				max = i;
			}
			if(arr[i] < arr[min]){
				min = i;
			}
		}
	}

}
