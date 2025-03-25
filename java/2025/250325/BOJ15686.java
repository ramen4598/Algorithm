import java.io.*;
import java.util.StringTokenizer;
// import java.util.Arrays;

public class BOJ15686 {

    static int N, M, min, h_cnt, c_cnt;
    static Pos[] homes, chickens, selected;

    // 집 또는 치킨집
    private static class Pos {
        int y, x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        h_cnt = 0;
        c_cnt = 0;

        homes = new Pos[2 * N];
        chickens = new Pos[13];

        int tmp;
        for(int y=1; y<=N; y++){
            st = new StringTokenizer(br.readLine());
            for(int x=1; x<=N; x++){
                tmp = Integer.parseInt(st.nextToken());
                if(tmp == 0) continue;
                if(tmp == 1) {
                    homes[h_cnt] = new Pos(y, x);
                    h_cnt++;
                }
                if(tmp == 2) {
                    chickens[c_cnt] = new Pos(y, x);
                    c_cnt++;
                }
            }
        }
        // System.out.println("h_cnt : " + h_cnt + "\n");
        // System.out.println("c_cnt : " + c_cnt + "\n");
    }

    // 치킨집 조합을 구하는 재귀함수
    private static void solve(int size, int depth, int start){
        if(depth == size){
            int sum = getDistance();
            min = Integer.min(min, sum);
            return;
        }
        for(int i=start; i<c_cnt; i++){
            selected[depth] = chickens[i];
            solve(size, depth + 1, i + 1);
        }
    }

    // 치킨집 조합의 전체 치킨거리 계산
    private static int getDistance() {
        int tmp, dis, sum = 0;
        Pos home;
        for(int i=0; i<h_cnt; i++){
            tmp = 0;
            dis = 999;
            home = homes[i];
            for(Pos ch : selected) {
                tmp = Math.abs(home.y - ch.y) + Math.abs(home.x - ch.x);
                dis = Integer.min(dis, tmp);
            }
            sum += dis;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        init();
        for(int size=1; size<=M; size++){
            selected = new Pos[size];
            solve(size, 0, 0);
        }
        System.out.println(min);
    }
}
