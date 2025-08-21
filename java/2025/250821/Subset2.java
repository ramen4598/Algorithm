// 부분집합
// 재귀함수
// 일반적인 경우. 가지치기를 통해서 시간을 명확하게 아낄 수 있음.
// 시간복잡도 : O(2^N)

/*
3
1 2 3
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Subset2 {

    static int N;
    static int[] input;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(st.nextToken());
        input = new int[N];
        isSelected = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        subset(0, sb);
        System.out.println(sb);
        br.close();
    }

    private static void subset(int idx, StringBuffer sb){
        if(idx == N){
            for(int i=0; i<N; i++){
                if(!isSelected[i]) continue;
                sb.append(input[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        isSelected[idx] = true;
        subset(idx+1, sb);
        isSelected[idx] = false;
        subset(idx+1, sb);
    }
}
