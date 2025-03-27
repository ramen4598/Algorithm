import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ1158 {

    static int N, K;
    static StringBuffer sb;
    static Queue<Integer> q;

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        sb = new StringBuffer();
        q = new ArrayDeque<Integer>();
        for(int i=1, end=N+1; i<end; i++){
            q.offer(i);
        }

        br.close();
    }    

    private static void solve() {
        int cnt = 1;
        sb.append("<");
        while(q.size() > 1){
            if(cnt == K){
                sb.append(q.poll()).append(", ");
                cnt = 1;
                continue;
            }
            q.offer(q.poll());
            cnt++;
        }
        sb.append(q.poll()).append(">");
    }

    public static void main(String[] args) throws Exception {
        init();
        solve();
        System.out.println(sb);
    }
    
}
