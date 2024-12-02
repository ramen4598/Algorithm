import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16926 {
    
    static int[][] map;
    static int N, M, R, min;
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        min = Math.min(N, M);
        map = new int[N+1][M+1];

        for(int y=1; y<=N; y++){
            st = new StringTokenizer(br.readLine());
            for(int x=1; x<=M; x++){
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<R; i++){
            turn(0);
        }

        StringBuffer sb = new StringBuffer();
        for(int y=1; y<=N; y++){
            for(int x=1; x<=M; x++){
                sb.append(map[y][x]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
    private static void turn(int depth) {
        if(depth == min/2){
            return;
        }
        // turn north
        int tmp = map[1+depth][1+depth];
        for(int x=1+depth, y=1+depth; x<M-depth; x++){
            map[y][x]=map[y][x+1];
        }
        // turn east
        for(int x=M-depth, y=1+depth; y<N-depth; y++){
            map[y][x]=map[y+1][x];
        }
        // turn south
        for(int x=M-depth, y=N-depth; x>1+depth; x--){
            map[y][x]=map[y][x-1];
        }
        // turn west
        for(int x=1+depth, y=N-depth; y>1+depth; y--){
            map[y][x]=map[y-1][x];
        }
        // 두 번 바꾼 값 복구
        map[2+depth][1+depth] = tmp;

        turn(depth+1);
    }
}
