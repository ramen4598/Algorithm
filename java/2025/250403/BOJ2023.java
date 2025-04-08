import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ2023 {

    static int N;
    static int[] arr;
    static StringBuffer sb;

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        sb = new StringBuffer();

        br.close();
    }

    private static void solve(int depth) {
        // System.out.println(Arrays.toString(arr));
        // 가지치기
        if (prune(depth)) {
            // System.out.println(Arrays.toString(arr));
            return;
        }
        // 기저조건
        if (depth == N) {
            sb.append(arr2int(depth)).append("\n");
            return;
        }
        // 재귀호출
        for(int i=1; i<10; i++) { 
            if ((i != 2) && (i % 2 == 0)) continue; // 2가 아닌 2의 배수 제외
            arr[depth] = i;
            solve(depth + 1);
        }
    }

    private static int arr2int(int depth) {
        int ret = 0;
        for(int i=0; i<depth; i++){
            ret = ret * 10 + arr[i];
        }
        return ret;
    }

    private static boolean prune(int depth) {
        if(depth == 0) 
            return false;

        boolean notSosu;
        int num;
        for(int i=1; i<=depth; i++) {
            num = arr2int(i);
            if (num == 1) return true; // 1은 소수 아님
            if (num == 2) continue; // 2는 소수임
            for(int j=2; j<num; j++){ // 1이 아닌 작은 수로 나누기
                notSosu = (num % j) == 0;
                if(notSosu) return true; // 가지치기
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        init();
        solve(0);
        System.out.println(sb);
    }
}