import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

// 9C7 = 9C2
class BOJ2309 {

    static int sum;
    static int[] nine, seven;
    public static void main (String[] args) throws IOException{
        init();
        solve();
        print();
    }

    private static void init() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sum = 0;
        nine = new int[9];
        seven = new int[7];

        for(int i=0; i<9; i++){
            int input = Integer.parseInt(br.readLine().trim());
            nine[i] = input;
            sum += input;
        }

        br.close();
        // System.out.println(Arrays.toString(nine));
    }

    private static void solve(){

        int badHeight = sum - 100;
        for(int i=0; i<9; i++){
            for(int j=i+1; j<9; j++){
                if(nine[i] + nine[j] == badHeight){
                    // System.out.println("i : " + i + " j : " + j);
                    for(int x=0, y=0; x<9; x++){
                        if(x == i || x == j) continue;
                        // System.out.println("x : " + x + " y : " + y);
                        seven[y] = nine[x];
                        y++;
                    }
                    // System.out.println(Arrays.toString(seven));
                    return;
                }
            }
        }

    }

    private static void print(){
        Arrays.sort(seven);
        for(int i : seven){
            System.out.println(i);
        }
    }
}