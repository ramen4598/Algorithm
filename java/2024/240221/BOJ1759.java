import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


// next_Permuatation으로 조합 구현
public class BOJ1759 {
    static int L, C;
    static List<Character> ja, mo; // 자음, 모음, 조합
    static List<String> ret;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());       
        StringBuffer sb = new StringBuffer();

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ja = new ArrayList<Character>();
        mo = new ArrayList<Character>();
        ret = new ArrayList<String>();

        char input;
        st = new StringTokenizer(br.readLine());       
        for(int i=0; i<C; i++){
            input = st.nextToken().charAt(0);
            if(input == 'a' || input == 'e' || input == 'i' || input == 'o' || input == 'u'){
                mo.add(input);
            }else{
                ja.add(input);
            }
        }
        Collections.sort(mo);
        Collections.sort(ja);
        solve();

        // 출력
        Collections.sort(ret);
        for(String s : ret){
            sb.append(s).append("\n");
        }
        System.out.println(sb);
        br.close();
    } 

    static void solve(){
        int[] p1, p2;
        List<Character> comb = new ArrayList<Character>();
        StringBuffer str;

        for (int i = 1; i <= mo.size(); i++) { // 모음의 수
            if (L - i < 2) continue; // 자음 최소 둘
            if (L - i > ja.size()) continue; // 자음의 수보다  많은면 통과

            // 모음 조합 - next_permutation 이용
            int moSize = mo.size();
            p1 = new int[moSize];
            for(int j=0; j<i; j++){
                p1[moSize-1-j] = 1;
            }
            do{
                for(int j=0; j<moSize; j++){
                    if(p1[j] != 0) comb.add(mo.get(j));
                }
                // 자음 조합 - next_permutation 이용
                int jaSize = ja.size();
                p2 = new int[jaSize];
                for(int j=0; j<L-i; j++){
                    p2[jaSize-1-j] = 1;
                }
                do{
                    for(int j=0; j<jaSize; j++){
                        if(p2[j] != 0) comb.add(ja.get(j));
                    }
                    // 정렬
                    Collections.sort(comb);
                    str = new StringBuffer();
                    for(Character c : comb){
                        str.append(c);
                    }
                    ret.add(str.toString());
                    
                    for(int j=0; j<jaSize; j++){
                        if(p2[j] != 0) comb.remove(ja.get(j));
                    }
                }while(next_Permutation(p2));

                comb.clear();
            }while(next_Permutation(p1));
        }
    }

    private static boolean next_Permutation(int[] p) {
        final int last = p.length - 1;
        // 가장 큰 i 찾기
        int i = last;
        while(i>0 && p[i-1] >= p[i]) i--;
        if(i==0) return false; // 순열의 끝

        // i-1과 교환할 j 찾기
        int j=last;
        while(p[i-1] >= p[j]) j--;

        // i-1, j 자리 수 교환
        swap(p, i-1, j);

        // i부터 마지막까지 정렬
        int k = last;
        while(i<k) swap(p, i++, k--);

        return true;
    }

    private static void swap(int[] p, int i, int j) {
        int tmp = p[i];
        p[i] = p[j];
        p[j] = tmp;
    }
}
