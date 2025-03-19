import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1873 {

    static int H, W, N;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[][] map;
    static char[] dirChar = {'^', '>', 'v', '<'};
    static Tank tank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(st.nextToken());

        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            char[] input;

            // map, tank 정보 입력
            for(int y=0; y<H; y++){
                input = br.readLine().trim().toCharArray();
                for(int x=0; x<W; x++){
                    map[y][x] = input[x];
                    if(input[x] == '^' || input[x] == 'v' || input[x] == '>' || input[x] == '<'){
                        tank = new Tank(y, x, input[x]);
                    }
                }
            }

            // 명령어 처리
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            input = br.readLine().trim().toCharArray();
            for(int i=0; i<N; i++){
                solve(input[i]);
            }

            // 출력
            sb.append("#").append(tc).append(" ");
            for(int y=0; y<H; y++){
                for(int x=0; x<W; x++){
                    sb.append(map[y][x]);
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    } 

    private static void solve(char oper){
        switch (oper) {
            case 'U':
                tank.move(0);
                break;
            case 'D':
                tank.move(2);
                break;
            case 'L':
                tank.move(3);
                break;
            case 'R':
                tank.move(1);
                break;
            case 'S':
                tank.shoot();
                break;
        }
    }


    static class Tank {
        int y, x, dir;
        Tank(int y, int x, char dir){
            this.y = y;
            this.x = x;
            if(dir=='^') this.dir = 0;
            else if(dir=='v') this.dir = 2;
            else if(dir=='>') this.dir = 1;
            else if(dir=='<') this.dir = 3;
        }

        public void move(int dir){
            //turn
            this.dir = dir;
            map[y][x] = dirChar[this.dir];

            int ny = this.y + dy[dir];
            int nx = this.x + dx[dir];
            // 장외
            boolean underflow = ny<0 || nx<0;
            boolean overflow = ny >= H || nx >= W;
            if(underflow || overflow) return;
            // 평지
            if(map[ny][nx] != '.') return;
            map[y][x] = '.';
            map[ny][nx] = dirChar[this.dir];
            this.y = ny;
            this.x = nx;
        }

        public void shoot(){
            int ny = this.y;
            int nx = this.x;
            while(true){
                ny += dy[dir];
                nx += dx[dir];
                // 장외
                boolean underflow = ny<0 || nx<0;
                boolean overflow = ny >= H || nx >= W;
                if(underflow || overflow) return;
                // 철벽
                if(map[ny][nx]=='#') return;
                // 벽돌
                if(map[ny][nx]=='*') {
                    map[ny][nx] = '.';
                    return;
                }
            }
        }

    }
}
