import java.io.*;
import java.util.StringTokenizer;
// import java.util.Arrays;

public class BOJ3040 {

    static boolean done = false;
    static int imposter;
    static int[] input, two;

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int sum = 0;

        two = new int[2];
        input = new int[9];
        for(int i = 0; i<9; i++){
            st = new StringTokenizer(br.readLine());
            input[i] = Integer.parseInt(st.nextToken());
            sum += input[i];
        }
        imposter = sum - 100;

        // System.out.println(Arrays.toString(input));
        br.close();
    }

    private static void solve(int depth, int start, int sum) {
        if (done) return;
        if (sum > imposter) return;
        if (depth == 2) {
            if(sum == imposter){
                StringBuffer sb = new StringBuffer();
                for(int i : input) {
                    if(i == two[0] || i == two[1])
                        continue;
                    sb.append(i).append("\n");
                }
                System.out.println(sb);
                done = true;
            }
            return;
        }

        for(int i=start; i<9; i++) {
            two[depth] = input[i];
            solve(depth + 1, i + 1, sum + two[depth]);
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        solve(0, 0, 0);
    }
}
