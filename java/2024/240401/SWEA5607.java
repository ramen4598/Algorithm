
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5607 { // 211ms
    static final long P = 1234567891;
    static long N, R, ret;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(st.nextToken());
        for(int tc=1; tc<=T; tc++){
            init(br, st);
            nCr(sb);
            sb.append("#").append(tc).append(" ").append(ret).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
    private static void init(BufferedReader br, StringTokenizer st) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        R = Long.parseLong(st.nextToken());
    } 
    private static void nCr(StringBuffer sb) {
        if(R==0 || R==N) {
            ret = 1L;
            return;
        }
        long[] fac = new long[(int)N+1];
        fac[0] = 1;
        for(int i = 1; i<=N; i++){
            fac[i] = i * fac[i-1] % P;
        }
        ret = (fac[(int)N] * pow(fac[(int)(N-R)], P-2)%P * pow(fac[(int)R], P-2)%P)%P;
    }
    private static long pow(long l, long m) {
        long res = 1L;
        l = l % P; 
        while(m > 0){
            if(m % 2 == 1) res = (res * l) % P;
            m = m >> 1;
            l = (l * l) % P;
        }
        return res;
    }
}