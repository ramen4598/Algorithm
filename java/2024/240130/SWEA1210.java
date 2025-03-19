import java.io.*;
import java.util.*;

class SWEA1210 {

	static char[][] map;
	static int[] point;
	static int size;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 

		for(int tc=1; tc <=10; tc++){
			st = new StringTokenizer(br.readLine());
			map = new char[100][100];
			point = new int[100];
			size=0;
			int cur = -1;

			for(int y=0; y<99; y++){
				st = new StringTokenizer(br.readLine());
				for(int x=0; x<100; x++){
					map[y][x] = st.nextToken().charAt(0);
				}
			}

			//시작점과 도착점 찾기
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<100; x++){
				map[99][x] = st.nextToken().charAt(0);
				if(map[99][x] == '2'){
					point[size]= x;
					cur = size;
					size++;
				}else if(map[99][x]=='1'){
					point[size]= x;
					size++;
				}
			}

			int ret = find(cur);
			System.out.printf("#%d %d%n", tc, ret);
		}
	}

	static int find(int cur){
		int line = point[cur];

		int idx = 100;
		while(idx>0){
			idx--;
			//left
			boolean underflow = line < 1; 
			if(!underflow && map[idx][line-1]=='1'){
				cur--;
				line = point[cur];
				continue;
			}		
			//right
			boolean overflow = line > 98;
			if(!overflow && map[idx][line+1]=='1'){
				cur++;
				line = point[cur];
				continue;
			}
		}

		return line;
	}
}
