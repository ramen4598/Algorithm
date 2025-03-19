import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ17281 {

    static int N, cur, ret;
    static int[] map; // 선수들의 이닝에서 얻는 결과, 123루
    static int[][] act;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());       

        N = Integer.parseInt(st.nextToken());
        act = new int[N][10]; // 1 ~ 9번 선수의 행동 결과

        //모든 이닝 정보 저장
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());       
            for(int j=1; j<10; j++){
                act[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //선수들 순서를 만들어
        dfs(0, new boolean[10], new int[9]);

        System.out.println(ret);
        br.close();
    }

    private static void dfs(int depth, boolean[] vis, int[] perm){
        if(depth == 9){
            //게임을 진행해
            int score = 0;
            cur = 0;
            //점수를 구해
            for(int i=0; i<N; i++){
                score += startInning(i, perm);
            }
            ret = Math.max(ret, score); // 모든 경우의 수에서 최고 점수를 찾는다.
            return;
        }

        if(depth == 3){ // 4번째 타자를 
            perm[3] = 1; // 1번 선수로 고정
            dfs(depth+1, vis, perm);
            return;
        }

        for(int i=2; i<10; i++){ // 2 ~ 9번 선수
            if(vis[i]) continue;
            vis[i] = true;
            perm[depth] = i;
            dfs(depth+1, vis, perm);
            vis[i] = false;
        }
    }

    // 해당 이닝의 최고 점수 구하기
    static int startInning(int inning, int[] perm){
        map = new int[4]; // 1 ~ 3루
        int sum = 0; // 이닝 점수
        int out = 0;
        while(true){
            if(act[inning][perm[cur]]==0) {
                cur = (cur+1)%9;
                out++;
                if(out==3){ // 3아웃
                    break;
                } 
                continue;
            }
            sum += go(act[inning][perm[cur]]);
            cur = (cur+1)%9;
        }
        return sum;
    }

    private static int go(int idx) {
        int res = 0;
        switch (idx) {
            case 1: // 안타
                if(map[3]==1) res++; // 3루의 선수의 수를 점수에 더한다.
                map[3] = map[2]; // 2루 -> 3루
                map[2] = map[1]; // 1루 -> 2루
                map[1] = 1;
                break;
            case 2: // 2루타
                if(map[3]==1)res++;// 2, 3루의 선수의 수를 점수에 더한다.
                if(map[2]==1)res++;
                map[3] = map[1];// 1루에 타자가 있었다면 3루를 채운다.
                map[2] = 1;// 2루에 1명을 추가 
                map[1] = 0;// 1루를 비운다.
                break;
            case 3: // 3루타
                // 1, 2, 3루의 선수의 수를 점수에 더한다.
                if(map[3]==1)res++;
                if(map[2]==1)res++;
                if(map[1]==1)res++;
                // 3루에 1명 추가
                map[3] = 1;  
                // 1, 2루 모두 비운다.
                map[2] = 0;
                map[1] = 0; 
                break;
            case 4: // 홈런
                // 1, 2, 3루의 선수의 수를 점수에 더한다.
                if(map[3]==1)res++;
                if(map[2]==1)res++;
                if(map[1]==1)res++;
                res++;
                // 1, 2, 3루를 모두 비운다. 
                map[3] = 0; 
                map[2] = 0;
                map[1] = 0; 
                break;
        }
        return res;
    }

}