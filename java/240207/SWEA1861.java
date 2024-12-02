import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA1861
 */
public class SWEA1861 {

    static int[][] map;
    static int N, num, max; // N, 방번호, 이동할 수 있는 횟수 
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(st.nextToken());

        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            num = -1;
            max = -1;
            map = new int[N+1][N+1];

            // 입력
            for(int y=1; y<=N; y++){
                st = new StringTokenizer(br.readLine());
                for(int x=1; x<=N; x++){
                    map[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            // 탐색
            for(int y=1; y<=N; y++){
                for(int x=1; x<=N; x++){
                    boolean flag = false;
                    // 가지치기 : 더 상위의 길에 포함
                    for(int i=0; i<4; i++){
                        int ny = y+dy[i];
                        int nx = x+dx[i];
                        boolean underflow = ny <= 0 || nx <= 0;
                        boolean overflow = ny > N || nx > N;
                        if(underflow||overflow) continue;
                        if(map[y][x] == map[ny][nx] + 1){
                            flag = true;
                            break;
                        }
                    }
                    if(flag)continue;
                    int cnt  = dfs(y, x);
                    if((cnt == max)&&(map[y][x] < num)){ // 같으면 작은 숫자
                        num = map[y][x];
                    }
                    if(cnt > max){ // 크면 갱신
                        num = map[y][x];
                        max = cnt;
                    }
                }
            }

            // 출력
            sb.append("#").append(tc).append(" ").append(num).append(" ").append(max).append("\n");
        }

        System.out.println(sb.toString());
        br.close();       
    }
    static int dfs(int y, int x){
        int cnt = 1;
        for(int i=0; i<4; i++){
            int ny = y+dy[i];
            int nx = x+dx[i];
            boolean underflow = ny <= 0 || nx <= 0;
            boolean overflow = ny > N || nx > N;
            if(underflow||overflow) continue;
            if(map[y][x] + 1 == map[ny][nx] ){ // 갈 수 있음
                cnt += dfs(ny, nx);
            }
        }
        return cnt;
    }
}