import java.io.*;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
// import java.util.Arrays;

public class BOJ1713 {

    static int N, M; // 액자, 투표수
    static int[] input;
    static PriorityQueue<Student> pq;

    private static class Student implements Comparable<Student> {

        int num; // 학생번호
        // int last; // 최근 추천받은 순서
        int opened; // 게시된 순서
        int cnt; // 추천수

        public Student (int num, int opened, int cnt) {
            this.num = num;
            // this.last = last;
            this.opened = opened;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Student o) {
            // 정렬 순서 : 추천수 -> 게시된 순서
            return (this.cnt == o.cnt) ? this.opened - o.opened : this.cnt - o.cnt;
        }

        @Override
        public String toString() {
            return "[Student : " + this.num + ", " + this.opened + ", " + this.cnt + "]";
        }
    }

    private static void init(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        input = new int[M];
        pq = new PriorityQueue<>(N);        

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        } 

        // System.out.println(Arrays.toString(input));
    }

    private static void solve() {
        label : for(int i=0; i<M; i++) {
            // System.out.println("-------------");
            // for(Student st : pq){
            //     System.out.println(st);
            // }
            // System.out.println("-> " + input[i]);

            // 기존에 있음
            for(Student st : pq) {
                if(st.num == input[i]){
                    Student tmp = new Student(st.num, st.opened, st.cnt+1);
                    pq.remove(st);
                    pq.add(tmp);
                    continue label;
                }
            }

            // 기존에 없음
            if(pq.size() >= N) { // 액자가 가득참
                pq.poll();
            }
            pq.offer(new Student(input[i], i, 1));
        }
    }

    private static void print() {
        List<Integer> ret = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        Student cur;
        while(!pq.isEmpty()){
            cur = pq.poll();
            ret.add(cur.num);
        }
        Collections.sort(ret);
        for(int j : ret) sb.append(j).append(" ");
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
        solve();
        print();
        br.close();
    }

}