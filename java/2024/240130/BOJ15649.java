import java.util.Scanner;

public class BOJ15649 {
    static int n, m;
    static int[] ret;
    static boolean[] visited = new boolean[9];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        ret = new int[m];
        solve(0);
        sc.close();
    }

    public static void solve(int idx){
        if(idx==m){
            for(int i : ret){
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for(int i=1; i<=n; i++){
            if(visited[i]){
                continue;
            }
            ret[idx]=i;
            visited[i]=true;
            solve(idx+1);

            visited[i]=false;
        }
    }
}
