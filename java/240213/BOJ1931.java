import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1931 {

	private static class Meeting implements Comparable<Meeting> {
		int start, end;
		
		Meeting (int start, int end){
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Meeting o) {
			return this.end == o.end ? Integer.compare(this.start, o.start) : Integer.compare(this.end, o.end);	
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		Meeting[] meetings = new Meeting[N];
		
		for(int i=0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			meetings[i] = new Meeting(start, end);
		}
		
		Arrays.sort(meetings);
		
		List<Meeting> list = new ArrayList<>();
		list.add(meetings[0]);
		for(int i=1; i<N; i++) {
			if(meetings[i].start >= list.get(list.size()-1).end) {
				list.add(meetings[i]);
			}
		}
		
		System.out.println(list.size());
		br.close();
	}

}
