import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ10988 {

    static String word;
    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine().trim();
        br.close();
        // System.out.println(word);
    }

    private static void solve() {
        String reverse = new StringBuilder(word).reverse().toString();
        System.out.println((word.equals(reverse) ? 1 : 0));
    }
    
}
