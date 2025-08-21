// 조합
// 반복문
// nCr에서 r이 고정되어있고 일반적으로 3중 for문을 넘지 않을 경우.
public class Combination1 {

    public static void main(String[] args) {

        for(int i=1; i<=4; i++){
            for(int j=i+1; j<=4; j++){
                for(int k=j+1; k<=4; k++){
                    System.out.println(i + ", " + j + ", " + k);
                }
            }
        }
    }
}