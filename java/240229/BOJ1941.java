import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class BOJ1941 {

    static int ret;
    static char[] map = new char[25];
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    public static void main(String[] args) throws Exception {
        init();

        // 7명짜리 조합 생성
        comb(0, 0, new int[7]);

        // debug
        // System.out.println(check1(new int[]{5,6,7,8,9,14,19})); // true
        // System.out.println(check2(new int[]{5,6,7,8,9,14,19})); // true
        // System.out.println(check1(new int[]{5,6,7,8,9,11,16})); // true
        // System.out.println(check2(new int[]{5,6,7,8,9,11,16})); // true
        // System.out.println(check1(new int[]{1,6,7,8,9,14,19})); // true
        // System.out.println(check2(new int[]{1,6,7,8,9,14,19})); // false
        // System.out.println(check1(new int[]{5,6,7,8,9,14,13})); // true
        // System.out.println(check2(new int[]{5,6,7,8,9,14,13})); // false

        System.out.println(ret);
    }

    public static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input;
        for(int i=0; i<5; i++){
            input = br.readLine().trim().toCharArray();
            for(int j=0; j<5; j++){
                map[i*5 + j] = input[j];
            }
        }
        br.close();
        //System.out.println(Arrays.toString(map));
    }

    private static void comb(int depth, int start, int[] vis) {
        if(depth == 7){
            // 각 조합이 조건을 통과하는지 확인
            if(check1(vis)&&check2(vis)){
                // debug
                // System.out.println("----------------------");
                // for(int i=0; i<5; i++){
                //     for(int j=0; j<5; j++){
                //         char c = '.'; 
                //         for(int n : vis){
                //             if((i*5 + j)==n) c = map[n];
                //         }
                //         System.out.print(c + " ");
                //     }
                //     System.out.println();
                // }
                ret++;
            }
            return;
        }

        for(int i=start; i<25; i++){
            vis[depth] = i;
            comb(depth+1, i+1, vis);
        }
    }

    private static boolean check1(int[] vis){
        // 7명의 자리는 서로 가로나 세로로 반드시 인접해 있어야 한다.
        // 하나의 덩어리
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] v = new boolean[25];

        q.offer(vis[0]);
        v[vis[0]] = true;

        int cur, curX, curY, cnt = 0;
        while(!q.isEmpty()){
            cur = q.poll();
            cnt++;

            curY = cur/5;
            curX = cur%5;
            //4방위 탐색
            int nx, ny, next;
            for(int d=0; d<4; d++){
                ny = curY + dy[d];
                nx = curX + dx[d];
                if(ny<0 || nx<0 || ny>=5 || nx>=5) continue;
                //vis에 포함된 숫자면서 방문한 적 없으면
                next = ny*5 + nx;
                for(int num : vis){
                    if(num!=next) continue;
                    if(v[num])continue;
                    v[num] = true;
                    //큐에 넣는다
                    q.offer(num);
                }
            }
        }
        return (cnt==7) ? true : false;
    }
    private static boolean check2(int[] vis){
        // 7명의 학생 중 ‘S’의 학생이 적어도 4명 이상은 반드시 포함되어 있어야 한다.
        int cnt = 0;
        for(int i : vis){
            if(map[i]=='S') cnt++;
        }
        return (cnt >3) ? true : false;
    }
}