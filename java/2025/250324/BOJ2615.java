import java.io.*;
import java.util.StringTokenizer;
// import java.util.Arrays;

public class BOJ2615 {

    static char winner;
    static int[] pos; // 가장 좌측바둑돌 좌표
    static char[][] map;
    static Dir[] dirs;

    // 탐색 방향
    private static class Dir {
        int dy, dx;
        boolean isSouthWest; // 남서 방향 시 가장 왼쪽 바둑돌 위치 계산법이 다름

        Dir(int dy, int dx, boolean isSouthWest){
            this.dy = dy;
            this.dx = dx;
            this.isSouthWest = isSouthWest;
        }
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        winner = '0';
        pos = new int[2]; // y, x

        // 바둑판 초기화 
        map = new char[20][20];
        for(int i=1; i<20; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<20; j++){
                map[i][j] = st.nextToken().charAt(0);
            }
        }
        // for(char[] c : map) System.out.println(Arrays.toString(c));

        // 탐색 방향 초기화
        dirs = new Dir[4];
        // 방향 4 : 동
        dirs[0] = new Dir(0, 1, false);
        // 방향 5 : 동남
        dirs[1] = new Dir(1, 1, false);
        // 방향 6 : 남
        dirs[2] = new Dir(1, 0, false);
        // 방향 7 : 남서 - 예외 : 가장 왼쪽돌 위치 조심
        dirs[3] = new Dir(1, -1, true);

        br.close();
    }

    private static void solve() {
        // 좌상단부터 탐색
        search : for (int y=1; y<20; y++){
            for (int x=1; x<20; x++){
                // 탐색 종료 skip
                if (winner != '0') break search;

                // 빈 좌표 skip
                char cur = map[y][x];
                if (cur == '0') continue;

                int by, bx; // 동일한 방향으로의 중복
                boolean under, over; // 장외
                for (Dir dir : dirs) {
                    // 동일한 방향으로의 중복 skip
                    // 장외 skip
                    by = (y - dir.dy);
                    bx = (x - dir.dx);
                    under = by < 1 || bx < 1;
                    over = by > 19 || bx > 19;
                    if(!under && !over && map[by][bx] == cur)
                        continue;

                    // 탐색
                    dir(y, x, dir);
                }
            }
        }
    }

    private static void dir(int y, int x, Dir dir) {
        char cur = map[y][x];
        int cnt = 0; // 연속된 바둑알의 수
        int ny = y, nx = x;
        boolean under, over;
        do{
            cnt++;
            ny += dir.dy;
            nx += dir.dx;
            // 장외 skip
            under = ny < 1 || nx < 1;
            over = ny > 19 || nx > 19;
            if(under || over) break;
            // System.out.println("cur : " + cur + " map[ny][nx] : " + map[ny][nx] + "\n");
        }while(cur == map[ny][nx]);

        // 끝
        if (cnt == 5) {
            // 승자
            winner = cur;
            // 바둑돌 위치
            pos[0] = y;
            pos[1] = x;
            // 남서 방향일 경우 좌측 바둑돌 위치
            if(dir.isSouthWest){
                pos[0] = y + 4 * dir.dy;
                pos[1] = x + 4 * dir.dx;
            }
        }
        // System.out.println("-----------------------");
        // System.out.println("y: " + y + " x:" + x + "\n");
        // System.out.println("dy : " + dir.dy + " dx : " + dir.dx + "\n");
        // System.out.println("pos[0] : " + pos[0] + " pos[1] : " + pos[1] + "\n");
        // System.out.println("cnt : " + cnt + "\n");
        // System.out.println("-----------------------");
    }

    public static void main(String[] args) throws Exception {

        init();
        solve();

        // 출력
        System.out.println(winner);
        if(winner != '0')
            System.out.println(pos[0] + " " + pos[1]);
    }
}