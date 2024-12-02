
import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

//public class Main {
public class baekjoon9658 {
	static boolean[][] arr = new boolean[1001][3];
	static final int[] dn = {1,3,4};

	public static void init(){
		for(int i=0; i<1001; i++){
			for(int j=0; j<3; j++){
				arr[i][j] = false;
			}
		}
		// n=1
		//arr[1][0] = false;
		//arr[1][1] = false;
		//arr[1][2] = false;
		// n=2
		arr[2][0] = true;
		//arr[2][1] = false;
		//arr[2][2] = false;
		// n=3
		//arr[3][0] = false;
		//arr[3][1] = false;
		//arr[3][2] = false;
		// n=4
		arr[4][0] = true;
		arr[4][1] = true;
		//arr[4][2] = false;
		// n=5
		//arr[5][0] = false;
		//arr[5][1] = false;
		arr[5][2] = true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		init();
		int n = Integer.parseInt(st.nextToken());
		for(int i=6; i<=n; i++){
			for(int j=0; j<3; j++){
				int tmp = dn[j];
				if(arr[i-tmp][0]||arr[i-tmp][1]||arr[i-tmp][2]){
					continue;
				}
				arr[i][j] = true;
			}
		}

		String ret = arr[n][0] || arr[n][1] || arr[n][2] ? "SK" : "CY";
		System.out.println(ret);
	}
}
