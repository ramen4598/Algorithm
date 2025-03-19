import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1238 {

    static int N, start;
    static int[][] g; // 인접 행렬
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        
        for(int tc=1; tc<11; ++tc){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 입력 데이터 수
            start = Integer.parseInt(st.nextToken()); // 시작점

            // 인접 행렬 초기화
            g = new int[101][101]; // 1 ~ 100
            int from, to;
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i+=2){
                from  = Integer.parseInt(st.nextToken());
                to  = Integer.parseInt(st.nextToken());
                g[from][to] = 1;
            }

            // System.out.println("--------");
            // for(int y=1; y<101; y++){
            //     for(int x=1; x<101; x++){
            //         if(g[y][x]==1){
            //             System.out.println("from : " + y + " to : " + x);
            //         }
            //     }
            // }

            sb.append("#").append(tc).append(" ").append(bfs()).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static int bfs() {
        boolean[] vis = new boolean[101];
        Queue<Integer> q = new ArrayDeque<Integer>();

        q.offer(start);
        vis[start] = true;

        int size, cur, ret=start;
        while(!q.isEmpty()){
            size = q.size();

            ret=Integer.MIN_VALUE;
            for(int i=0; i<size; i++){ // 너비 단위로 BFS
                cur = q.poll();
                ret = Math.max(ret, cur); // 같은 너비 중 가장 큰 노드

                for(int j=1; j<101; j++){ // 1 ~ 100
                    if(g[cur][j]==0) continue; // 인접한 노드
                    if(vis[j]) continue;
                    q.offer(j);
                    vis[j] = true;
                }
            }
        }

        return ret;
    }
}