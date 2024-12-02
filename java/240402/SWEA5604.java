import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Map.Entry;

// 구간합
public class SWEA5604 {
    static HashMap<Long, Long> f;
    static long start, end, ret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(st.nextToken()); 
        for(int tc=1; tc<=T; tc++){
            init(br, st);
            if(start == 0)  ret = F(end) - F(start);
            else ret = F(end) - F(start - 1);
            sb.append("#").append(tc).append(" ").append(ret).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
    private static void init(BufferedReader br, StringTokenizer st) throws IOException {
        st = new StringTokenizer(br.readLine());
        start = Long.parseLong(st.nextToken());
        end = Long.parseLong(st.nextToken());
        f = new HashMap<>();
        f.put(0L, 0L);
        for(long i=1; i<10; i++){
            f.put(i, f.get(i-1)+i);
        }

        // F(9) = 45
        // F(99) = 2*10 * F(9)
        // ...

        //debug
        // for(Entry<Long, Long> e : f.entrySet()){
        //     System.out.println(e.getKey() + " : " + e.getValue());
        // }
    } 
    private static long F(long n) {
        if(n < 10) return f.get(n); // 0 ~ 9
        if(f.containsKey(n)) return f.get(n); // 이미 계산한 적 있음

        long v = V(n);
        long G1 = (n/v)*(n%v+1) + F(n%v);
        long F1 = F(n-n%v-1) + G1;
        f.put(n, F1);

        //debug
        // System.out.println(n + " : " + F1);
        return F1;
    }
    private static long V(long n) {
        long v = 1;        
        while(n > 9){
            n /= 10;
            v *= 10;
        }
        return v;
    }
}
