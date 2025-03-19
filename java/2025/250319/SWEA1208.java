import java.io.*;
import java.util.StringTokenizer;
// import java.util.Arrays;

public class SWEA1208 {

    static int dump, ret;
    static int[] arr;

    private static void init(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());

        ret = 0;
        dump = Integer.parseInt(st.nextToken());

        arr = new int[100];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<100; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // System.out.println(dump);
        // System.out.println(Arrays.toString(arr));
        // System.out.println("-------------");
    }

    private static void solve() {

        int min = 0, max = 0;
        for(int i = 0; i<dump; i++){

            // find min, max index
            min = 0; max = 0;
            for(int j=1; j<100; j++) {
                if(arr[j] > arr[max]) max = j;
                if(arr[j] < arr[min]) min = j;
            }

            // 평탄화 끝
            if (arr[max] - arr[min] <= 1) {
                break;
            }

            // 평탄화
            arr[max]--;
            arr[min]++;
        }

        // 마지막 평탄화 후 측정
        min = 0; max = 0;
        for(int j=1; j<100; j++) {
            if(arr[j] > arr[max]) max = j;
            if(arr[j] < arr[min]) min = j;
        }

        ret = arr[max] - arr[min];
        return;
    }

    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        for(int tc = 1; tc <= 10; tc++) {
            init(br);
            solve();
            sb.append("#").append(tc).append(" ").append(ret).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}