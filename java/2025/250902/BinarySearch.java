// 이진 탐색
// Java.util.Arrays.binarySearch를 사용해도 된다.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BinarySearch {

    static int size, key;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        System.out.println("size?");
        st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        arr = new int[size];

        System.out.println("Input numbers. Sorted in ascending order.");
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        } 
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("Find what?");
        st = new StringTokenizer(br.readLine());
        key = Integer.parseInt(st.nextToken());

        int ret = binarySearch(arr, key);
        // int ret = Arrays.binarySearch(arr, key);
        if(ret > -1)
            System.out.println("index : " + ret + " value : " + arr[ret]);
        else
            System.out.println("index : " + ret + " fail");

        br.close();
    }

    private static int binarySearch(int[] arr, int key){
        if(arr.length == 0)
         throw new IndexOutOfBoundsException("Empty array.");

        int start, mid, end;
        start = 0;
        end = arr.length - 1;

        int cur;
        while(start <= end){
            mid = (start +  end) / 2;
            cur = arr[mid];
            if(cur == key) {
                return mid;
            }

            if(key < cur){ // down
                end = mid - 1;
            }else if(cur < key){ // up
                start = mid + 1;
            }
        }

        return -1;
    }
}
