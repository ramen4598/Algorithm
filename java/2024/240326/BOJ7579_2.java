import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 앱
public class BOJ7579_2 { // 128ms

    static int N, M, ret, cSum; // 앱의 수, 필요한 메모리 크기, 반환값, 비용의 총합
    static int[] m, c; // 앱의 메모리 사용량, 비활성화 비용
    static int[][] dp; // 확보한 메모리의 최대 크기를 저장
    public static void main(String[] args) throws Exception {
        init();
        solve();
        System.out.println(ret);
    } 

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ret = Integer.MAX_VALUE;

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        m = new int[N+1];
        c = new int[N+1];
        for(int i=1; i<=N; i++){
            m[i] = Integer.parseInt(st1.nextToken());
            c[i] = Integer.parseInt(st2.nextToken());
            cSum += c[i];
        }
        dp = new int[N+1][cSum + 1]; // 앱, 비용
    }

    static void solve(){
        for(int i=1; i<=N; i++){
            for(int j=0; j<=cSum; j++){ // 비활성화 비용이 0일 때도 포함
                if(j>= c[i]){ // i번째 앱 비활성화
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-c[i]] + m[i]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
                if(dp[i][j] >= M) // 필요한 메모리 이상 확보
                    ret = Math.min(ret, j); // 최저 비용을 저장
            }
        }
    }

}
