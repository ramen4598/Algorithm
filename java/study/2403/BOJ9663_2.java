import java.util.StringTokenizer;
import java.io.*;

class BOJ9663_2 {
  static int N, ret; 
  static int[] map;
  public static void main(String[] args)throws Exception{
    init();

    go(0, new boolean[N]);

    System.out.println(ret);
  }

  static void init() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    ret = 0;
    map = new int[N];
  }

  static void go(int depth, boolean[] vis){
    if(depth==N){
      ret++;
      return;
    }

    for(int i=0; i<N; i++){
      if(vis[i]) continue;
      if(check(depth, i)) continue;
      vis[i] = true; map[depth] = i;
      go(depth+1, vis);
      vis[i] = false;
    }
  }

  static boolean check(int y, int x){
    for(int i=0; i<y; i++){
      if(Math.abs(y-i) == Math.abs(x-map[i])){
        return true;
      }
    }
    return false;
  }

}
