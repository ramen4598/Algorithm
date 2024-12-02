import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JOL1183 {
	static int W, allMoney, useCnt;
	static int[] cnt, ret;
	static final int[] coins = { 500, 100, 50, 10, 5, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		allMoney = 0; useCnt=0;
		cnt = new int[6];
		ret = new int[6];
		
		W = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<6; i++) {
			cnt[i] = Integer.parseInt(st.nextToken());
			allMoney += cnt[i] * coins[i];
		}

		solve();
		
		StringBuffer sb = new StringBuffer();
		//사용된 동전의 수
		sb.append(useCnt).append("\n");
		for(int i : ret) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void solve() {
		int notUseCnt;
		int other = allMoney - W;
		// 사용하지 않는 동전이 최소가 되도록
		for(int i=0; i<6; i++){
			notUseCnt = other/coins[i];
			if(notUseCnt > cnt[i]) notUseCnt = cnt[i];
			ret[i] = cnt[i] - notUseCnt;
			useCnt += ret[i];
			other -= coins[i]*notUseCnt;
		}
	}
}
