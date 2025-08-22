// 링크드 리스트
import java.util.Scanner;

public class LinkedList {

    private class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    private Node head;

    // 인덱스는 0부터 시작.
    // 인덱스 위치에 새로운 노드 삽입. 
    public void add(int idx, int data) {
        if(idx < 0) {
            throw new IndexOutOfBoundsException("Invalid index: " + idx);
        }

        Node newNode = new Node(data);

        if(idx == 0){
            newNode.next = head;
            head = newNode;
            return;
        }

        Node previous = head;
        // idx == 3 -> previous의 인덱스는 2
        for(int i=0; i<idx - 1; i++){ // 삽입할 위치 앞의 노드 찾기
            if(previous == null){
                throw new IndexOutOfBoundsException("Invalid index: " + idx);
            }
            previous = previous.next;
        }

        if(previous == null){
            throw new IndexOutOfBoundsException("Invalid index: " + idx);
        }

        newNode.next = previous.next;
        previous.next = newNode;
    }

    // 지정된 인덱스에 위치한 노드 삭제
    public void remove(int idx) {
        if(idx < 0) {
            throw new IndexOutOfBoundsException("Invalid index: " + idx);
        }

        if(idx == 0){
            if(head == null) {
                throw new IndexOutOfBoundsException("Invalid index: " + idx);
            }
            head = head.next;
            return;
        } 

        Node previous = null;
        Node target = head;
        for(int i=0; i<idx; i++){
            if(target == null){
                throw new IndexOutOfBoundsException("Invalid index: " + idx);
            }
            previous = target;
            target = target.next;
        }

        if(target == null){
            throw new IndexOutOfBoundsException("Invalid index: " + idx);
        }
        previous.next = target.next;
    }

    public int get(int idx) {
        if(idx < 0) {
            throw new IndexOutOfBoundsException("Invaild index: " + idx);
        }

        Node target = head;
        for(int i=0; i<idx; i++) {
            if(target == null) {
                throw new IndexOutOfBoundsException("Invaild index: " + idx);
            }
            target = target.next;
        }

        if(target == null) {
            throw new IndexOutOfBoundsException("Invaild index: " + idx);
        }
        return target.data;
    }

    public void set(int idx, int data) {
        if(idx < 0) {
            throw new IndexOutOfBoundsException("Invaild index: " + idx);
        }

        Node target = head;
        for(int i=0; i<idx; i++) {
            if(target == null) {
                throw new IndexOutOfBoundsException("Invaild index: " + idx);
            }
            target = target.next;
        }

        if(target == null) {
            throw new IndexOutOfBoundsException("Invaild index: " + idx);
        }
        target.data = data;
    }

    public void display() {
        StringBuffer sb = new StringBuffer();
        Node current = head;
        while(current != null){
            sb.append(current.data).append(" ");
            current = current.next;
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();

        while(true){
            int input;
            String menu = """
                    ----------
                    0) exit
                    1) add
                    2) remove
                    3) get
                    4) set
                    5) display
                    ----------
                    """;
            System.out.println(menu);

            input = sc.nextInt();

            if(input == 0) break;

            int idx, data;
            switch (input) {
                case 1: // add
                    System.out.println("type index.");
                    idx = sc.nextInt();
                    System.out.println("type data.");
                    data = sc.nextInt();
                    linkedList.add(idx, data);
                    break;
                case 2: // remove
                    System.out.println("type index.");
                    idx = sc.nextInt();
                    linkedList.remove(idx);
                    break;
                case 3: // get
                    System.out.println("type index.");
                    idx = sc.nextInt();
                    System.out.println(linkedList.get(idx));
                    break;
                case 4: // set
                    System.out.println("type index.");
                    idx = sc.nextInt();
                    System.out.println("type data.");
                    data = sc.nextInt();
                    linkedList.set(idx, data);
                    break;
                case 5: // display
                    linkedList.display();
                    break;
                default:
                    System.out.println("Invalid memu!");
                    break;
            }
        }
        sc.close();
    }

}