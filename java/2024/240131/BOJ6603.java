import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class BOJ6603 {

	static int[] arr, ret;
	static int k;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
				
		while(true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			
			// 입력 종료
			if(k==0)break;

			arr = new int[k];
			ret = new int[6];

			for(int i=0; i<k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			solve(0, 0);
			bw.newLine();
		}

		bw.flush();
		bw.close();
		br.close();
		
	}
	public static void solve(int depth, int start) throws IOException {
		if(depth == 6) {
			for(int i : ret) {
				bw.write(i + " ");
			}
			bw.newLine();
			return;
		}

		for(int i=start; i<k; i++) {
			ret[depth] = arr[i];
			solve(depth+1, i+1);
		}
	}
}