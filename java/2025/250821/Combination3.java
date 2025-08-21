// 조합
// next_permutation
// 평균적으로 좋은 성능
// 시간복잡도 : O(2^N)

/*
5 3
1 2 3 4 5
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Combination3 {

    static int N, R;
    static int[] input, P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        input = new int[N];
        P = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        // 뒤에서부터 R개만큼 0이 아닌 숫자로 초기화한다.
        for(int i=0; i<R; i++){
            P[N-1-i] = 1;
        }

        comb(sb);
        System.out.println(sb);
        br.close();
    }

    private static void comb(StringBuffer sb) {
        do{
            for(int i=0; i<N; i++){
                if(P[i]==0) continue;
                sb.append(input[i]).append(" ");
            }
            sb.append("\n");
        }while(next_permutation(P));
    }

    private static boolean next_permutation(int[] P) {
        final int last = P.length - 1;

        // 1. 피벗 찾기
        // 오른쪽에서 왼쪽으로 이동하며, 왼쪽(i-1)이 오른쪽(i)보다 작아지는 지점을 찾음.
        // 오->왼 오름차순이 깨지는 지점 찾자
        int i = last;
        while(i>0 && P[i-1] >= P[i]) i--;

        if(i==0)  return false; // 오->왼 오름차순 종료

        // 2. 교환
        // 피벗(i-1)보다 오른쪽에 위치하면서 크지만 걔중엔 가장 작은 값을 찾아서 교환.
        // 오->왼 오름차순이 깨지지 않는 선에서 피벗(i-1)과 교환.
        int j = last;
        while(P[i-1] >= P[j]) j--;
        swap(P, i-1, j);

        // 3. 정렬
        // 피벗(i-1)의 오른쪽 부분을 오름차순으로 정렬한다.
        // 오->왼 오름차순을 부순다.
        int k = last;
        while(i < k) swap(P, i++, k--);

        return true;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
