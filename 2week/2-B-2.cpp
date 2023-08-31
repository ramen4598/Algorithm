//백준 1012: 유기농 배추
#include <iostream>

using namespace std;

const int max_n = 50;
const int max_m = 50;
const int dy[] ={-1, 0, 1, 0};
const int dx[] ={0, 1, 0, -1};
int t, n, m, k;

void dfs(int y, int x, int a[][max_m], int visited[][max_m]){
	visited[y][x] = 1;
	for(int i=0; i<4; i++){
		int ny = y + dy[i];
		int nx = x + dx[i];
		bool underflow = ny < 0 || nx < 0;
		bool overflow = ny >= n || nx >= m;
		if(underflow || overflow) continue;
		if(a[ny][nx]==1 && !visited[ny][nx]){
			dfs(ny, nx, a, visited);
		}
	}
	return;
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> t;
	for(int test_case = 1; test_case <= t; test_case++){
		int ret = 0;
		int a[max_n][max_m], visited[max_n][max_m];
		fill(&a[0][0], &a[0][0] + max_n * max_m, 0);
		fill(&visited[0][0], &visited[0][0] + max_n * max_m, 0);
		cin >> m >> n >> k;
		for(int i=0; i<k; i++){
			int x, y;
			cin >> x >> y;
			a[y][x]=1;
		}	

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(a[i][j]==1 && !visited[i][j]){
					ret++; 
					dfs(i,j,a,visited);
				}
			}	
		}
		cout << ret << "\n";
	}

	return 0;
}
