import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// 벽돌 깨기
public class SWEA5656_2 { //

	static int N, W, H, ret; // 구술을 쏘는 횟수, 가로, 세로
	static int[][] map;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	static class Point{
		int y, x;
		
		Point(int y, int x){
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Point y : " + y + ", x : " + x;
		}
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuffer sb = new StringBuffer();
    	
    	int T = Integer.parseInt(st.nextToken());
        for(int tc=1; tc<=T; tc++) {
        	init(br, st);
        	solve(N, map);
        	sb.append("#").append(tc).append(" ").append(ret).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    static void init(BufferedReader br, StringTokenizer st) throws Exception {
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	W = Integer.parseInt(st.nextToken());
    	H = Integer.parseInt(st.nextToken());
    	ret = Integer.MAX_VALUE;
    	
    	map = new int[H][W];
    	for(int y=0; y<H; y++) {
    		st = new StringTokenizer(br.readLine());
    		for(int x=0; x<W; x++) {
    			map[y][x] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	// debug
    	//for(int[] arr : map) System.out.println(Arrays.toString(arr));
    }

    // 중복 순열
    static void solve(int depth, int[][] m){
    	if(depth == 0) {
    		ret = Math.min(ret, count(m));
    		return;
    	}

    	for(int i=0; i<W; i++) {
    		solve(depth-1, go(i, m));
    	}
    }
    
    static int[][] go(int i, int[][] m){
    	// copy origin
    	int[][] copy = copy(m);
    	// find a block on top
    	Point point =  find(i, copy);
    	// break block
    	breakBlock(point, copy);
    	// 빈 공간이 있을 경우 벽돌은 밑으로 떨어지게 된다.
    	drop(copy);
    	//debug
    	//System.out.println("-----------------------");
    	//System.out.println("before : "+i);
    	//for(int[] arr : m) 
    	//	System.out.println(Arrays.toString(arr));
    	//System.out.println("-----------------------");
    	//System.out.println("after : "+i);
    	//for(int[] arr : copy) 
    	//	System.out.println(Arrays.toString(arr));
		return copy;
    }
    
    // find a block on top
    static Point find(int i, int[][] m) {
    	for(int y=0; y<H; y++) {
    		if(m[y][i]==0) continue;
    		return new Point(y, i);
    	}
    	return new Point(0,i);
    }
    
    static int[][] copy(int[][] origin){
    	int[][] copy = new int[H][W];
    	for(int y=0; y<H; y++) {
    		for(int x=0; x<W; x++) {
    			copy[y][x] = origin[y][x];
    		}
    	}
    	return copy;
    }
    
    static void breakBlock(Point point, int[][] copy) {
    	Queue<Point> q = new ArrayDeque<>();
    	q.offer(point);
    	Point cur;
    	while(!q.isEmpty()) {
    		cur = q.poll();
    		int num = copy[cur.y][cur.x];
    		copy[cur.y][cur.x] = 0; // 블록 파괴
    		int ny, nx;
    		for(int d = 0; d<4; d++) {
    			for(int i=1; i<num; i++) {
    				ny = cur.y + dy[d]*i;
    				nx = cur.x + dx[d]*i;
    				if(ny<0||nx<0||ny>=H||nx>=W) continue;
    				if(copy[ny][nx] == 0) continue;
    				q.offer(new Point(ny, nx)); // 연쇄작용
    			}
    		}
    	}
    }
    
    static void drop(int[][] m) {
    	// 빈 공간이 있을 경우 벽돌은 밑으로 떨어지게 된다.
    	Stack<Integer> stk = new Stack<>();
    	for(int x=0; x<W; x++) {
    		stk.clear();
    		// push all
    		for(int y=0; y<H; y++) {
    			if(m[y][x]==0)continue;
    			stk.push(m[y][x]);
    			m[y][x]=0;
    		}
    		// pop all
    		int ny = H-1;
    		while(!stk.isEmpty()) {
    			m[ny][x] = stk.pop();
    			ny--;
    		}
    	}
    }
    
    // 남은 벽돌을 센다
    static int count(int[][] m) {
    	int cnt = 0;
    	for(int[] arr : m) {
    		for(int i : arr) {
    			if(i != 0) cnt++;
    		}
    	}
    	return cnt;
    }

}