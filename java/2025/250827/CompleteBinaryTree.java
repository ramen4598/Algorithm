// 트리
// 완전이진트리 - 배열 구현
// 고정된 크리를 가진다.

import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Queue;

public class CompleteBinaryTree<T> {

    private Object[] nodes;
    // private T[] nodes2;
    private final int SIZE;
    private int lastIndex;

    public CompleteBinaryTree(int size) {
        SIZE = size;
        nodes = new Object[size+1];
        // nodes2 = new T[size+1]; <- error
    }

    public boolean isEmpty() {
        return lastIndex == 0;
    }

    public boolean isFull() {
        return lastIndex == SIZE;
    }

    public void add(T e) {
        if(isFull()) {
            System.out.println("full");
            return;
        }
        lastIndex++;
        nodes[lastIndex] = e;
    }

    public void bfs() {
        if(isEmpty()) return;
        StringBuffer sb = new StringBuffer();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);

        int node;
        while(!queue.isEmpty()){
            node = queue.poll();
            sb.append(nodes[node]).append(" ");

            if(lastIndex >=  node*2) queue.offer(node*2);
            if(lastIndex >= node*2+1) queue.offer(node*2+1);
        }
        System.out.println(sb);
    }

    // 너비우선탐색 - 너비 단위로
    public void bfs2() {
        if(isEmpty()) return;
        StringBuffer sb = new StringBuffer();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);

        int node, cnt;
        while(!queue.isEmpty()){
            cnt = queue.size();
            while(cnt-- > 0){
                node = queue.poll();
                sb.append(nodes[node]).append(" ");

                if(lastIndex >=  node*2) queue.offer(node*2);
                if(lastIndex >= node*2+1) queue.offer(node*2+1);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // 전위순회
    public void dfs(int idx) {
        System.out.println(nodes[idx]);
        if(lastIndex >= idx*2) dfs(idx*2);
        if(lastIndex >= idx*2+1) dfs(idx*2+1);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size?");
        int size = sc.nextInt();
        CompleteBinaryTree<Integer> tree = new CompleteBinaryTree<>(size);

        for(int i=1; i<=size; i++){
            tree.add(i);
        }

        System.out.println("isEmpty : " + tree.isEmpty());
        System.out.println("isFull : " + tree.isFull());
        tree.bfs();
        tree.bfs2();
        tree.dfs(1);

        sc.close();
    }
}