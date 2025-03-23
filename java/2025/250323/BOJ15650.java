import java.io.*;
import java.util.StringTokenizer;

public class BOJ15650 {
    static int N, M;
    static int[] ret;

    private static void solve(int depth, int start) {

        if(depth == M) {
            StringBuffer sb = new StringBuffer();
            for(int i : ret){
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = start; i<=N; i++) {
            ret[depth] = i;
            solve(depth + 1, i + 1);
        }
    }
   
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ret =  new int[M];

        solve(0, 1);

        br.close();
    }
}