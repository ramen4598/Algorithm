import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class SWEA1233 {

    static int N, ret;
    static List<Node> tree;
    static final int NO_NODE = -1;

    static private class Node {
        String data;
        int num;
        int left;
        int right;

        public Node(String data, int num, int left, int right) {
            this.data = data;
            this.num = num;
            this.left = left;
            this.right = right;
        }

        // @Override
        // public String toString() {
        //     return "num : " + num + " data : " + data + " left : " + left + " right : " + right;
        // }
    }

    private static void init (BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        ret = -1;
        tree = new ArrayList<>(N);

        int num, left, right; // node number
        String data;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            data = st.nextToken();
            left = NO_NODE;
            right = NO_NODE;
            if(st.hasMoreTokens()){
                left = Integer.parseInt(st.nextToken());
            }
            if(st.hasMoreTokens()){
                right = Integer.parseInt(st.nextToken());
            }
            tree.add(new Node(data, num, left, right));
        }

        // System.out.println("-----------");
        // for(Node n : tree) System.out.println(n);
    }

    private static void solve() {
        // 트리의 모든 노드에 대하여
        boolean isLeaf, isOper;
        for (Node node : tree) {
            isLeaf = (node.left == NO_NODE && node.right == NO_NODE);
            isOper = (node.data.equals("+") || node.data.equals("-") || node.data.equals("/")|| node.data.equals("*"));

            // 리프노드라면 숫자
            // 리프노드가 아니라면 연산자
            if(isLeaf == isOper) {
                // 문제 있으면 ret = 0
                ret = 0;
                return;
            } 
        }
        // 문제 없으면 
        ret = 1;
    }

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        for(int tc = 1; tc <= 10; tc++) {
            init(br);
            solve();
            sb.append("#").append(tc).append(" ").append(ret).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

}