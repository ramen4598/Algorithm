import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

// nCr
public class BOJ2309 {

    final static int N = 9, R = 7;
    static boolean ended = false;
    static int[] h, ret;
    public static void main(String[] args) throws IOException {
        
        init();

        solve(0, 0);

        Arrays.sort(ret);
        for (int i : ret){
           System.out.println(i); 
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        h = new int[N];
        ret = new int[R];

        for(int i=0; i<N; i++){
            String input = br.readLine().trim();
            h[i] = Integer.parseInt(input);
        }
        br.close();

        // System.out.println(Arrays.toString(h));
    }

    private static void solve(int depth, int start) {
        // System.out.println(Arrays.toString(ret));
        if(depth == R){
            int sum = 0;
            for (int i : ret) {
                sum += i;
            }
            // System.out.println(sum);
            if(sum == 100){
                ended = true;
            }
            return;
        }

        for(int i=start; i<N; i++){
            if(ended) break;
            ret[depth] = h[i];
            solve(depth+1, i+1);
        }
    }
}