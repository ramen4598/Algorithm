import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4012 {

	static int N, R, ret; // 식재료 숫자, 음식 간의 최소 차이
	static int A, B; // A음식, B음식
	static int[][] map; // 조합 시너지
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++) {
			
			//초기화
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = N/2;
			ret = Integer.MAX_VALUE;
			map = new int[N][N];

			// 조합 시너지 저장
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 조합 생성 nCr. r=n/2.
			int[] P = new int[N];
			for(int i=0; i<R; i++) {
				P[N-1-i] = 1;
			}
			do {
				//System.out.println(Arrays.toString(P));
				A = 0; B = 0;
				for(int i=0; i<N; i++) { // 시너지 계산
					for(int j=0; j<N; j++) {
						if(P[i] == P[j]) {  // 같은 음식이면
							if(P[i]==0) A += map[i][j];
							else B += map[i][j]; 
						}
					}
				}
				int num = Math.abs(A-B); // A, B 간의 시너지 차이 최소 값 구하기
				//System.out.println(num);
				ret = Math.min(ret, num);
			}while(next_Permutation(P));
			
			sb.append("#").append(tc).append(" ").append(ret).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
	public static boolean next_Permutation (int[] P) {
		int last = P.length - 1;
		int i = last;
		while(i>0 && P[i-1] >= P[i]) --i;
		if(i==0) return false;
		
		int j = last;
		while(P[i-1] >= P[j]) --j;
		
		swap(P, i-1, j);
		
		int k = last;
		while(i<k) swap(P, i++, k--);
		
		return true;
	}
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
