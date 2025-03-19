import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


// 재귀함수로 조합 구현
public class BOJ1759_2 {
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
        for (int i = 0; i < C; i++) {
            input = st.nextToken().charAt(0);
            if (input == 'a' || input == 'e' || input == 'i' || input == 'o' || input == 'u') {
                mo.add(input);
            } else {
                ja.add(input);
            }
        }
        solve();

        // 출력
        Collections.sort(ret);
        for (String s : ret) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    static void solve() {
        StringBuffer str;
        List<Character> comb = new ArrayList<>();
        List<List<Character>> moCombs;
        List<List<Character>> jaCombs;
        for (int i = 1; i <= mo.size(); i++) { // 모음의 수 결정
            if (L - i < 2) continue; // 자음 최소 둘
            if (L - i > ja.size()) continue; // 자음의 수보다  많은면 통과
            moCombs = new ArrayList<>();
            jaCombs = new ArrayList<>();

            // 모음 조합
            makeComb(mo, i, 0, new ArrayList<Character>(), moCombs);
            // 자음 조합
            makeComb(ja, L - i, 0, new ArrayList<Character>(), jaCombs);

            // 전체 조합
            for (List<Character> moComb : moCombs) {
                for (List<Character> jaComb : jaCombs) {
                    comb.addAll(moComb);
                    comb.addAll(jaComb);
                    Collections.sort(comb); // 정렬
                    str = new StringBuffer();
                    for (Character c : comb) {
                        str.append(c);
                    }
                    ret.add(str.toString());
                    comb.clear();
                }
            }
        }
    }

    // 주어진 depth 크기의 조합을 생성
    static void makeComb(List<Character> list, int depth, int start, List<Character> res, List<List<Character>> combs) {
        if (depth == 0) {
            combs.add(new ArrayList<>(res));
            return;
        }

        for (int i = start; i < list.size(); i++) {
            res.add(list.get(i));
            makeComb(list, depth - 1, i + 1, res, combs);
            res.remove(res.size() - 1);
        }
    }
}
