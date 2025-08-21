// 순열
// next_permutation
// nPn일 경우
// 시간복잡도 : O(n!) (재귀 호출에 의해 중복된 계산 없음)

/*
5
3 5 4 1 9
*/

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Permutation3 {

    static int N;
    static int[] input;

    // 왼->오 오름차순을 오->왼 오름차순으로 바꾸는 과정
    private static boolean next_Permutation(int[] p) {
        final int last = p.length - 1;

        // 1. 피벗 찾기
        // 오른쪽에서 왼쪽으로 이동하며, 왼쪽(i-1)이 오른쪽(i)보다 작아지는 지점을 찾음.
        // 오->왼 오름차순이 깨지는 지점 찾자
        int i = last;
        while(i>0 && p[i-1] >= p[i]) i--;

        if(i==0)  return false; // 오->왼 오름차순 종료

        // 2. 교환
        // 피벗(i-1)보다 오른쪽에 위치하면서 크지만 걔중엔 가장 작은 값을 찾아서 교환.
        // 오->왼 오름차순이 깨지지 않는 선에서 피벗(i-1)과 교환.
        int j = last;
        while(p[i-1] >= p[j]) --j;
        swap(p, i-1, j);

        // 3. 정렬
        // 피벗(i-1)의 오른쪽 부분을 오름차순으로 정렬한다.
        // 오->왼 오름차순을 부순다.
        int k = last;
        while(i<k) swap(p, i++, k--);
        
        return true;
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) throws IOException {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();
        
        // input
        N = Integer.parseInt(st.nextToken());
        input = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(input);

        do{
            sb.append(Arrays.toString(input)).append("\n");
        }while(next_Permutation(input));

        System.out.println(sb);
        br.close();
    }
}
