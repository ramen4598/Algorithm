import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ15651 {
    static int n, m;
    static int[] ret;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // n = sc.nextInt();
        // m = sc.nextInt();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ret = new int[m];
        solve(0);
        bw.flush();
        br.close();
        bw.close();
    }

    public static void solve(int idx) throws IOException{
        if(idx==m){
            //StringBuffer sb = new StringBuffer();
            // for(int i : ret){
            //     sb.append(i).append(" ");
            // }
            // System.out.println(sb);
            for(int i : ret){
                bw.write(i + " ");
            }
            bw.newLine();
            return;
        }
        for(int i=1; i<=n; i++){
            ret[idx]=i;
            solve(idx+1);
        }
    }
}
