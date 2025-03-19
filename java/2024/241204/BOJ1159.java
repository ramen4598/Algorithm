import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1159 {

    static int[] cnt;
    static int N;
    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt = new int[26];

        char input;
        for(int i=0; i<N; i++){
            input = br.readLine().charAt(0);
            cnt[input - 'a']++;
        }
        br.close();
        // System.out.println(Arrays.toString(cnt));
    }

    static void solve() {
        boolean isRREDAJA = true;
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<26; i++){
            if(cnt[i] < 5) continue;
            isRREDAJA = false;
            char c = (char)('a' + i);
            sb.append(c);
        }
        if(isRREDAJA){
            System.out.println("PREDAJA");
        }else{
            System.out.println(sb);
        }
    }
}
