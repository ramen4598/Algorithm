// 부분집합
// 반복문
// 정해진 r을 가진 nHr. 일반적으로 r은 3 이하.

public class Subset1 {

    static int[] selected;

    public static void main(String[] args) {

        // 1, 2, 3으로 만들 수 있는 모든 부분집합
        selected = new int[4];
        for(int i=1; i>=0; i--) {
            selected[1] = i;
            for(int j=1; j>=0; j--) {
                selected[2] = j;
                for(int k=1; k>=0; k--) {
                    selected[3] = k;
                    for(int m = 1; m <= 3; m++) {
                        if(selected[m] == 1) 
                            System.out.print(m + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
    
}
