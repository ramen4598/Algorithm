import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA16546 {

	static int[] cnt;
	static int max;
	static boolean flag;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++) {
			
			max = 0;
			cnt = new int[10];
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();

			// 6개 카운팅 및 최대 빈도수 구하기
			for(int i=0; i<6; i++) {
				int num = input.charAt(i) - '0';
				cnt[num]++;
				if(cnt[max] < cnt[num]) {
					max = num;
				}
			}

			solve();
			
			sb.append("#").append(tc).append(" ").append(flag).append('\n');
		}
		
		System.out.println(sb.toString());
		br.close();
	}
	
	
	public static void solve() {
		flag = true;
		switch (cnt[max]) {
		case 1 : case 2 : // run 2개
			if(!run()) flag = false;
			if(!run()) flag = false;
			break;
		case 3 :  // triplet 1개 run 1개 또는 triplet 2개
			if(!triplet()) flag = false;
			if(!triplet() && !run()) flag = false;
			break;
		case 4 : // triplet 1개 run 1개
			if(!triplet()) flag = false;
			if(!run()) flag = false;
			break;
		case 5 : // 불가
			flag = false;
			break;
		case 6 : // triplet 2개
			flag = true;
			break;
		}
	}
	
	public static boolean run() {
		for(int i=0; i<=7; i++) {
			if(cnt[i] > 0 && cnt[i+1] > 0 && cnt[i+2] > 0) {
				cnt[i]--;
				cnt[i+1]--;
				cnt[i+2]--;
				return true;
			}
		}
		return false;
	}
	
	public static boolean triplet() {
		for(int i=0; i<10; i++) {
			if(cnt[i]>=3) {
				cnt[i] -= 3;
				return true;
			}
		}
		return false;
	}

}
