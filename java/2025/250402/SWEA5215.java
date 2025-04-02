import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class SWEA5215 {

    static int N, L, ret;
    static int[] tastes, cals;
    static int[][] dp;
    
    private static void init(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        ret = 0;
        
        // 재료  초기화
        tastes = new int[N+1];
        cals = new int[N+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            tastes[i] = Integer.parseInt(st.nextToken());
            cals[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N+1][L+1];
    }

    private static void solve() {
        for(int i=1; i<=N; i++) { // 재료 선택
            for(int j=1; j<=L; j++) { // 칼로리 제한 선택
                int tmp = dp[i-1][j];
                if(j - cals[i] > 0){
                    dp[i][j] = Math.max(tmp, dp[i-1][j-cals[i]] + tastes[i]);
                }else{
                    dp[i][j] = tmp;
                }
            }
        }
        ret = dp[N][L];
    }

    public static void main(String[] args) throws Exception {
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