import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
 
// 이 문제는 모든 노드가 서로 연결될 수 있는 완전 그래프다.
// 매우 많은 간선이 생길 수 있다. E = ((V-1)V)/2
// Kruskal으로 풀기 ->  시간 복잡도 O(ElogE + V) -> 간선이 많은 밀집 그래프에서 불리
// PQ로 구현한 Prim -> 시간 복잡도 O(ElogE) -> 간선이 많은 밀집 그래프에서 불리
// 반복문으로 구현한 Prim -> 시간 복잡도 O(E*V^2) -> 밀집 그래프에 유리!

// 반복문으로 구현한 Prim 알고리즘으로 풀기
// But! PQ로 구현한 Prim 알고리즘으로 풀면 더 빠르다! -> 가지치기의 효과

// PQ로 구현한 Prim
public class SWEA1251_2 {
    static int N;
    static long[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
//          x 좌표값
            N = sc.nextInt();
            int[] x = new int[N];
            for(int i = 0 ; i < N; i++) {
                x[i] = sc.nextInt();
            }
//          y 좌표값
            int[] y = new int[N];
            for(int i = 0 ; i < N; i++) {
                y[i] = sc.nextInt();
            }
             
            map = new long[N][N];
            for(int i = 0 ; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    map[i][j] = map[j][i] = getDistence(x[i],x[j], y[i],y[j]);
                }
            }
//          세율 입력
            double E = sc.nextDouble();
             
            System.out.println("#" + t + " " + Math.round(E * solve()));
             
             
        }
 
    }

    private static long solve() {
    	long ret = 0;
    	
    	PriorityQueue<Vertex> pq = new PriorityQueue<>();
    	boolean[] vis = new boolean[N];
    	
    	long[] D = new long[N]; // 트리 노드에 연결하기 위해서 필요한 비트리 노드의 비용
    	Arrays.fill(D,  Long.MAX_VALUE); // 초기화
    	D[0] = 0; // 임의의 정점을 시작점으로 설정. 비용을 0으로 설정

    	pq.offer(new Vertex(0, D[0]));
    	
    	// 가장 비용이 작은 비트리 노드를 선택
    	int cnt = 0;
    	Vertex cur;
    	while(!pq.isEmpty()) {
    		cur = pq.poll();
    		
    		if(vis[cur.no]) continue; // 이미 연결된 노드는 무시 
    		
    		vis[cur.no] = true; // 선택한 노드를 트리에 연결 
    		ret += cur.cost;
    		if(++cnt == N) break; // 모든 노드들이 트리에 연결된 상태
    		
    		for(int i=0; i<N; i++) {
    			if(vis[i]) continue;
    			if(map[cur.no][i] == 0) continue; // 생략 가능. 이 문제는 완전그래프
    			if(map[cur.no][i] < D[i]) {
    				D[i] = map[cur.no][i];
    				pq.offer(new Vertex(i, D[i])); // 현시점 최소 비용으로 i로 향하는 Vertex를 pq에 삽입
    			}
    		}
    	}

    	return ret;
    	//return (cnt == N) ? ret : -1; // 최소 신장 트리를 만들 수 없다면 -1 반환
    }

    private static long getDistence(int x1, int x2, int y1, int y2) {
        // TODO Auto-generated method stub
        return (long)(Math.pow((x1- x2),2 ) + Math.pow((y1- y2),2 ))  ;
    }

    // 정점 no로 향하는 가중치 cost인 간선 
    static class Vertex implements Comparable<Vertex>{
        int no;
        long cost;
        public Vertex(int no, long cost) {
            super();
            this.no = no;
            this.cost = cost;
        }
        @Override
        public int compareTo(Vertex o) {
            // TODO Auto-generated method stub
            return Long.compare(cost, o.cost);
        }
         
    }
 
}