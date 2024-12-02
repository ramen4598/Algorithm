import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ23300 {

	static int N, Q;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		//현재 페이지
		int cur = 0;
		//뒤고 가기
		Stack<Integer> back = new Stack<>();
		//앞으로 가기
		Stack<Integer> front = new Stack<>();
		
		String oper = "";
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			oper = st.nextToken();
			switch(oper) {
			case "B" :
				//뒤로 가기 공간에 1개 이상의 페이지가 저장되어 있을 때만 2,3번 과정이 실행된다. 0개일 때 이 작업은 무시된다.
				if(back.isEmpty()) break;
				//현재 보고 있던 웹페이지를 앞으로 가기 공간에 저장한다.
				front.push(cur);
				//뒤로 가기 공간에서 방문한지 가장 최근의 페이지에 접속한다. 그리고 해당 페이지는 뒤로 가기 공간에서 삭제된다.
				cur = back.pop();
				break;
			case "F" :
				//앞으로 가기 공간에 1개 이상의 페이지가 저장되어 있을 때만 2,3번 과정이 실행된다. 0개일 때 이 작업은 무시된다.
				if(front.isEmpty()) break;
				//현재 보고 있던 페이지를 뒤로 가기 공간에 저장한다.
				back.push(cur);
				//앞으로 가기 공간에서 방문한지 가장 최근의 페이지에 접속한다. 그리고 해당 페이지는 앞으로 가기 공간에서 삭제된다.
				cur = front.pop();
				break;
			case "A" :
				//앞으로 가기 공간에 저장된 페이지가 모두 삭제된다.
				front.clear();
				//현재 페이지를 뒤로 가기 공간에 추가하고, 
				if(cur!=0)	//단, 처음으로 웹페이지에 접속하는 경우라면 현재 페이지를 뒤로 가기 공간에 추가하지 않는다.
					back.push(cur);
				//다음에 접속할 페이지가 현재 페이지로 갱신된다. 
				cur = Integer.parseInt(st.nextToken());
				break;
			case "C" :
				//뒤로 가기 공간에서 같은 번호의 페이지가 연속해서 2개 이상 등장할 경우, 
				//가장 최근의 페이지 하나만 남기고 나머지는 모두 삭제한다.
//				for(int depth=back.size()-1; depth>0; depth--) {
//					//System.out.println(depth);
//					if(back.get(depth) == back.get(depth-1)) {
//						//System.out.println("remove : " + back.get(depth));
//						back.remove(depth);
//					}
//				}
				Stack<Integer> tmp = new Stack<>();
				while(!back.isEmpty()) {
					int num = back.pop();
					if(!tmp.isEmpty() && tmp.peek()==num) {
						continue;
					}
					tmp.push(num);
				}
				while(!tmp.isEmpty()) {
					back.push(tmp.pop());
				}
				break;
			}
			
		}
		StringBuffer sb = new StringBuffer();
		// 현재 페이지 번호
		sb.append(cur).append("\n");
		// 뒤로 가기 공간. 가장 최근에 방문한 순서대로 페이지 번호 출력. 없으면 -1.
		if(back.isEmpty()) {
			sb.append(-1).append("\n");
		}else {
			while(!back.isEmpty()) {
				sb.append(back.pop()).append(" ");
			}
			sb.append("\n");
		}
		// 앞으로 가기 공간. 가장 최근에 방문한 순서대로 페이지 번호 출력. 없으면 -1.
		if(front.isEmpty()) {
			sb.append(-1).append("\n");
		}else {
			while(!front.isEmpty()) {
				sb.append(front.pop()).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
		br.close();
	}

}
