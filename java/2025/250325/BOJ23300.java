import java.io.*;
import java.util.StringTokenizer;
import java.util.Stack;

public class BOJ23300 {

    static final int FIRST = -1;
    static int N, Q, cur;
    static Stack<Integer> back, forward, com;

    private static void doBackward() {
        // 1
        if (back.isEmpty()) return;
        // 2
        forward.push(cur);
        // 3
        cur = back.pop();
    }

    private static void doForward() {
        // 1
        if (forward.isEmpty()) return;
        // 2
        back.push(cur);
        // 3
        cur = forward.pop();
    }

    private static void doAccess(int next) {
        // 1
        forward.clear();
        // 2
        if (cur != FIRST) 
            back.push(cur);
        cur = next;
    }

    private static void doCompress() {
        // 뒤로가기 스택 -> 압축 스택
        int tmp;
        while(!back.isEmpty()){
            tmp = back.pop();

            // top과 같으면 패스
            if(!com.isEmpty() && com.peek() == tmp){
                continue;
            }

            com.push(tmp);
        }
        // 압축 스택 -> 뒤로가기 스택
        while(!com.isEmpty()){
            back.push(com.pop());
        }
    }
    
    private static void printStack(Stack<Integer> st, StringBuffer sb) {
        // 없으면 -1
        if (st.isEmpty()){
            sb.append(-1).append("\n");
            return;
        }

        while(!st.isEmpty()){
          sb.append(st.pop()).append(" "); 
        }
        sb.append("\n");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        cur = FIRST; // not initiated

        back = new Stack<Integer>();
        forward = new Stack<Integer>();
        com = new Stack<Integer>(); // 압축을 위한 임시 스택

        int page;
        char work;
        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            work = st.nextToken().charAt(0);
            switch (work) {
                case 'B':
                    doBackward(); 
                    break;
                case 'F':
                    doForward(); 
                    break;
                case 'A':
                    page = Integer.parseInt(st.nextToken());
                    doAccess(page); 
                    break;
                case 'C':
                    doCompress(); 
                    break;
            }
        }

        StringBuffer sb = new StringBuffer();
        sb.append(cur).append(" ").append("\n");
        printStack(back, sb);
        printStack(forward, sb);
        System.out.println(sb);
    }
}