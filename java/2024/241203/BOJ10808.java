import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

class BOJ10808 {

    static char[] input;
    static int[] cnt;

    public static void main(String[] args) throws IOException {

        init();
        solve();
        print();

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().trim().toCharArray();

        cnt = new int[26];

        // System.out.println(input);
    }

    private static void solve() throws IOException {

        for(char i : input){
            cnt[i-'a']++;
        }

        // System.out.println(Arrays.toString(cnt));
    }

    private static void print() {
        StringBuffer sb = new StringBuffer();

        for(int i : cnt){
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

}