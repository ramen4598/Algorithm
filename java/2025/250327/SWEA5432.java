import java.io.*;
import java.util.StringTokenizer;
import java.util.Stack;

public class SWEA5432 {

    static int ret;
    static char[] input;
    static Stack<Character> stk;

    private static void init(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());

        ret = 0;
        stk = new Stack<Character>();
        input = st.nextToken().toCharArray();
    }

    private static void solve() {
        char before = '!'; // not initatied
        for(char c : input) {
            if(c == '('){
                stk.push(c);
            } else if(c == ')'){
                if (before == '('){ // 레이저
                    stk.pop();
                    ret += stk.size();
                } else { // 막대 끝
                    stk.pop();
                    ret++;
                }
            }
            before = c;
        }
    }

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(st.nextToken());
        for(int tc=1; tc<=T; tc++) {
            init(br);
            solve();
            sb.append("#").append(tc).append(" ").append(ret).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
