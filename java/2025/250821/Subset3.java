// 부분집합
// 바이너리 카운팅
// 낮은 공간복잡도. 선택지가 27개 이하.(2^27 = 연산 1억 = 대략 1초)
// 부분집합을 배열로 표현하기 어려운 경우
// 시간복잡도 : O(2^N)

/*
3
1 2 3
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Subset3 {

    static int N;
    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(st.nextToken());
        input = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        subset(sb);
        System.out.println(sb);
        br.close();
    }

    private static void subset(StringBuffer sb) {
        int cnt = 1<<N; // 모든 부부집합의 개수
        for(int i=0; i < cnt; i++){ // 모든 부부집합에 대하여
            for(int j=0; j<N; j++){ // 모든 비트에 대하여
                if((i & (1<<j)) == 0) continue;
                sb.append(input[j]).append(" ");
            } 
            sb.append("\n");
        }
    }
}