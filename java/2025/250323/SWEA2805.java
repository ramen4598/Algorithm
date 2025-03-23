import java.io.*;
import java.util.StringTokenizer;
// import java.util.Arrays;

class SWEA2805 {

    static int T, N, ret;
    static int[][] map;

    private static void init(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        ret = 0;

        for(int i=0; i<N; i++){
            char[] c = br.readLine().trim().toCharArray();
            for(int j=0; j<N; j++){
                map[i][j] = c[j] - '0';
            }
        }

        // for(int[] arr : map) System.out.println(Arrays.toString(arr));
    }

    private static void solve() {
        int half = N/2;
        int offset = 999;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i<half){
                    offset = i;
                }
                if(i>half){
                    offset = N - i - 1;
                }
                if(i==half){
                    offset = half;
                }

                if((half - offset > j) || (half + offset) < j) 
                    continue;
                ret += map[i][j];
            }
            // System.out.println(ret);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        T = Integer.parseInt(st.nextToken());
        for(int tc=1; tc<=T; tc++) {
            init(br);
            solve();
            sb.append("#").append(tc).append(" ").append(ret).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}