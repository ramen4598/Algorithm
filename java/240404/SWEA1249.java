import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 보급로
public class SWEA1249 { //188 ms
    static final int INF = 99999;
    static int N, ret;
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(st.nextToken());
        for(int tc=1; tc<=T; tc++){
            init(br, st);
            solve();
            sb.append("#").append(tc).append(" ").append(ret).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
    private static void init(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        ret = 0;

        char[] input;
        for(int i=0; i<N; i++){
            input = br.readLine().toCharArray();
            for(int j=0; j<N; j++){
                map[i][j] = input[j] - '0';
            }
        }
        // debug
        // for(int[] arr : map) System.out.println(Arrays.toString(arr)); 
    } 
    private static void solve() {
        boolean[][] vis = new boolean[N][N];
        PriorityQueue<Point> pq = new PriorityQueue<>();

        int[][] d = new int[N][N];
        for(int[] arr : d)
            Arrays.fill(arr, INF);
        d[0][0] = 0;
        pq.offer(new Point(0, 0, d[0][0]));
        Point cur;
        while(!pq.isEmpty()){
            cur = pq.poll();

            if(vis[cur.y][cur.x]) continue;
            if(cur.y==N-1 && cur.x==N-1) break;
            vis[cur.y][cur.x] = true;

            int ny, nx;
            for(int dir=0; dir<4; dir++){
                ny = cur.y + dy[dir];
                nx = cur.x + dx[dir];
                if(ny<0 || nx <0 || ny>=N || nx>=N) continue;
                if(vis[ny][nx]) continue;
                if(d[ny][nx] > d[cur.y][cur.x] + map[cur.y][cur.x]){
                    d[ny][nx] = d[cur.y][cur.x] + map[cur.y][cur.x];
                    pq.offer(new Point(ny, nx, d[ny][nx]));
                }
            }
        }
        ret = d[N-1][N-1];
    }

    static class Point implements Comparable<Point> {
        int y, x, w;

        Point(int y, int x, int w){
            this.y = y;
            this.x = x;
            this.w = w;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.w, o.w);
        }

        @Override
        public String toString() {
            return "x:" + x + " y:" + y + " w:" + w;
        }

    }
}
