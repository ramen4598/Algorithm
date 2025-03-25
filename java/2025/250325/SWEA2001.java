import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// import java.util.Arrays;

public class SWEA2001 {

    static int N, M, ret;
    static int[][] map;
    
    private static void init(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ret = 0;

        // 누적합
        map = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = map[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void solve() {
        int sum = 0;
        int end = N - M + 2;
        for(int i=1; i<end; i++){
            for(int j=1; j<end; j++){
                sum = 0;
                // 범위 내 벌레 죽이기
                for(int h=0; h<M; h++){
                    sum += map[i+h][j+M-1] - map[i+h][j-1];
                }
                ret = Integer.max(ret, sum);
            }
        }
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
