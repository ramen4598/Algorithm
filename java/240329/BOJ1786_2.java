import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// 찾기
// KMP
public class BOJ1786_2 {

	static String T, P;
	static int cnt;
	static int[] pi;
	static List<Integer> list;

	public static void main(String[] args) throws Exception{
		init();
		fail();
		kmp();
		System.out.println(list.size());
		for(Integer i : list) {
			System.out.print(i + " ");
		}
	}
	private static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = br.readLine();
		P = br.readLine();
		cnt = 0;
		pi = new int[P.length()];
		list = new ArrayList<>();
		br.close();
		//debug
		//System.out.println(T);
		//System.out.println(P);
	}
	private static void fail() {
		int m = P.length();
		int j = 0;
		for(int i=1; i<m; i++) {
			while(j>0 && P.charAt(i) != P.charAt(j)) {
				j = pi[j-1];
			}
			if(P.charAt(i) == P.charAt(j)) {
				pi[i] = ++j;
			}
		}
		//debug
		//System.out.println(Arrays.toString(pi));
	}
	private static void kmp() {
		int n = T.length();
		int m = P.length();
		int j = 0;
		for(int i=0; i<n; i++) {
			//System.out.println("-------------------");
			//System.out.println("T"+i+" : "+T.charAt(i));
			//System.out.println("P"+j+" : "+P.charAt(j));
			while(j>0 && T.charAt(i) != P.charAt(j))
				j = pi[j-1];
			if(T.charAt(i)==P.charAt(j)) {
				if(j==m-1) { // 찾음
					cnt++;
					//sb.append(i-j+1).append(" ");
					list.add(i-j+1);
					// 이어서 계속
					j = pi[j]; 
				}else {
					j++;
				}
			}
		}
	
	}

}
