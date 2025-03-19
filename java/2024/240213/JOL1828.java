import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JOL1828 {

	static int N;
	static Thing[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		arr = new Thing[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			Thing thing = new Thing(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			arr[i] = thing;
		}
		
		Arrays.sort(arr);
		
		int ret = 0;
		int cur = -999;
		for(int i=0; i<N; i++) {
			if(arr[i].start > cur) {
				cur = arr[i].end;
				ret++;
			}
		}
		
		System.out.println(ret);
		br.close();
	}
	
	static class Thing implements Comparable<Thing> {
		int start, end;
		Thing(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Thing o) {
			return this.end == o.end ? this.start - o.start : this.end - o.end;
		}
	}

}
