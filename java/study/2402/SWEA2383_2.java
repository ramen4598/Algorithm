import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA2383_2 {
    
    static int N, M, K;
    static int[] dy = {0, -1, 1, 0, 0};
    static int[] dx = {0, 0, 0, -1, 1};
    static Cell[] list;
    static List<Cell>[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(st.nextToken());
        for(int tc=1; tc<=T; tc++){
            init(br, st);
            solve();
            sb.append("#").append(tc).append(" ").append(count()).append("\n");
        }

        System.out.println(sb);
        br.close();
    }


    private static void init(BufferedReader br, StringTokenizer st) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 미생물 초기화
        map = new List[N][N];
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		map[i][j] = new ArrayList<Cell>();
        	}
        }
        int y,x,c,d;
        Cell cell;
        list = new Cell[K];
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            cell = new Cell(y, x, c, d);
            list[i] = cell;
            map[y][x].add(cell);
        }
    }

    private static void solve(){
        for(int i=0; i<M; i++){
            for(Cell cell : list){
                cell.move(); // 움직이고
            }
            merge();    // 한 곳에서 만나는 경우 처리
        }
    }

    private static int count() {
        int count = 0;
        for(int i=0; i<K; i++){
            count += list[i].cnt;
        }
        return count;
    }

    /*
    private static void merge() {
    	ArrayList<Integer> tmp;
    	for(int i=0; i<K; i++) {
    		if(list[i].cnt<1) continue;
    		tmp = new ArrayList<>();
    		
    		// 가장 큰 미생물 찾기
    		int idx = i;
    		for(int j=i; j<K; j++) {
    			if(list[j].cnt<1) continue;
    			if(list[i].y != list[j].y || list[i].x != list[j].x) continue;
    			if(list[idx].cnt < list[j].cnt) idx = j;
    			tmp.add(j);
    		}
    		
    		// cnt 갱신
    		for(Integer num : tmp) {
    			if(num == idx) continue;
    			list[idx].cnt += list[num].cnt;
    			list[num].cnt = 0;
    		}
    	}
    }
    */
    
    private static void merge() {
    	int end = N-1;
    	for(int y=1; y<end; y++) {
    		for(int x=1; x<end; x++) {
    			if(map[y][x].size() < 2) continue;
    			
    			// 가장 큰 미생물 찾기
    			int idx = 0;
    			for(int i=1; i<map[y][x].size(); i++) {
    				if(map[y][x].get(idx).cnt < map[y][x].get(i).cnt) {
    					idx = i;
    				}
    			}
    			
    			for(int i=0; i<map[y][x].size(); i++) {
    				if(idx == i) continue;
    				map[y][x].get(idx).cnt += map[y][x].get(i).cnt;
    				map[y][x].get(i).cnt = 0;
    			}
    		}
    	}
    }

    private static class Cell {
        int y, x;
        int cnt;
        int dir;

        Cell(int y, int x, int cnt, int dir){
            this.y = y;
            this.x = x;
            this.cnt = cnt;
            this.dir = dir;
        }

        public void move(){
            // 이미 죽은 미생물입니다.
            if(cnt<1) return;
            
            // y, x 갱신
            map[y][x].remove(this);
            this.y += dy[dir];
            this.x += dx[dir];
            map[y][x].add(this);

            // 경계선 확인
            if(y==0 || x==0 || y == N-1 || x == N-1){
                cnt/=2;
                switch (dir) {
                    case 1:
                        dir = 2;       
                        break;
                    case 2:
                        dir = 1;       
                        break;
                    case 3:
                        dir = 4;       
                        break;
                    case 4:
                        dir = 3;       
                        break;
                }
                if(cnt < 1) map[y][x].remove(this);
            }
        }
    }
}
