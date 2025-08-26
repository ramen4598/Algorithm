// 분할 정복 : Power
// x^n을 O(logN) 시간복잡도로 구하는 분할 정복 알고리즘

import java.util.Scanner;

public class Power {

    static int callCnt;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(power(x,n));
        System.out.println(callCnt);
        sc.close();
    }

    private static long power(int x, int n){
        callCnt++;
        if(n==1) return x;

        int half = n/2;
        long res = power(x, half);
        res *= res;

        return (n&1)==1 ? res*x : res;
    }
    
}
