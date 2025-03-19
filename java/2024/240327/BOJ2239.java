import java.io.BufferedReader;
import java.io.InputStreamReader;

// 스도쿠
public class BOJ2239 { // 1040ms

    static int[][] map;
    static boolean[] vis;
    static boolean done = false;
    public static void main(String[] args) throws Exception {
        init();
        solve(0);
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        

        map = new int[9][9];
        char[] input;
        for(int i=0; i<9; i++){
            input = br.readLine().trim().toCharArray();
            for(int j=0; j<9; j++){
                map[i][j] = input[j] - '0';
            }
        }
        //print(); 
    }

    static void solve(int num){
        //System.out.println(num);
        if(done) return;

        // 다음 빈 곳을 찾는다.
        int ny=-1, nx=-1;
        int y, x;
        for(int i=num; i<81; i++){
            y = i/9;
            x = i%9;
            if(map[y][x] == 0){
                ny = y;
                nx = x;
                break;
            } 
        }
        // 없으면 끝
        if(ny == -1){
            print();
            done = true;
            return;
        }

        // 그렇지 않다면 채운다
        for(int j=1; j<10; j++){
            map[ny][nx] = j; // 숫자 넣기
            if(check1(ny) && check2(nx) && check3(ny,nx)){
                solve((ny*9)+nx+1);
            }
            // else{
            //     System.out.println("------------------");
            //     System.out.println(i);
            //     System.out.println(check1(y) +", "+ check2(x) +", "+ check3(y,x));
            //     print();
            // }
        }
        map[ny][nx] = 0; // 숫자 빼기
    }
    // 가로 중복 검사
    static boolean check1(int y){
        vis = new boolean[10];
        for(int i=0; i<9; i++){
            if(map[y][i]==0) continue;
            if(vis[map[y][i]]) return false;
            vis[map[y][i]] = true;
        }
        return true;
    }
    // 세로 중복 검사
    static boolean check2(int x){
        vis = new boolean[10];
        for(int i=0; i<9; i++){
            if(map[i][x]==0) continue;
            if(vis[map[i][x]]) return false;
            vis[map[i][x]] = true;
        }
        return true;
    }
    // 3 x 3 중복 검사
    static boolean check3(int y, int x){
        vis = new boolean[10];
        int sy = (y/3) * 3;
        int sx = (x/3) * 3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(map[sy+i][sx+j]==0) continue;
                if(vis[map[sy+i][sx+j]]) return false;
                vis[map[sy+i][sx+j]] = true;
            }
        }
        return true;
    }

    static void print(){
        for(int[] row : map){
            for(int i : row){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}