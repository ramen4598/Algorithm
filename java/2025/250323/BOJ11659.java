import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ11659 {

    private static int N, M;
    private static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 누적합
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<=N; i++){
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }
        // System.out.println(Arrays.toString(arr));

        // 계산
        for (int i = 0, sum, start, end; i<M; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());  
            end = Integer.parseInt(st.nextToken());  
            sum = arr[end] - arr[start -1];
            sb.append(sum).append("\n");
        }

        // 출력
        System.out.println(sb);
        br.close();
    }
}
