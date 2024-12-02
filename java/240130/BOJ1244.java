import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1244 {

	public static char[] switches;
	public static int swi, stu;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		swi = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		switches = new char[swi+1];
		for(int i=1; i<=swi; i++) {
			switches[i] = st.nextToken().charAt(0);
		}

		//student
		st = new StringTokenizer(br.readLine());
		stu = Integer.parseInt(st.nextToken());
		
		for(int i =0; i<stu; i++) {
			st = new StringTokenizer(br.readLine());
			String gender = st.nextToken();
			if(gender.equals("1")) 
				man(Integer.parseInt(st.nextToken()));
			else if(gender.equals("2")) 
				woman(Integer.parseInt(st.nextToken()));
		}
		
		//result
		int cnt = 0;
		for(int i=1; i<=swi; i++) {
			System.out.print(switches[i]+ " ");
			cnt++;
			if(cnt==20) {
				System.out.println();
				cnt=0;
			}
		}
	}
	public static void man (int idx) {
		for(int i=1; i*idx<=swi; i++){
			switches[i*idx] = switches[i*idx] == '1' ? '0' : '1';
		}
	}
	public static void woman(int idx){
		switches[idx] = switches[idx] == '1' ? '0' : '1';
		for(int start = idx-1, end=idx+1; start>0 && end<=swi; start--, end++){
			if(switches[start] == switches[end]){
				switches[start] = switches[start] == '1' ? '0' : '1';
				switches[end] = switches[end] == '1' ? '0' : '1';
			}else break;
		} 
	}
}
