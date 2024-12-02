import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2563 {

    static int[][] map;
    static int N, ret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        map = new int[101][101];
        N = Integer.parseInt(st.nextToken());

        int y, x;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            solve(y, x);
        }

        System.out.println(ret);
        br.close();
    }

    // 색종이 붙이기
    private static void solve(int y, int x){
        int yEnd = y + 10;
        int xEnd = x + 10;
        for(int ny=y; ny<yEnd; ny++){
            for(int nx=x; nx<xEnd; nx++){
                if(map[ny][nx]<=0){
                    //System.out.println(ny + " " + nx);
                    ret++;
                } 
                map[ny][nx]++;
            }
        }
    }
}
