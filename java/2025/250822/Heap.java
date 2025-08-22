// Heap
// 빠르게 최대 혹은 최소 값을 구하고 싶을 때. Priority Queue를 구현할 경우.
// 시간복잡도 : 삽입 O(logN), 삭제(logN)

import java.util.ArrayList;
import java.util.Scanner;

// 최소힙 
public class Heap {

    private ArrayList<Integer> heap;

    public Heap() {
        heap = new ArrayList<>();
        heap.add(0); // 0번째 인덱스는 사용하지 않음
    }

    // 삽입
    public void insert(int val) {
        heap.add(val);
        int p = heap.size() - 1; // 0번 인덱스 제외
        while(p > 1 && heap.get(p/2) > heap.get(p)){
            // 새로 삽입한 노드가 부모보다 작으면 교환
            int parent = p/2;
            int tmp = heap.get(parent);
            heap.set(parent, val);
            heap.set(p, tmp);
            p /= 2;
        }
    }

    // 삭제
    public int delete(){
        // heap 비어있으면 -1 반환
        if(heap.size() < 2) return -1;

        int deleteitem = heap.get(1);

        // 마지막 노드를 root에 삽입
        heap.set(1, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int parentPos = 1, childPos, left, right, child, parent;
        while(heap.size() > (parentPos*2)){
            parent = heap.get(parentPos);
            left = parentPos*2; // 왼쪽
            right = left + 1; // 오른쪽
            childPos = left;
            child = heap.get(left);

            // 오른쪽이 왼쪽 자식보다 더 작으면 오른쪽과 부모 비교
            // boolean isRightExist = (right) <= heap.size()-1;
            boolean isRightExist = (right) < heap.size();
            if(isRightExist && child > heap.get(right)){
                childPos = right;
                child = heap.get(right);
            }

            // 힙 정렬 종료
            if(child > parent) break;

            // 교환
            heap.set(parentPos, child);
            heap.set(childPos, parent);
            parentPos = childPos;
        }
        return deleteitem;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Heap heap = new Heap();

        int input;
        String menu = """
                ---------
                0) exit
                1) insert
                2) delete
                ---------
                """;
        while(true){
            System.out.println(menu);
            input = sc.nextInt();
            if(input == 0) break;
            switch (input) {
                case 1:
                    System.out.println("value?");            
                    heap.insert(sc.nextInt());
                    break;
                case 2:
                    System.out.println("delete " + heap.delete());
                    break;
                default:
                    System.out.println("Invalid menu!");
                    break;
            }
        }

        sc.close();
    }
}
