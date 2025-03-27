import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ2164 {

    static int N, ret;
    static Queue<Integer> q;

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        q = new ArrayDeque<Integer>();

        for(int i=0; i<N; i++){
            q.offer(i+1);
        }
    }

    private static void solve(){
        while(q.size()>1){
            q.poll();
            q.offer(q.poll());
        }
        ret = q.poll();
    }

    public static void main(String[] args) throws Exception {
        init();
        solve();
        System.out.println(ret);
    }

}