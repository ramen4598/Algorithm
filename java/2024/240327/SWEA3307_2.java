import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 최장 증가 부분 수열
public class SWEA3307_2 { //122ms

    static int N, ret;
    static int[] arr, lis;
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       StringBuffer sb = new StringBuffer();

       int T = Integer.parseInt(st.nextToken());
       for(int tc=1; tc<=T; tc++){
        init(br, st);
        solve();
        sb.append("#").append(tc).append(" ").append(ret).append("\n");
       }
       System.out.println(sb);
       br.close();
    }
    private static void init(BufferedReader br, StringTokenizer st) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        lis = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //debug
        //System.out.println(Arrays.toString(arr));
    }
    private static void solve() {
        int idx = 0, point;
        for(int i : arr){
           point = Arrays.binarySearch(lis, 0, idx, i); 
           if(point < 0) point = -(point + 1); // 기존에 없는 경우
           lis[point] = i;
           if(point==idx)++idx;
           // debug
           //System.out.println(Arrays.toString(lis));
        }
        ret = idx;
    }
}