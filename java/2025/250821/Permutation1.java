// 순열
// 반복문
// nPr에서 r이 고정되어 있고, 일반적으로 3중 for문을 넘지 않는 경우

/*
1
5
1 2 3 4 5
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Permutation1 {

    static int N, R = 3;
    static int[] map, ret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());

        for(int tc=1; tc <= TC; tc++){

            // init
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            map = new int[N];
            ret = new int[R];

            //input
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                map[i] = Integer.parseInt(st.nextToken());
            }

            // make permutation
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    for(int k=0; k<N; k++) {
                        if(i != j && i != k && j != k){
                            ret[0] = map[i];
                            ret[1] = map[j];
                            ret[2] = map[k];
                            System.out.println(Arrays.toString(ret));
                        }
                    }
                }
            }
        }
    }
}