import java.util.Scanner;

public class SWEA5215
{
	static final int MAXN = 20;
	static int n, l, ret;
	static int[] t = new int[MAXN]; 
	static int[] k = new int[MAXN];

	public static void solve(int depth, int score, int cal){
		if(depth == n){
			if(cal <= l && score > ret){
				ret = score;
			}
			return;
		}
		if(cal > l) return;
		
		score+=t[depth];
		cal+=k[depth];
		solve(depth+1, score, cal);

		score-=t[depth];
		cal-=k[depth];
		solve(depth+1, score, cal);
		return;
	}

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc <= T; tc++){
			ret = 0;
			n = sc.nextInt();
			l = sc.nextInt();
			
			for(int i=0; i<n; i++){
				t[i] = sc.nextInt();
				k[i] = sc.nextInt();
			}

			solve(0,0,0);
			System.out.println("#" + tc + " " + ret);
		}
		sc.close();
	}
}
