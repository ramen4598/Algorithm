import java.io.*;
import java.util.StringTokenizer;
// import java.util.Arrays;

public class BOJ1991 {

    static int N;
    static Node[] tree;
    static StringBuffer sb;

    private static class Node {
        char data; 
        char left;
        char right;

        public Node (char data, char left, char right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        tree = new Node[26];
        sb = new StringBuffer();

        char data, left, right;
        for (int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            data = st.nextToken().charAt(0); 
            left = st.nextToken().charAt(0); 
            right = st.nextToken().charAt(0); 

            tree[data - 'A'] = new Node(data, left, right);
        }
    }

    private static void solve() {
        sb.append(pre('A')).append("\n");
        sb.append(in('A')).append("\n");
        sb.append(post('A')).append("\n");
    }

    private static String pre(char node) {
        Node cur = tree[node - 'A'];
        String ret = "" + cur.data; 
        if(cur.left != '.'){
            ret += pre(cur.left);
        }
        if(cur.right != '.'){
            ret += pre(cur.right);
        }
        return ret;
    }

    private static String in(char node) {
        Node cur = tree[node - 'A'];
        String ret = "";
        if(cur.left != '.'){
            ret += in(cur.left);
        }
        ret += cur.data; 
        if(cur.right != '.'){
            ret += in(cur.right);
        }
        return ret;
    }

    private static String post(char node) {
        Node cur = tree[node - 'A'];
        String ret = "";
        if(cur.left != '.'){
            ret += post(cur.left);
        }
        if(cur.right != '.'){
            ret += post(cur.right);
        }
        ret += cur.data; 
        return ret;
    }

    public static void main(String[] args) throws Exception {
        init();
        solve();
        System.out.println(sb);
    }
    
}
