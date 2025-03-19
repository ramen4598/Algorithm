import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 찾기
// KMP
public class BOJ1786 { // 시간 초과

	static String T, P;
	static int cnt;
	static int[] pi;
	public static void main(String[] args) throws Exception{
		BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		init();
		fail();
		kmp(sb);
		bw.write(String.valueOf(cnt)+"\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = br.readLine().trim();
		P = br.readLine().trim();
		cnt = 0;
		pi = new int[P.length()];
		br.close();
		//debug
		//System.out.println(T);
		//System.out.println(P);
	}
	private static void fail() {
		int idx = 0;
		int j = 1;
		int Psize = P.length();
		while (j<Psize) {
			if(P.charAt(idx)==P.charAt(j)) {
				idx++;
				pi[j] = idx;
				j++;
			}else if(idx > 0) {
				idx = pi[idx-1];
			}else {
				j++;
			}
		}
		//debug
		//System.out.println(Arrays.toString(pi));
	}
	private static void kmp(StringBuffer sb) {
		int idx = 0;
		int j = 0;
		int Tsize = T.length();
		int Psize = P.length();
		while(idx<Tsize && j<Psize) {
			//System.out.println("idx : " + idx + ", T.charAt(idx) : " + T.charAt(idx));
			//System.out.println("j : " + j + ", P.charAt(j) : " + P.charAt(j));
			if(T.charAt(idx) == P.charAt(j)) {
				idx++;
				j++;
			}else if(j != 0) {
				j = pi[j-1];
			}else {
				idx++;
			}
			if(j == Psize) { // 일치
				cnt++;
				sb.append(idx-j+1).append(" ");
				// 이어서 탐색
				idx = idx-j+2;
				j = 0;
			}
		}
	}

}
