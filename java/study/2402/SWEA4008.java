import java.io.*;
import java.util.StringTokenizer;

/**
 * SWEA4008
 */
public class SWEA4008 {

    static int N, max, min;
    static int[] nums, oper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(st.nextToken());

        for(int tc=1; tc<=T; tc++){
            init(br, st);
            solve(0, nums[0]);
            sb.append("#").append(tc).append(" ").append(max-min).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static void init(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        nums = new int[N];
        oper = new int[4];
        // 연산자 저장
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            oper[i] = Integer.parseInt(st.nextToken());
        }
        // 숫자 저장
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }

    private static void solve(int depth, int value){
        if(depth == N-1){
            min = Math.min(min, value);
            max = Math.max(max, value);
            //System.out.println(min+", "+max);
            return;
        }

        // 연산자의 중복이 가능한 순열을 만든다.
        for(int i=0; i<4; i++){
            if(oper[i]<1) continue;
            oper[i]--;
            int tmp = value; 
            switch (i) {
                case 0:
                    tmp += nums[depth+1];
                    break;
                case 1:
                    tmp -= nums[depth+1];
                    break;
                case 2:
                    tmp *= nums[depth+1];
                    break;
                case 3:
                    tmp /= nums[depth+1];
                    break;
            }
            solve(depth+1, tmp);
            oper[i]++;
        }

    }
}