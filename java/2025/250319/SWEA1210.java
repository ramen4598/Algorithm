import java.io.*;
import java.util.StringTokenizer;
// import java.util.Arrays;

public class SWEA1210 {

    static boolean[][] visited;
    static char[][] map;
    static int ret, start_x;

    private static void init(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        ret = 0; start_x = 0;

        map = new char[100][100];
        visited = new boolean[100][100];
        for(int i=0; i<100; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<100; j++){
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == '2'){
                    start_x = j;
                }
            }
        }

        // for(char[] arr : map) System.out.println(Arrays.toString(arr));
    }

    private static void solve(){
        int y = 99;
        int x = start_x; 
        while(y > 0){
            visited[y][x] = true;
            // 좌
            if (x-1 >= 0 && map[y][x-1] == '1' && !visited[y][x-1]){
                x--;
                continue;
            }
            // 우
            if (x+1 < 100 && map[y][x+1] == '1' && !visited[y][x+1]){
                x++;
                continue;
            }
            // 아래
            y--;
        }
        ret = x;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        for(int tc=1; tc<=10; tc++) {
            init(br);
            solve();
            sb.append("#").append(tc).append(" ").append(ret).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}