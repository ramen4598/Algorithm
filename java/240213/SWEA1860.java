import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1860 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(st.nextToken());
		
		int[] arr;
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			arr = new int[11112];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				arr[Integer.parseInt(st.nextToken())]++;
			}
			//for(int i=0; i<11112; i++) {
			//	System.out.print(arr[i]+" ");
			//}

			boolean flag = true;
			int cnt;
			int store = 0;
			for(int i=0; i<11112; i+= m) {
				cnt=0;
				for(int j=0; j<m; j++) {
					if(i+j<11112) cnt += arr[i+j];
				}
				if(cnt > store) { // impossible
					flag = false;
					//System.out.println(i + " " + cnt + " " + store);
					break;
				}
				store = store-cnt+k;
			}

			sb.append("#").append(tc).append(" ").append(flag ? "Possible" : "Impossible").append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
