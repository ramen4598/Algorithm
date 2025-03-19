import java.io.*;
import java.util.StringTokenizer;
// import java.util.Arrays;

public class BOJ9658 {

    static final int ONE = 0, THREE = 1, FOUR = 2;
    static int N;
    static boolean[][] dp;

    private static void init () throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        // dp table 초기화
        dp = new boolean[1001][3];
        for(int i=0; i<1001; i++) {
            for(int j=0; j<3; j++) {
                dp[i][j] = false;
            }
        }
        // N = 1
        // dp[1][ONE] = false;
        // dp[1][THREE] = false;
        // dp[1][FOUR] = false;

        // N = 2
        dp[2][ONE] = true;
        // dp[2][THREE] = false;
        // dp[2][FOUR] = false;

        // N = 3
        // dp[3][ONE] = false;
        // dp[3][THREE] = false;
        // dp[3][FOUR] = false;

        // N = 4
        dp[4][ONE] = true;
        dp[4][THREE] = true;
        // dp[4][FOUR] = false;

        // System.out.println(N);
        // for(boolean[] arr : dp){
        //     System.out.println(Arrays.toString(arr));
        // }

        br.close();
    }

    private static void solve() {
        for(int i=5; i<=N; i++) {
            for(int j=0; j<3; j++) {
                int tmp = 0;
                switch (j) {
                    case ONE:
                        tmp = 1;
                        break;
                    case THREE:
                        tmp = 3;
                        break;
                    case FOUR:
                        tmp = 4;
                        break;
                }
                boolean CY_CAN_WIN = dp[i-tmp][ONE] | dp[i-tmp][THREE] | dp[i-tmp][FOUR];
                if(CY_CAN_WIN) continue;
                dp[i][j] = true;
            }
        }
    }

    public static void main (String[] args) throws Exception {
        init();
        solve();
        boolean SK_CAN_WIN = dp[N][ONE] | dp[N][THREE] | dp[N][FOUR];
        System.out.println(SK_CAN_WIN ? "SK" : "CY");
    }
}