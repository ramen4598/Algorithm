import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

class BOJ2479 {

    static int ret, A, B, C;
    static int[] time;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        System.out.println(ret);
    }

    private static void init() throws IOException {

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        time = new int[101]; // 0 ~ 100

        for(int i=0, start = 0, end = 0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            for(int j=start; j<end; j++){
                time[j]++;
            }
        }
        // System.out.println(Arrays.toString(time));
    }

    private static void solve(){
        for (int i : time) {
            switch (i) {
                case 0:
                    continue;
                case 1:
                    ret += A;
                    continue;
                case 2:
                    ret += 2 * B;
                    continue;
                case 3:
                    ret += 3 * C;
                    continue;
            }
        }
    }
}