import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA1233_2 {

	static int N;
	static List<Node> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();

		for(int tc=1; tc<=10; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			list = new ArrayList<>(N);
			list.add(null); // 0번째

			// 노드 저장
			for(int i=1; i<=N; i++) {
				String[] input = br.readLine().split(" ");
				Node newNode = new Node(input[1], i*2, i*2+1);
				list.add(newNode);
			}

			// 계산 가능한 식인지 검사
			boolean flag = check();

			sb.append("#").append(tc).append(" ").append(flag ? 1 : 0).append("\n");
		}

		System.out.println(sb);
		br.close();
	}
	
	static boolean check() {
		for(int i=1; i<=N; i++) {
			Node node = list.get(i);
			
			// 단말노드면 숫자
			if((node.left>N)&&(node.right>N)) {
				boolean isNum = '0' <= node.data.charAt(0) && node.data.charAt(0) <= '9';
				if(!isNum) return false;
			}
			// 비단말노드면 +-*/
			else {
				boolean isOper = false;
				isOper = node.data.charAt(0) == '+' || node.data.charAt(0) == '-' || node.data.charAt(0) == '*' || node.data.charAt(0) == '/'; 
				if(!isOper) return false;
			}
		}
		return true;
	}
	
	static class Node {
		String data;
		int left;
		int right;
		
		Node(String data, int left, int right){
			this.data = data;
			this.left = left;
			this.right = right;
		}

	}

}
