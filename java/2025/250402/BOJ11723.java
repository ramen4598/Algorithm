import java.io.*;
import java.util.StringTokenizer;

public class BOJ11723 {

    static int M, S;
    static StringBuffer sb;

    private static void solve(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int x;
        String command = st.nextToken();
        switch (command) {
            case "add":
                x = Integer.parseInt(st.nextToken());
                add(x);
                break;
            case "remove":
                x = Integer.parseInt(st.nextToken());
                remove(x);
                break;
            case "check":
                x = Integer.parseInt(st.nextToken());
                check(x);
                break;
            case "toggle":
                x = Integer.parseInt(st.nextToken());
                toggle(x);
                break;
            case "all":
                all();
                break;
            case "empty":
                empty();
                break;
        }
        // System.out.println("------------\n" + command + " : " + Integer.toString(S, 2));
    }

    private static void add(int x) {
        int num = 1<<x;
        S = S | num;
    }

    private static void remove(int x) {
       int num = 1<<x; 
       S = S & ~num;
    }

    private static void check(int x) {
        boolean tmp = (S & (1<<x)) > 0;
        sb.append(tmp ? 1 : 0).append("\n"); 
    }
    
    private static void toggle(int x) {
        S ^= (1 << x);
    }

    private static void all() {
        // S = Integer.parseInt("111111111111111111110", 2);
        // int test = Integer.parseInt("111111111111111111110", 2);
        // int sum = 0;
        // for(int i=1; i<=20; i++){
        //     sum += Math.pow(2, i);
        // }
        // S = sum;
        // System.out.println(sum + ", " + test);
        // S = 2097150;
        S = -1;
    }

    private static void empty() {
        S = 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        S = 0;
        sb = new StringBuffer();

        for(int i=0; i<M; i++) {
            solve(br);
        }

        System.out.println(sb);
        br.close();
    }
    
}
