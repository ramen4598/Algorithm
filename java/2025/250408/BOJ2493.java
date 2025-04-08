import java.io.*;
import java.util.StringTokenizer;
import java.util.Stack;
import java.util.Arrays;

public class BOJ2493 {

    static int N;
    static int[] ret;
    static Stack<Tower> towers, signals; 
    static StringBuffer sb;

    private static class Tower {
        int num;
        int height;

        public Tower (int num, int height) {
            this.num = num;
            this.height = height;
        }
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        ret = new int[N+1];
        towers = new Stack<>(); // 타워
        signals = new Stack<>(); // 신호
        sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());
        for(int i=1, end=N+1; i<end; i++) {
            towers.push(new Tower(i, Integer.parseInt(st.nextToken())));
        }
    }

    private static void solve() {
        Tower cur;
        while(!towers.isEmpty()){
            cur = towers.pop();
            while(!signals.isEmpty()){
                // 신호 도달 X
                if (signals.peek().height > cur.height) {
                    break;
                }
                // 신호 도달
                ret[signals.pop().num] = cur.num;
            }
            signals.push(cur);
        }
    }    

    public static void main (String[] args) throws Exception {
        init();
        solve();

        for(int i=1, end=N+1; i<end; i++)
            sb.append(ret[i]).append(" ");
        System.out.println(sb);
    }
}
