import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA9229 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int[] arr; // 과자 봉지 무게
        int N, M, ret; // 개수, 무게 제한, 결과
        int T = Integer.parseInt(st.nextToken());
        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            ret = -1;
            arr = new int[N];

            // 과자 봉지 무게 저장
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 과자 봉지 선택 =  고정된 크기의 조합(중복X)
            int sum;
            for(int i=0; i<N; i++){
                for(int j=i+1; j<N; j++){
                    sum = arr[i] + arr[j];
                    if(sum > M) continue;
                    ret = Math.max(ret, sum);
                }
            }           
            sb.append("#").append(tc).append(" ").append(ret).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}
