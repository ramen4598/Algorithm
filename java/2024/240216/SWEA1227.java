import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class SWEA1227 {
    static int[] start;
    static int[][] map, vis;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        
        for(int tc=1; tc<=10; tc++){
            // map 초기화
            br.readLine(); // test case 필요 x
            char[] input;
            map = new int[100][100];
            for(int y=0; y<100; y++){
                input = br.readLine().trim().toCharArray();
                for(int x=0; x<100; x++){
                    map[y][x] = input[x]-'0';
                    if(map[y][x] == 2) start = new int[]{y, x}; // 시작점
                }
            }

            sb.append("#").append(tc).append(" ").append(bfs()).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static int bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[100][100];
        int[] dy={-1, 0, 1, 0};
        int[] dx={0, 1, 0, -1};

        q.offer(start);
        vis[start[0]][start[1]] = true;

        int[] cur;
        while(!q.isEmpty()){
            cur = q.poll();

            // 도착 가능함.
            if(map[cur[0]][cur[1]]==3) return 1;

            // 맵 탐색
            int ny, nx;
            for(int d=0; d<4; d++){
                ny = cur[0] + dy[d];
                nx = cur[1] + dx[d];

                boolean underflow = ny<0 || nx<0;
                boolean overflow = ny>99 || nx>99;
                if(underflow || overflow) continue;

                if(vis[ny][nx]) continue;
                if(map[ny][nx] == 1) continue; // 벽
                q.offer(new int[]{ny, nx});
                vis[ny][nx]=true;
            }
        }
        // 도착 불가능함.
        return 0;
    }
}
