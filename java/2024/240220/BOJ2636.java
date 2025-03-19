import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2636 {

    static int H, W, time, cnt; // 가로, 세로, 시간, 남은 치즈
    static int[][] map;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];

        for(int y=0; y<H; y++){
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<W; x++){
                map[y][x] = Integer.parseInt(st.nextToken());
                if(map[y][x] == 1) cnt++;
            }
        }

        int melt;
        while(cnt > 0){
            time++;
            melt = dfs(0, 0, new boolean[H][W]); // 녹은 치즈의 수
            cnt -= melt;
            if(cnt == 0){
                System.out.println(time);
                System.out.println(melt);
                break;
            }
        }
        br.close();
    } 

    static int dfs(int y, int x, boolean[][] vis){
        int melt = 0;
        vis[y][x] = true;

        int ny, nx;
        for(int d=0; d<4; d++){
            ny = y + dy[d];
            nx = x + dx[d];

            boolean under = ny<0 || nx<0;
            boolean over = ny>=H || nx>=W;
            if(under||over) continue;

            if(vis[ny][nx]) continue;
            if(map[ny][nx]==1){
                vis[ny][nx] = true;
                map[ny][nx] = 0;
                melt++; // 공기에 접촉된 치즈의 수
                continue;
            }
            melt += dfs(ny, nx, vis);
        }

        return melt;
    }
}
