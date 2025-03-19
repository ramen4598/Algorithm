import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2623 {

    static int N, M; // 가수 수, 보조 PD 수
    static ArrayList<Integer> ret;
    static ArrayList<Integer>[] list;
    static int[] inDegree;
    
    public static void main(String[] args) throws Exception {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ret = new ArrayList<>();

        inDegree = new int[N+1]; // 1 ~ N
        list = new ArrayList[N+1];
        for(int i=0, end = N+1; i<end; i++){
            list[i] = new ArrayList<Integer>();
        }

        int pd, from, to; // pd 별 담당한 가수의 수, 앞 가수
        for(int i=0; i<M; i++){ // 인접 리스트 초기화
            st = new StringTokenizer(br.readLine());
            pd = Integer.parseInt(st.nextToken());
            from = Integer.parseInt(st.nextToken());
            for(int j=1; j<pd; j++){
                to = Integer.parseInt(st.nextToken());
                list[from].add(to);
                inDegree[to]++; // 진입 차수 초기화
                from = to;
            }
        }

        solve();

        br.close();
    }
    // 위상 정렬
    private static void solve() {
        Queue<Integer> q = new ArrayDeque<>();

        int end = N+1;
        for(int i=1; i<end; i++){ // 진입 차수가 0인 경우 q에 삽입
            if(inDegree[i]==0) q.offer(i);
        }

        int cur;
        while(!q.isEmpty()){
            cur = q.poll();
            ret.add(cur);

            // cur 후에 오는 노드들의 진출 차수 감소
            for(Integer idx : list[cur]){
                inDegree[idx]--;
                if(inDegree[idx] == 0) q.offer(idx);
            }
        }

        if(ret.size()!=N){ // 위상 정렬이 불가능 -> 순환 발생
            System.out.println(0);
            return;
        }

        StringBuffer sb = new StringBuffer();
        for(Integer i : ret){
            sb.append(i).append("\n");
        }       
        System.out.println(sb);
    }
}
