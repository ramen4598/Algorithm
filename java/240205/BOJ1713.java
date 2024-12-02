import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1713 {
    
    static int N;
    static PriorityQueue<Student> frame = new PriorityQueue<>();
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        solve();
        print();
    }

    static void solve() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 사진틀 개수

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 추천 횟수

        st = new StringTokenizer(br.readLine());
        br.close();

        // 시뮬레이션
        int num;
        boolean isExist;
        for(int i=0; i<M; i++){
            num = Integer.parseInt(st.nextToken());
        	isExist = false;
            Student target = null;

            // 이미 액자에 있는지 확인 
            for(Student student : frame){
                if(student.num == num){
                	target = student;
                    isExist = true;
                    break;
                }
            }

            if(isExist) { // 액자에 있는 학생 추천
                frame.remove(target);
                target.cnt++;
                //target.cur=i; <- 게시된 시간을 갱신하면 안된다!
                frame.offer(target);
            }else { // 액자에 없는 학생 추천
            	target = new Student(num, 1, i);
            	if(frame.size() >= N) { // frame 자리에 여유가 없는 경우
            		frame.poll();
            	}
            	frame.offer(target);
            }
            
            // debug
            //PriorityQueue<Student> tmp = new PriorityQueue<>(frame);
            //while(!tmp.isEmpty()) {
            //	System.out.print(tmp.poll().num+" ");
            //}
            //System.out.println();
        }
        
    }

    static void print(){
        List<Integer> output = new ArrayList<>();
        while(!frame.isEmpty()) {
            output.add(frame.poll().num);
        }
        Collections.sort(output);

        StringBuffer sb = new StringBuffer();
        for(int i : output){
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
    

    static class Student implements Comparable<Student> {
        int num;
        int cnt;
        int cur;
        
        Student (int num, int cnt, int cur){
            this.num = num;
            this.cnt = cnt;
            this.cur = cur;
        }

        @Override
        public int compareTo(Student o) {
            Student other = (Student) o;
            if(this.cnt==other.cnt){
                return Integer.compare(this.cur, other.cur);
            }
            return Integer.compare(this.cnt, other.cnt);
        }

    }
}