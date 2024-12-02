import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1991 {

	static int N; // 알파벳 개수 26개
	static Node[] tree;
	static StringBuffer sb; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 초기화
		sb = new StringBuffer();
		N = Integer.parseInt(st.nextToken());
		tree = new Node[N];
		input(br);

		// 순회
		dfsByPreorder(tree[0]);
		sb.append("\n");
		dfsByInorder(tree[0]);
		sb.append("\n");
		dfsByPostorder(tree[0]);
		sb.append("\n");
		
		// 출력
		System.out.println(sb.toString());
		br.close();
	}

	static void input(BufferedReader br) throws Exception {
		for(int i=0; i<N; i++) { // 노드 저장
			String[] input = br.readLine().trim().split(" ");
			char value = input[0].charAt(0);
			char left = input[1].charAt(0);
			char right = input[2].charAt(0);
			
			// 자기 자신이 존재하는지
			if(tree[value -'A']== null) {
				tree[value -'A'] = new Node(value); // 없으면 생성
			}
			Node node = tree[value -'A'];
			
			// left가 존재하는지
			if(left!='.') {
				tree[left -'A'] = new Node(left);
				node.left = tree[left - 'A']; // left node 설정
			}
			
			// right가 존재하는지
			if(right!='.') {
				tree[right -'A'] = new Node(right);
				node.right = tree[right - 'A']; // right node 설정
			}
		}
	}
	// 전위 순회
	private static void dfsByPreorder(Node node) {
		if(node == null) return;
		sb.append(node.value);
		dfsByPreorder(node.left);
		dfsByPreorder(node.right);
	}
	// 중위 순회
	private static void dfsByInorder(Node node) {
		if(node == null) return;
		dfsByInorder(node.left);
		sb.append(node.value);
		dfsByInorder(node.right);
	}
	// 후위 순회
	private static void dfsByPostorder(Node node) {
		if(node == null) return;
		dfsByPostorder(node.left);
		dfsByPostorder(node.right);
		sb.append(node.value);
	}
	
	static class Node {
		char value;
		Node left;
		Node right;
		
		Node(char value){
			this.value = value;
		}
	}

}
