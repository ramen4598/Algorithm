import java.io.*;
import java.util.StringTokenizer;

public class SWEA3307_2 {

    public static int solve(int n, int[] arr){
        int[] lis = new int[n];

        for(int i=0; i<n; i++){
            lis[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i] && lis[j] >= lis[i]){
                    lis[i] = lis[j] + 1;
                }
            }
        }
        int max = 0;
        for(int num : lis){
            max = Math.max(max, num);
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());               
            }
            int ret = solve(n, arr);
            System.out.println("#" + tc + " " + ret);
        }
        br.close();
    }
}
