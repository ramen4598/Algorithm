import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// SWEA 5653번 줄기세포배양 
// PQ로 구현 -> 957ms로 더 느려짐
public class SWEA5653_2 {

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

        PriorityQueue<Cell> pq;
        for(int t=0; t<K; t++){
            pq = new PriorityQueue<>((o1, o2)-> -Integer.compare(o1.X, o2.X)); // X가 큰 것부터 정렬
            // 배양 용기를 순회하면서
            // 살아있거나 비활성화 상태인 모든 세포들에 대하여
            for(int y=0, endY=N+K; y<endY; y++){ 
                for(int x=0, endX=M+K; x<endX; x++){
                    if(map[y][x] == null) continue;
                    if(map[y][x].state == 2) continue;
                    map[y][x].time--;   
                    pq.offer(map[y][x]); // 큐에 넣기
                }
            }

            Cell cur; 
            while(!pq.isEmpty()){
                cur = pq.poll();

                // 만약에 활성 상태다? 번식
                if(cur.state == 1 && cur.time == cur.X - 1){
                    // 4방위 탐색
                    int ny, nx;
                    for(int i=0; i<4; i++){
                        ny = cur.yy + dy[i];
                        nx = cur.xx + dx[i];
                        if(ny<0||nx<0||ny>=N+K||nx>=M+K) continue;
                        // 1. null이면 바로 번식
                        if(map[ny][nx]==null) map[ny][nx] = new Cell(ny, nx, cur.X);
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