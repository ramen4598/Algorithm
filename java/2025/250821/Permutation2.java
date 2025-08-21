// 순열
// 재귀함수
// 가장 일반적인 구현 방법.
// 가지치기를 통해서 시간을 명확하게 아낄 수 있는 순열 구현.
// 시간 복잡도 : O(n!)

/*
3
7 5
1 2 3 4 5 6 7
5 3
1 2 3 4 5 6 7
3 2
1 2 3
*/

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Permutation2 {

    static int N, R;
    static int[] map, ret;
    static boolean[] visited;

    private static void perm(int idx) {
        // 가지치기 조건 추가
        // 기저조건
        if(idx == R) {
            System.out.println(Arrays.toString(ret));
            return;
        }

        for(int i=0; i<N; i++){
            if(visited[i]) continue;
            ret[idx] = map[i]; 
            visited[i] = true;
            perm(idx+1);
            visited[i] = false;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for(int tc=1; tc<=TC; tc++) {

            // init
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            map = new int[N];
            ret = new int[R];
            visited = new boolean[N];

            // input
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                map[i] = Integer.parseInt(st.nextToken());
            }

            // make permutation
            perm(0);
        }
        br.close();
    }
    
}
