import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 슬라이딩 윈도우
public class BOJ15961 {
    static int N, D, K, C, cnt, ret;
    static int[] map, window;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[N];
        window = new int[D+1]; // 각 초밥 별로 선택된 초밥의 수 카운팅

        // 초밥 벨트 초기화
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            map[i] = Integer.parseInt(st.nextToken());
        }

        // window 초기화 0번 ~ k-1번 초밥의 종류 세기
        for(int i=0; i<K; i++){
            if(window[map[i%N]]==0) cnt++; // cnt 초기화
            window[map[i%N]]++;
        }
        // ret 초기화
        ret = cnt;
        // 서비스 초밥
        if(window[C] == 0){ 
            ret++;
        }

        // i번째에서부터 K개 초밥의 개수를 센다. + 서비스 초밥
        for(int i=1; i<N; i++){
            solve(i);
        }

        System.out.println(ret);
        br.close();
    }

    // i번째부터 K개 초밥의 종류 + 서비스 초밥
    private static void solve(int i) {
        // 빼고
        in((i-1)%N);
        // 넣고
        out((i-1+K)%N);
        // 서비스 초밥
        if(window[C] == 0){
            ret = Math.max(ret, cnt+1);
        }else{
            ret = Math.max(ret, cnt);
        }
    }

    private static void in(int i) {
        // window 갱신
        window[map[i]]--;
        // cnt 갱신
        if(window[map[i]]==0) cnt--;
    }

    private static void out(int i) {
        // cnt 갱신
        if(window[map[i]]==0) cnt++;
        // window 갱신
        window[map[i]]++;
    }

}
