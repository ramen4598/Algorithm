import java.io.*;
import java.util.StringTokenizer;
// import java.util.Arrays;

public class BOJ6603 {

    static int K;
    static int[] S, ret;

    private static boolean init(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        // end
        if(K == 0) return false;

        // init ret, S
        ret = new int[6];
        S = new int[K];
        for(int i=0; i<K; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        // System.out.println(Arrays.toString(S));
        return true;
    }

    private static void solve(StringBuffer sb, int depth, int start) {
        if(depth == 6) {
            for(int i : ret){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<K; i++) {
            ret[depth] = S[i];
            solve(sb, depth + 1, i + 1);
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        while(init(br)){
            solve(sb, 0, 0);
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }    
}