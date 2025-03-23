import java.io.*;
import java.util.StringTokenizer;

public class BOJ15649 {
    static int N, M;
    static int[] visit, ret;

    private static void solve(int depth) {

        if(depth == M){
            StringBuffer sb = new StringBuffer();
            for(int i : ret){
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for(int i=1; i<=N; i++) {
            if(visit[i] == 1) continue;
            visit[i] = 1;
            ret[depth] = i;
            solve(depth+1);
            visit[i] = 0;
        }
    }
   
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new int[N+1];
        ret = new int[M];

        solve(0);

        br.close();
    }
}
