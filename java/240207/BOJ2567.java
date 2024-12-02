import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ2567
 */
public class BOJ2567 {


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
            fill(y, x);
        }
        count();

        System.out.println(ret);
        br.close();
    }
    static void fill(int y, int x){
        int yEnd = y+9;
        int xEnd = x+9;
        for(int ny=y; ny<=yEnd; ny++){
            for(int nx=x; nx<=xEnd; nx++){
                map[ny][nx]++;
            }
        }
    }

    static void count(){
        for(int y=1; y<100; y++){
            for(int x=1; x<100; x++){
                if(map[y][x]>0){
                    if(map[y-1][x]==0)ret++;
                    if(map[y+1][x]==0)ret++;
                    if(map[y][x-1]==0)ret++;
                    if(map[y][x+1]==0)ret++;
                }
            }
        }
    }

}