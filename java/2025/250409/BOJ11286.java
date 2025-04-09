import java.io.*;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class BOJ11286 {

    static int N;
    static StringBuffer sb;
    static PriorityQueue<Integer> pq;

    private static void solve(int input) {
        if (input == 0) {
            int ret;
            if(pq.isEmpty()){
                ret = 0;
            } else {
                ret = pq.poll();
            } 
            sb.append(ret).append("\n");
            return;
        }
        pq.offer(input);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        sb = new StringBuffer();
        pq = new PriorityQueue<>((Integer o1, Integer o2)->{
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);
            if(abs1 == abs2) {
                return Integer.compare(o1, o2);
            }
            return Integer.compare(abs1, abs2);
        });

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            solve(Integer.parseInt(st.nextToken()));
        }

        System.out.println(sb);
        br.close();
    }
}