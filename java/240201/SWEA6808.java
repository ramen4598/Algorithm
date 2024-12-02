import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SWEA6808 {

	static int win, lose, score1, score2;
	static int[] p1, p2, per; // 규영이 카드, 인영이 카드, 인영이가 내는 카드 순열
	static boolean[] vis, vis2; // 규영이가 받은 카드, 인영이 순열 생성에 사용하는 방문체크
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());

			win = 0; lose = 0; score1 = 0; score2 = 0;
			p1=new int[9];
			p2=new int[9];
			per=new int[9];
			vis = new boolean[19];
			vis2= new boolean[9];
			
			// 규영이 카드 입력
			for(int i=0; i<9; i++) {
				int num = Integer.parseInt(st.nextToken());
				p1[i] =	num;
				vis[num] = true; 
			}
			
			// 인영이 카드 구하기
			int idx = 0;
			for(int i=1; i<=18; i++) {
				if(idx>8) continue;
				if(vis[i]) continue;
				p2[idx] = i;
				idx++;
			}
			
			solve(0);
			
			System.out.printf("#%d %d %d%n", tc, win, lose);
		}
		br.close();
	}
	
	// 인영이 카드 순열 만들기
	public static void solve(int depth) {
		if(depth==9) {
			cal(); // 점수 계산
			if(score1 > score2) win++; // 규영 승
			if(score1 < score2) lose++; // 규영 패배
			return;
		}
		
		for(int i=0; i<9; i++) {
			if(vis2[i]) continue; // 담았다면 통과

			per[depth] = p2[i];
			vis2[i] = true; // 담기
			solve(depth+1);

			vis2[i] = false; // 복구
		}
		

	}
	
	// 인여이 카드 순열에 따른 둘의 점수
	public static void cal() {
		score1 = 0; score2 = 0; // 점수 초기화
		for(int i=0; i<9; i++) {
			if(p1[i] > per[i]) score1 += p1[i] + per[i]; // 규영 승
			if(p1[i] < per[i]) score2 += p1[i] + per[i]; // 인영 승
		}
	}

}
