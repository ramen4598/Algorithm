import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2457 {

    static class Flower implements Comparable<Flower>{
        int start, end;

        Flower(int sm, int sd, int em, int ed){
            this.start = sm * 100 + sd;
            this.end = em * 100 + ed;
        }

        @Override
        public int compareTo(Flower o){
            return (this.start - o.start);
        }

        @Override
        public String toString(){
            return "["+start+ " -> " + end +"]";
        }
    }
    static int N, ret;
    static Flower[] flowers;
    public static void main(String[] args) throws Exception {
       init();

       go();

       System.out.println(ret);
    }

    static void init()throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
       StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        flowers = new Flower[N];
        int sm, sd, em, ed;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            sm = Integer.parseInt(st.nextToken());
            sd = Integer.parseInt(st.nextToken());
            em = Integer.parseInt(st.nextToken());
            ed = Integer.parseInt(st.nextToken());
            flowers[i] = new Flower(sm, sd, em, ed);
        }
        // debug
        // System.out.println(Arrays.toString(flowers));
    }

    private static void go() {
        Arrays.sort(flowers); // 피는 날이 빠른 꽃이 앞에 오도록 정렬
        ArrayList<Flower> comb = new ArrayList<Flower>();

        Flower tmp = null;
        comb.add(new Flower(1, 1, 3, 1));
        for(int i=0; i<N; i++){
            if(comb.get(comb.size()-1).end >= flowers[i].start){ // 통과
                if(tmp == null || tmp.end < flowers[i].end)
                    tmp = flowers[i];
                continue;
            }
            
            // 어쩔 수 없이 새로운 꽃 추가
            // 11월 30일 넘었으면 종료
            if(tmp !=null && tmp.end > 1130){
                break;
            } 
            // 추가할 수 있는 꽃이 없거나
            // 새로 추가할 꽃의 end보다도 여전히 이번 꽃의 start가 느리면 가능한 경우의 수 없음
            if(tmp == null || tmp.end < flowers[i].start){
                ret = 0;
                return;
            }

            // 지나간 꽃들 중 포함되지 않으면 end가 가장 큰 꽃을 추가
            comb.add(tmp);
            tmp = flowers[i];
        }

        // 마지막 남은 tmp에 대하여            
        comb.add(tmp);
        ret = (tmp.end > 1130) ? comb.size()-1 : 0;
        
        //debug
        // System.out.println("-------------" + ret);
        // for(Flower f : comb){
        //     System.out.println(f+", ");
        // }
    }
}
