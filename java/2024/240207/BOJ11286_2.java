import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BOJ11286_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb =new StringBuffer();

		int N = Integer.parseInt(st.nextToken());
		MyHeap myHeap = new MyHeap(N);
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			//System.out.println(i);

			if(num==0) { // 삭제
				Node tmp = myHeap.getMin();
				int ret = tmp==null ? 0 : tmp.value; // 배열이 비었으면 0 출력
				sb.append(ret).append("\n");
			}else { // 삽입
				myHeap.add(new Node(num));
			}
			//System.out.println(myHeap);
		}
		
		// 출력
		System.out.println(sb.toString());
		br.close();
	}
	
	static class MyHeap {
		Node[] arr;
		int size;
		int root = 1;
		int last = 0;
		
		MyHeap(int size){
			this.size = size;
			this.arr = new Node[size+1];
		}
		
		public void add(Node node) {
			arr[++last] = node;
			int idx = last;
			while(idx>1 && myCompare(idx, idx/2)) { //자식, 부모
				swap(idx, idx/2);
				idx /= 2;
			}
		}
		
		// from이 더 작으면 true
		private boolean myCompare(int from, int to) {
			int fromV = arr[from].value;
			int toV = arr[to].value;

			if(Math.abs(fromV) == Math.abs(toV))
				return fromV < toV;
			return Math.abs(fromV) < Math.abs(toV);
		}

		public Node getMin() {
			if(last < 1) return null;
			Node ret = arr[root];// 최소값 반환
			arr[root] = arr[last];
			arr[last] = null;
			last--;

			int idx = root;
			while(idx <= last/2) {
				int child;
				if(arr[idx*2+1]==null) { // 자식이 하나인 경우
					child = idx*2;
				}else {
					child = myCompare(idx*2, idx*2+1) ? idx*2 : idx*2+1 ; // 더 작은 자식
				}

				if(myCompare(child, idx)) { // 자식이 더 작으면 교환
					swap(child, idx);
					idx = child;
				}else {
					break;
				}
			}
			return ret;
		}
		
		private void swap(int idx1, int idx2) {
			Node tmp = arr[idx1];
			arr[idx1] = arr[idx2];
			arr[idx2] = tmp;
		}
		
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();

			for(int i=1; i<=last; i++) {
				sb.append(arr[i].value).append(" ");
			}
			
			return sb.toString();
		}

	}
	static class Node {
		int value;

		public Node(int value) {
			this.value = value;
		}
		
	}
}