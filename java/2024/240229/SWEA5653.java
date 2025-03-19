import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// SWEA 5653번 줄기세포배양 
// 614ms, 불필요한 부분 삭제, 최적화 시 540ms
public class SWEA5653 {

    static int N, M, K, ret; // 세로, 가로, 배양 시간
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static Cell[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(st.nextToken());
        for(int tc=1; tc<=T; tc++){
            init(br, st);

            // go(true);
            go(false);
            ret = count();

            sb.append("#").append(tc).append(" ").append(ret).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static void init(BufferedReader br, StringTokenizer st) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ret = 0;

        map = new Cell[N + K][M + K]; // 배양 용기의 최대 크기
        int input;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                input = Integer.parseInt(st.nextToken());
                if(input == 0) continue;
                map[i + K/2][j + K/2] = new Cell(i + K/2, j+ K/2, input); // 배양 용기 중앙에 위치
            }
        }

        // Debug
        // for(Cell[] c : map)
        //     System.out.println(Arrays.toString(c));
    }

    // 시뮬레이션 시작
    private static void go(boolean debug) {

        Queue<Cell> q;
        for(int t=0; t<K; t++){
            q = new ArrayDeque<>();
            // 배양 용기를 순회하면서
            // 살아있거나 비활성화 상태인 모든 세포들에 대하여
            for(int y=0, endY=N+K; y<endY; y++){ 
                for(int x=0, endX=M+K; x<endX; x++){
                    if(map[y][x] == null) continue;
                    if(map[y][x].state == 2) continue;
                    // 중요!!! 여기서 시간을 감소시켜야 하는 이유
                    // while문에서 time--하면 아래에 map[ny][nx].time == map[ny][nx].X 와 충돌
                    // 자신보다 순번이 늦은 경우 time이 갱신되지 않아서 이전에 생성된 세포가 없어지고 더 큰 X를 지닌 세포가 새로 생길 수 있음
                    map[y][x].time--;   
                    q.offer(map[y][x]); // 큐에 넣기
                }
            }

            Cell cur; 
            while(!q.isEmpty()){
                cur = q.poll();

                // 만약에 활성 상태다? 번식
                if(cur.state == 1 && cur.time == cur.X - 1){
                    // 4방위 탐색
                    int ny, nx;
                    for(int i=0; i<4; i++){
                        ny = cur.yy + dy[i];
                        nx = cur.xx + dx[i];
                        if(ny<0||nx<0||ny>=N+K||nx>=M+K) continue;
                        // 1. null이면 바로 번식
                        // 2. 죽은 세포면 번식 X
                        // 3. 활성 세포면 번식 X
                        // 4. 비활성 세포면 ...
                            // 4-1. X와 time이 일치하면 (즉 이번에 새로 생긴 세포면) X가 더 큰쪽의 세포를 남김
                            // 4-2. X와 time이 다르면 번식 X
                        if(map[ny][nx]==null) map[ny][nx] = new Cell(ny, nx, cur.X);
                        else if(map[ny][nx].state == 0 && map[ny][nx].time == map[ny][nx].X) {
                            if(cur.X > map[ny][nx].X) map[ny][nx] = new Cell(ny, nx, cur.X);
                        }
                    }
                }
                // 상태 변경. 만약에 time == 0이다? 그러면 state++,time = X
                if(cur.time == 0){
                    cur.state++;
                    cur.time = cur.X;
                }
            } 

            // Debug
            if(debug){
                System.out.println("time : " + (t+1));
                for(Cell[] arr : map){
                    for(Cell c : arr){
                        System.out.print((c==null) ? ". " : c);
                    }
                    System.out.println();
                }
            }
        }
    }

    // 비활성, 활성 상태의 세포 수 카운팅
    private static int count() {
        int cnt = 0;
        for(int y=0, endY=N+K; y<endY; y++){ 
            for(int x=0, endX=M+K; x<endX; x++){
                if(map[y][x] == null) continue;
                if(map[y][x].state == 2) continue;
                cnt++;
            }
        }
        return cnt;
    }

    static class Cell{
        int yy, xx; //좌표
        int X; // 생명력 수치
        int state; // 비활성:0, 활성:1, 사망:2;
        int time; // 현 상태를 유지할 수 있는 남은 시간 

        Cell(int yy, int xx, int X){
            this.yy = yy;
            this.xx = xx;
            this.X = X;
            this.state = 0;
            this.time = X;
        }

        @Override
        public String toString(){
            return String.valueOf(X) + " ";
        }
    }
}