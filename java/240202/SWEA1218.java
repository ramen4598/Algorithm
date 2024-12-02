import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA1218 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       
        StringTokenizer st; 
        StringBuffer sb = new StringBuffer();
        Stack<Character> stk;

        for(int tc=1; tc<=10; tc++){
            st = new StringTokenizer(br.readLine());
            st.nextToken(); // 테스트 케이스 길이 
            
            st = new StringTokenizer(br.readLine());
            char[] input = st.nextToken().toCharArray();

            boolean flag = true;
            stk = new Stack<Character>();
            label : for(char c : input){
                switch (c) {
                    case '(' : case '{' : case '[' : case '<' :
                        stk.push(c);
                        break;
                    case ')' : 
                        if(!stk.isEmpty() && stk.pop()=='(') 
                            continue label;
                        flag=false;
                        break label;
                    case '}' : 
                        if(!stk.isEmpty() && stk.pop()=='{') 
                            continue label;
                        flag=false;
                        break label;
                    case ']' : 
                        if(!stk.isEmpty() && stk.pop()=='[') 
                            continue label;
                        flag=false;
                        break label;
                    case '>' :
                        if(!stk.isEmpty() && stk.pop()=='<') 
                            continue label;
                        flag=false;
                        break label;
                }
            }
            if(flag) 
                sb.append("#"+tc+" 1\n");
            else 
                sb.append("#"+tc+" 0\n");
        }
        System.out.println(sb);
        br.close();
    }
}