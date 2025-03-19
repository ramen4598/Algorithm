import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ12891
 */
public class BOJ12891 {

    static int ret;
    static int[] cond, cnt; // 조건, 문자 카운팅
    static final int A=0, C=1, G=2, T=3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ret = 0;
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        // 문자열
        st = new StringTokenizer(br.readLine());
        char[] arr = st.nextToken().toCharArray();

        // 부분문자열 조건
        st = new StringTokenizer(br.readLine());
        cond = new int[4]; // condition
        for(int i=0; i<4; i++){
            cond[i] = Integer.parseInt(st.nextToken());
        }

        //슬라이딩 윈도우 생성
        cnt = new int[4];
        for(int i=0; i<P; i++){
            switch (arr[i]) {
                case 'A':
                    cnt[A]++;       
                    break;
                case 'C':
                    cnt[C]++;
                    break;
                case 'G':
                    cnt[G]++;
                    break;
                case 'T':
                    cnt[T]++;
                    break;
            }
        }
        check();

        //윈도우 이동
        int limit = S-P+1;
        for(int i=1; i<limit; i++){
            char out = arr[i-1]; // 나간것
            switch (out) {
                case 'A':
                    cnt[A]--;       
                    break;
                case 'C':
                    cnt[C]--;
                    break;
                case 'G':
                    cnt[G]--;
                    break;
                case 'T':
                    cnt[T]--;
                    break;
            }
            char in =  arr[i+P-1]; // 들어온것
            switch (in) {
                case 'A':
                    cnt[A]++;       
                    break;
                case 'C':
                    cnt[C]++;
                    break;
                case 'G':
                    cnt[G]++;
                    break;
                case 'T':
                    cnt[T]++;
                    break;
            }
            check();
        }

        System.out.println(ret);
    }

    public static void check(){
        // 조건을 만족하는지 확인
        // System.out.println("cond : " + Arrays.toString(cond));
        // System.out.println("cnt : " + Arrays.toString(cnt));
        for(int i=0; i<4; i++){
            if(cnt[i] < cond[i]) return;
        }
        ret++;
    }
}