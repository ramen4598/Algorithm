import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16835 {

    static int N, M, R;
    static int[][] map;
    StringBuffer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 배열 저장
        map = new int[N+1][M+1];
        for(int y=1; y<=N; y++){
            st = new StringTokenizer(br.readLine());
            for(int x=1; x<=M; x++){
                map[y][x]=Integer.parseInt(st.nextToken());
            }
        }
        // 연산 실행
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<R; i++){
            switch (Integer.parseInt(st.nextToken())) {
                case 1:
                    oper1();
                    break;
                case 2:
                    oper2();
                    break;
                case 3:
                    oper3();
                    break;
                case 4:
                    oper4();
                    break;
                case 5:
                    oper5();
                    break;
                case 6:
                    oper6();
                    break;
            }
        }

        //출력
        StringBuffer sb = new StringBuffer();
        for(int y=1; y<map.length; y++){
            for(int x=1; x<map[0].length; x++){
                sb.append(map[y][x]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
    // 상하 반전
    private static void oper1() {
        int[][] tmp = new int[map.length][map[0].length];
        for(int y=1; y<map.length; y++){
            tmp[map.length-y] = map[y];
        }
        map = tmp;
    }
    // 좌우 반전
    private static void oper2() {
        int[][] tmp = new int[map.length][map[0].length];
        for(int y=1; y<map.length; y++){
            for(int x=1; x<map[0].length; x++){
                tmp[y][map[0].length-x] = map[y][x];
            }
        }
        map = tmp;
    }
    //오른쪽으로 90도 회전
    private static void oper3() {
        int[][] tmp = new int[map[0].length][map.length];
        for(int y=1; y<map.length; y++){
            for(int x=1; x<map[0].length; x++){
                tmp[x][map.length-y] = map[y][x];
            }
        }
        map = tmp;
    }
    //왼쪽으로 90도 회전
    private static void oper4() {
        int[][] tmp = new int[map[0].length][map.length];
        for(int y=1; y<map.length; y++){
            for(int x=1; x<map[0].length; x++){
                tmp[map[0].length-x][y] = map[y][x];
            }
        }
        map = tmp;
    }
    // 1->2, 2->3, 3->4, 4->1
    private static void oper5() {
        int[][] tmp = new int[map.length][map[0].length];
        int yHalf=(map.length-1)/2;
        int xHalf=(map[0].length-1)/2;
        for(int y=1; y<=yHalf; y++){
            for(int x=1; x<=xHalf; x++){
                tmp[y][x+xHalf]=map[y][x]; // 1->2
                tmp[y+yHalf][x+xHalf]=map[y][x+xHalf]; // 2->3
                tmp[y+yHalf][x]=map[y+yHalf][x+xHalf]; // 3->4
                tmp[y][x]=map[y+yHalf][x]; // 4->1
            }
        }
        map = tmp;
    }
    // 1->4, 4->3, 3->2, 2->1
    private static void oper6() {
        int[][] tmp = new int[map.length][map[0].length];
        int yHalf=(map.length-1)/2;
        int xHalf=(map[0].length-1)/2;
        for(int y=1; y<=yHalf; y++){
            for(int x=1; x<=xHalf; x++){
                tmp[y+yHalf][x]=map[y][x]; // 1->4
                tmp[y+yHalf][x+xHalf]=map[y+yHalf][x]; // 4->3
                tmp[y][x+xHalf]=map[y+yHalf][x+xHalf]; // 3->2
                tmp[y][x]=map[y][x+xHalf]; // 2->1
            }
        }
        map = tmp;
    }
}
