import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1225 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Queue<Integer> q;
        int[] arr;
        StringBuffer sb = new StringBuffer();

        for(int tc=1; tc<=10; tc++){
            //8자리 숫자 입력
            br.readLine(); // 쓰레기 값
            st = new StringTokenizer(br.readLine());
            arr = new int[8];
            for(int i=0; i<8; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 제자리로 돌아오는 8 싸이클을 최대 몇 번 생략할 수 있는가?
            // 각 수를 1+2+3+4+5=15로 나눈 몫 중 최소값을 찾는다.
            int tmp;
            int min = Integer.MAX_VALUE;
            for(int i=0; i<8; i++){
                tmp = arr[i] / 15;
                tmp--; // 15로 나누어 떨어지는 경우를 방지
                min = Math.min(min, tmp);             
            }

            // 최대한 실행할 싸이클을 줄인 후 queue에 삽입
            q = new ArrayDeque<>();
            for(int i=0; i<8; i++){
                q.offer(arr[i] - (15 * min));
            }

            // 암호 생성
            int num;
            int cnt = 1;
            while(true){
                num = q.poll() - cnt;
                if(num <= 0) {
                    q.offer(0);
                    break;
                }else{
                    q.offer(num);
                    cnt %= 5;
                    cnt++;
                }
            }

            sb.append("#").append(tc).append(" ");
            for(int i=0; i<8; i++){
                sb.append(q.poll()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    } 
}
