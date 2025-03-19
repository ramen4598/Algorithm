import java.util.Scanner;

public class BOJ2839 {

        public static void main(String [] args){
                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();


                if(n == 4 || n == 7){
                        System.out.println(-1);
                        return;
                }


                int cnt = 0;
                cnt = n /5;
                n %= 5;

                if(n == 1)  cnt += 1;
                else if(n==2) cnt += 2;
                else if(n==3) cnt += 1;
                else if(n==4) cnt += 2;


                System.out.println(cnt);
                sc.close();

        }

}
