// 조합
// 재귀함수
// 일반적인 경우. 가지치기를 통해서 시간을 명확하게 아낄 수 있는 조합 구현.
// 시간복잡도 : O(nCk)

// 3 1
// 3 2
// 3 3
// 3 4

import java.util.Scanner;
import java.util.Arrays;

public class Combination2 {
    
    static int N; // 주사위 던지는 횟수
    static int[] numbers;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        numbers = new int[N];
        int mode = sc.nextInt();

        switch(mode) {
            case 1 : // 중복순열
                dice1(0);
                break;
            case 2 : // 순열
                visited = new boolean[7];
                dice2(0);
                break;
            case 3 : // 중복조합
                dice3(0, 1);
                break;
            case 4 : // 조합
                dice4(0, 1);
                break;
        }
        sc.close();
    }

    // 중복순열
    private static void dice1(int idx) {
        if(idx == N){
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for(int i=1; i<7; i++){
            numbers[idx] = i; 
            dice1(idx+1);
        }
    }

    // 순열
    private static void dice2(int idx) {
        if(idx == N){
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for(int i=1; i<7; i++){
            if(visited[i]) continue;
            visited[i] = true;
            numbers[idx] = i; 
            dice2(idx+1);
            visited[i] = false;
        }
    }

    // 중복조합
    private static void dice3(int idx, int start) {
        if(idx == N){
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for(int i = start; i < 7; i++){
            numbers[idx] = i;
            dice3(idx+1, i);
        }
    }
    
    // 조합
    private static void dice4(int idx, int start) {
        if(idx == N){
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for(int i = start; i < 7; i++){
            numbers[idx] = i;
            dice4(idx+1, i+1);
        }
    }
}
