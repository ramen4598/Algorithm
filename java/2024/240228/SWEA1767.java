import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 60 tc 중 58개 통과
public class SWEA1767 {
    static int N, ret;
    static int[][] map;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static List<Core> cores;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(st.nextToken());
        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            cores = new ArrayList<Core>();
            ret = 0;

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                   map[i][j] = Integer.parseInt(st.nextToken());
                   if(map[i][j]==1){ // 코어면
                        cores.add(new Core(i, j));
                   }
                }
            }
            for(Core c : cores){ // 코어의 연결 가능한 전선이 수와 그 전선들의 길이 등 정보를 초기화
                c.find();
            }

            solve();
            sb.append("#").append(tc).append(" ").append(ret).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
    private static void solve() {

        for(int i=0; i<cores.size(); i++){
            // 모든 코어 중 다음으로 연결할 코어 선택
            Core cur = null;
            Collections.sort(cores);


            for(int j=0; j<cores.size(); j++){
                cur = cores.get(j);
                if(cur.vis) continue;
                cur.vis = true;
                break;
            }

            if(cur.p == 0) continue; // 연결할 수 없는 코어
            ret += cur.line[cur.min]; // 전선 길이 추가

            // 전선 연결 표시
            int ny, nx;
            for(int j=1; j<N; j++){ 
                ny = cur.y + dy[cur.min]*j;
                nx = cur.x + dx[cur.min]*j;
                boolean under = ny<0||nx<0;
                boolean over = ny>=N||nx>=N;
                if(under||over) continue;
                if(map[ny][nx]==0)map[ny][nx] = 2;
            }
            // 전선 깔고서 코어의 정보 갱신
            for(int j=0; j<cores.size(); j++){
                if(cores.get(j).vis) continue;
                cores.get(j).find();
            }

            //debug
            // System.out.println("------------" + i);
            // for(int y=0; y<N; y++){
            //     for(int x=0; x<N; x++){
            //         System.out.print(map[y][x] + " ");
            //     }
            //     System.out.println();
            // }
        }
    }

    static class Core implements Comparable<Core> {
        boolean vis = false;
        int y, x;
        int p, min; // 각 코어마다 연결 가능한 전선의 수, 가장 짧은 연결 가능한 전선의 인덱스
        int[] line = new int[4]; // 시계방향(상우하좌) 연결에 필요한 전선의 길이

        Core(int y, int x){
            this.y = y;
            this.x = x;
        }

        public void find(){
            p = 0; min = 0;
            int ny, nx;
            for(int d=0; d<4; d++){ // 4방 탐색하며 p, line, min을 설정
                for(int i=1; i<N; i++){ // 끝까지
                    ny = y + dy[d]*i;
                    nx = x + dx[d]*i;
                    boolean under = ny<0||nx<0;
                    boolean over = ny>=N||nx>=N;
                    if(under||over) continue;
                    if(map[ny][nx]>0) { // 코어, 전선을 만남
                        this.line[d] = Integer.MAX_VALUE; // 연결할 수 없음
                        break; 
                    }
                    this.line[d] = i; // 시계방향으로 전선의 길이를 측정
                }
                if(line[d]!=Integer.MAX_VALUE) p++; // 연결할 수 있는 전선이 수 세기 
                if(line[min] > line[d]) min = d; // 가장 짧은 전선의 인덱스
            }
        }

        @Override
        public int compareTo(Core o) {
            if(this.p == o.p){
                return Integer.compare(this.line[this.min], o.line[o.min]);
            }
            return Integer.compare(this.p, o.p);
        }

        @Override
        public String toString() {
            return "Core [vis=" + vis + ", y=" + y + ", x=" + x + ", p=" + p + ", min=" + min + ", line="
                    + Arrays.toString(line) + "]";
        }

    }
}
