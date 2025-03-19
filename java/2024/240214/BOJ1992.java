import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1992 {
    
    static int n;
    static char[][] map;
    static StringBuffer sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuffer();
        
        n = Integer.parseInt(st.nextToken());
        map = new char[n][n];
        for(int i=0; i<n; i++){
            char[] input = br.readLine().trim().toCharArray();
            for(int j=0; j<n; j++){
                map[i] = input;
            }
        }

        solve(n, 0, 0);

        System.out.println(sb.toString());
        br.close();
    }

    private static void solve(int depth, int y, int x){
        if(depth == 0){ // 더 이상 쪼갤 수 없으면
            sb.append(map[y][x]);
            return;
        }

        // 압축 가능한지 확인
        boolean flag = true;
        char cur = map[y][x];
        for(int dy=0; dy<depth; dy++){
            for(int dx=0; dx<depth; dx++){
                if(cur!=map[y+dx][x+dy]){
                    flag = false;
                    break;
                } 
            }
        }

        if(flag){ // 압축X
            sb.append(cur);
            return;
        }else{ // 압축O
            sb.append("(");
            int half = depth/2;
            solve(half, y, x); // 1
            solve(half, y, x+half); // 2
            solve(half, y+half, x); // 3
            solve(half, y+half, x+half); //4
            sb.append(")");
            return;
        }
    }
}

