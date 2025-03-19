import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2805 {
    static int n;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
       

        int T = Integer.parseInt(st.nextToken());       
        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            map = new int[n][n];

            // save data
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                String input = st.nextToken();
                for(int j=0; j<n; j++){
                    map[i][j] = input.charAt(j) - '0';
                }
            }

            // sum
            int sum=0;
            int idx = 1;
            int half = n/2;
            for(int i=0, start=half, end=half; i<n; i++, start-=idx, end+=idx){
                for(int j=start; j<=end; j++){
                    sum+=map[i][j];
                }
                if(i==half) idx = -1;
            }
            System.out.printf("#%d %d%n", tc, sum);
        }
        br.close();
    }   
}
