import java.io.*;
import java.util.StringTokenizer;

class Solution {

	static int n;
	static int ret;
	
	public static void solve(int[] arr, int depth, int big, int cnt) {
		if(depth == n){
			ret = Math.max(ret, cnt);
			//System.out.println("cnt : " + cnt + " " + "ret : " + ret);
			return;
		}
		if(big < arr[depth]){
			//System.out.print(arr[depth] + " ");
			solve(arr, depth + 1, arr[depth], cnt + 1);
		}
		solve(arr, depth + 1, big, cnt);
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for(int tc=1; tc<=T; tc++) {
			ret = 0;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());

			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++){
				arr[i]  = Integer.parseInt(st.nextToken());
			}
			solve(arr, 0, 0, 0);
			System.out.println("#" + tc + " " + ret);
		}
		br.close();
	}

}
			
