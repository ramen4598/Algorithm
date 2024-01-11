import java.util.ArrayList;
import java.util.Scanner;

public class SWEA1289 {
    public static int solve(ArrayList<Character> input) {
        int cnt = 0;
        char before = '0';

        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) != before) {
                before = input.get(i);
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int ret;
            String str = sc.next();
            ArrayList<Character> input = new ArrayList<>();

            for (char c : str.toCharArray()) {
                input.add(c);
            }

            ret = solve(input);

            System.out.println("#" + tc + " " + ret);
        }
    }
}
