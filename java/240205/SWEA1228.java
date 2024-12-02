import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA1228 {
    static int N, oper; // 암호문 길이, 명령어 개수
    static List<Integer> list;
    static String[] operations; // 명령어들
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        for(int tc=1; tc<=10; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            list = new LinkedList<Integer>();

            // 원본 암호문
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                list.add(Integer.parseInt(st.nextToken()));
            }

            //명령어 수
            st = new StringTokenizer(br.readLine());
            oper = Integer.parseInt(st.nextToken());

            // 암호문 입력 
            operations = br.readLine().split("I");

            // 암호문 수정 (첫번째 I 무시)
            int x, y, s;
            for(int i=1; i<=oper; i++){
                st = new StringTokenizer(operations[i]);
                x = Integer.parseInt(st.nextToken()) - 1;
                y = Integer.parseInt(st.nextToken());
                for(int j=1; j<=y; j++){
                    s = Integer.parseInt(st.nextToken());
                    //System.out.println(x+", "+j+" : "+s);
                    list.add(x+j, s); // 삽입
                }
            }

            // 암호문 출력
            sb.append("#").append(tc);
            for(int i=0; i<10; i++){
                sb.append(" ").append(list.get(i));
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
        br.close();
    }
}
