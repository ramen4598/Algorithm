import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1987 {

    static int R, C;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for(int i=0; i<R; i++){
            map[i]= br.readLine().trim().toCharArray();
        }

        System.out.println(dfs(0, 0, 0));
        br.close();
    }

    private static int dfs(int y, int x, int vis){
        vis |= 1 << (map[y][x] - 'A');

        int ny, nx, max = 0;
        for(int i=0; i<4; i++){
            ny = y + dy[i];
            nx = x + dx[i];

            boolean under = ny<0 || nx<0;
            boolean over = ny>=R || nx>=C;
            if(under || over) continue;

            int mask = 1 << (map[ny][nx] - 'A');
            if((vis & mask) != 0) continue; // 이미 방문한 알파벳
            max = Math.max(max, dfs(ny, nx, vis | mask)); // 앞으로 갈 수 있는 최대 칸의 수
        }

        return 1 + max; //지금 칸 + 앞으로 갈 수 있는 칸의 최대 
    }
}
