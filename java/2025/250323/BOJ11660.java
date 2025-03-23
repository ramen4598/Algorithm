import java.io.*;
import java.util.StringTokenizer;
// import java.util.Arrays;

public class BOJ11660 {

    private static int N, M;
    private static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 누적합
        arr = new int[N+1][N+1];
        for(int x = 1; x<=N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 1; y<=N; y++){
                arr[x][y] = arr[x][y-1] + Integer.parseInt(st.nextToken());
            }
        }
        // for(int[] i : arr) System.out.println(Arrays.toString(i));

        // 계산
        for (int i = 0, sum = 0, x1, y1, x2, y2; i<M; i++){
            st = new StringTokenizer(br.readLine());
            sum = 0;
            x1 = Integer.parseInt(st.nextToken());  
            y1 = Integer.parseInt(st.nextToken());  
            x2 = Integer.parseInt(st.nextToken());  
            y2 = Integer.parseInt(st.nextToken());  

            for (int xx=x1; xx<=x2; xx++) {
                sum += arr[xx][y2] - arr[xx][y1 - 1];
            }

            sb.append(sum).append("\n");
        }

        // // 출력
        System.out.println(sb);
        br.close();
    }
}
