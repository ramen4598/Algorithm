import java.io.*;
import java.util.StringTokenizer;
// import java.util.Arrays;

public class BOJ1244 {

    static int S, N; // switch, number of student
    static char[] switchs;
    
    private static void do_man(int num) {
        for(int i=num; i<=S; i+=num){
            change(i);
        }
    }

    private static void do_woman(int num) {
        change(num);
        int idx = 1, left, right;
        boolean under, over;
        while(true){
            // 1. under, overflow 검사
            left = num - idx;
            right = num + idx;
            under = left < 1; 
            over = right > S;
            if(under || over) break;
            // 2. 대칭 검사
            if(switchs[left] == switchs[right]){
                // 1 and 2 모두 만족하면 스위치 조작
                change(left);
                change(right);
                idx++;
            }else{
               break;
            }
        }
    }

    private static void change(int num) {
        switchs[num] = (switchs[num] == '1') ? '0' : '1';
        // System.out.println("change : " + num + " -> " + Arrays.toString(switchs));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        S = Integer.parseInt(st.nextToken());
        switchs = new char[S+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=S; i++){
            switchs[i] = st.nextToken().charAt(0);
        }

        // System.out.println(Arrays.toString(switchs));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int gender, num;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            gender = Integer.parseInt(st.nextToken());
            num = Integer.parseInt(st.nextToken());
            if(gender == 1) do_man(num);
            if(gender == 2) do_woman(num);
        }

        int cnt = 0;
        for(int i=1; i<=S; i++){
            sb.append(switchs[i]).append(" ");
            cnt++;
            if(cnt == 20){
                sb.append("\n");
                cnt=0;
            }
        }
            
        System.out.println(sb);
        br.close();
    }
}