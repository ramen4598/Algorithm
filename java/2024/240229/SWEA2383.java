import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class SWEA2383 {
	
	static int N, min;	
	static List<int[]> persons, entrys; // 사람들의 좌표, 입구 좌표를 저장
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();

		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++){
			init(br, st);

			// 부분 집합
			makeSubset(0, new int[persons.size()]);
			//go(new int[]{0,0,0,1,1,1}, true);

			// 출력
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}

		System.out.println(sb);
		br.close();		
	}

	static void init(BufferedReader br, StringTokenizer st) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;	

		// persons, entrys 초기화 
		int input;
		persons = new ArrayList<>();
		entrys = new ArrayList<>();
		for(int i=0; i<N; i++){ 
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++){
				input = Integer.parseInt(st.nextToken());
				if(input == 0) continue;
				if(input == 1){ // 사람
					persons.add(new int[]{i,j});
				}else{ // 계단
					entrys.add(new int[]{i, j, input});
				}
			}
		}

		// Debug
		// System.out.println("persons");
		// for(int[] arr : persons)
		// 	System.out.println(Arrays.toString(arr));
		// System.out.println("entrys");
		// for(int[] arr : entrys)
		// 	System.out.println(Arrays.toString(arr));
	}

	// 모든 사람들이 향할 계단을 선택한다.	(2개 중 1개)
	static void makeSubset(int depth, int[] subset){
		if(depth == subset.length){
			// Debug
			//System.out.println(Arrays.toString(subset));
			min = Math.min(min, go(subset, false)); // 이동하는데 필요한 시간을 계산한다.
			return;
		}

		subset[depth] = 1; //
		makeSubset(depth+1, subset);
		subset[depth] = 0; //
		makeSubset(depth+1, subset);
	}

	static int go(int[] subset, boolean debug){
		if(debug) System.out.println("subset : " + Arrays.toString(subset));
		int res = 0;
		// 윗층
		ArrayList<Person> up = new ArrayList<>();
		for(int i=0; i<subset.length; i++){
			up.add(new Person(setTime(entrys.get(subset[i]), persons.get(i)), subset[i]));
		}
		// 계단
		ArrayList<Person> st0 = new ArrayList<>();
		ArrayList<Person> st1 = new ArrayList<>();

		while(true){
			if(up.isEmpty() && st0.isEmpty() && st1.isEmpty()) break;
			res++;
			Person  p;
			// K분 후에는 계단을 내려간다.
			for(int i=st0.size()-1; i>=0; i--){
				p = st0.get(i);
				p.time--;
				if(p.time == 0){
					st0.remove(i);
				}
			}
			for(int i=st1.size()-1; i>=0; i--){
				p = st1.get(i);
				p.time--;
				if(p.time == 0){
					st1.remove(i);
				}
			}

			// 계단으로 이동한다.
			ArrayList<Person> s = null;
			for(int i=up.size()-1; i>=0; i--){
				p = up.get(i);
				p.time--;
				// 도착 1분 후 부터 계단에 진입할 수 있다.
				if(p.time < 0){
					if(p.stair == 0) s = st0;
					if(p.stair == 1) s= st1;
					if(s.size() == 3) continue; // 계단에는 3명만 올라갈 수 있다.
					p.time = entrys.get(p.stair)[2]; // 각 계단을 내려가기 위한 시간으로 설정. 
					s.add(p);
					up.remove(i);
					continue;
				}
			}
			//Debug
			if(debug){
				System.out.println("------------" + res);
				System.out.println("up");
				for(Person tmp : up){
					System.out.print(tmp.time + " ");
				}
				System.out.println();
				System.out.println("st0");
				for(Person tmp : st0){
					System.out.print(tmp.time + " ");
				}
				System.out.println();
				System.out.println("st1");
				for(Person tmp : st1){
					System.out.print(tmp.time + " ");
				}
				System.out.println();
			}
		}
		return res;
	}

	static int setTime(int[] st, int[] yx){
		return Math.abs(st[0] - yx[0]) + Math.abs(st[1] - yx[1]);
	}

	static class Person {
		int time; // 다음 행동까지 남은 시간
		int stair; // 이용할 계단

		Person(int time, int stair){
			this.time = time;
			this.stair = stair;
		}
	}
}

