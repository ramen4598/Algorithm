import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA5432 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		Stack<Character> stk;
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			char[] input = st.nextToken().toCharArray();

			stk = new Stack<>();
			int sum = 0;
			char cur = ' ';
			for(char c : input) {
				switch (c) {
				case '(' : // 쇠막대 시작 또는 레이저 시작
					stk.push(c);
					break;
				case ')' :
					if(cur == ')'){ // 쇠막대 끝
						stk.pop();
						sum++;
					}
					if(cur == '('){ //레이저 끝
						stk.pop();
						sum += stk.size();
					}
					break;
				}
				cur = c;
			}
			System.out.printf("#%d %d%n", tc, sum);
		}
		br.close();
	}

}
