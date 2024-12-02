import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1233 {

	static String[] opers = {"+", "-", "*", "/"};
	static int level, firstLeaf, lastLeaf;
	static int N;
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		for(int tc=1; tc<=10; tc++) {
//		for(int tc=1; tc<=1; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			level = (int)(Math.log(N)/Math.log(2));
			firstLeaf = (int)Math.pow(2, level) - ((int)Math.pow(2, (level+1))-1-N)/2;
			lastLeaf = N;
			//System.out.println(level+" "+firstLeaf+" "+lastLeaf);

			boolean flag1 = checkOper(tc);
			boolean flag2 = checkLeaf(tc);
			sb.append("#").append(tc).append(" ").append((flag1 && flag2) ? 1 : 0).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

	static boolean checkOper(int tc) throws Exception {
		boolean flag = true;
		label : for(int i=1; i<firstLeaf; i++) { // 루트, 중간 노드
			String[] arr = br.readLine().split(" ");

			// 연산자인지 확인
			for(String oper : opers) {
				if(arr[1].equals(oper)) {
					continue label;
				}
			}
			flag = false;
			//System.out.println(tc+"oper i :"+i + " node : " + arr[0]+" : "+ arr[1]);
		}
		return flag; // 모든 검사 통과
	}
	
	static boolean checkLeaf(int tc) throws Exception {
		boolean flag = true;
		label : for(int i=firstLeaf; i<=lastLeaf; i++) { // 단말 노드
			String[] arr = br.readLine().split(" ");

			// 숫자인지 확인
			if((arr[1].charAt(0) >= '0') && (arr[1].charAt(0) <= '9')) { 
				continue label;
			}
			flag = false;
			//System.out.println(tc+" leaf i :"+i + " node : " + arr[0]+" : "+ arr[1]);
		}
		return flag; // 모든 검사 통과
	}
}
