import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ11660 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out, "UTF-8"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n+1][n+1];
		
		for(int x=1; x<=n; x++) {
			st = new StringTokenizer(br.readLine());
			for(int y=1; y<=n; y++) {
				map[x][y] = map[x][y-1] + Integer.parseInt(st.nextToken());
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int x1, y1, x2, y2;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			for(int x=x1; x<=x2; x++) {
				sum += map[x][y2] - map[x][y1-1];
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
