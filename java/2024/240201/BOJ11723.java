import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11723 {
    static int S = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        String input;
        int x = 0;
        int m = Integer.parseInt(st.nextToken());
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            input = st.nextToken();
            switch(input) {
                case "add" :
                    x = Integer.parseInt(st.nextToken());
                    add(x);
                    break;
                case "remove" :
                    x = Integer.parseInt(st.nextToken());
                    remove(x);
                    break;
                case "check" :
                    x = Integer.parseInt(st.nextToken());
                    sb.append(check(x)).append("\n");
                    break;
                case "toggle" :
                    x = Integer.parseInt(st.nextToken());
                    toggle(x);
                    break;
                case "all" :
                    all();
                    break;
                case "empty" :
                    empty();
                    break;
            }

        }
        System.out.println(sb);
        br.close();
    }

    private static void add(int x) {
        int num = 1<<x;
        S = S | num;
    }

    private static void remove(int x) {
        int num = 1<<x;
        S = S & ~num;
    }

    private static int check(int x) {
        int num = 1 << x;
        if((S & num) != 0){
            return 1;
        } else{
            return 0;
        }
    }

    private static void toggle(int x) {
        S ^= (1 << x);
        // if(check(x)==1){
        //     remove(x);
        // }else{
        //     add(x);
        // }
    }

    private static void all() {
        S = -1;
    }

    private static void empty() {
        S =  0;
    }
}
