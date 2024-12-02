//백준 1012: 유기농 배추
#include <iostream>
#include <cstring> // memeset

using namespace std;

const int max_n = 50;
const int max_m = 50;
const int dy[] ={-1, 0, 1, 0};
const int dx[] ={0, 1, 0, -1};
int a[max_n][max_m], visited[max_n][max_m];
int t, n, m, k;

void dfs(int y, int x){
	visited[y][x] = 1;
	for(int i=0; i<4; i++){
		int ny = y + dy[i];
		int nx = x + dx[i];
		bool underflow = ny < 0 || nx < 0;
		bool overflow = ny >= n || nx >= m;
		if(underflow || overflow) continue;
		if(a[ny][nx]==1 && !visited[ny][nx]){
			dfs(ny, nx);
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
		memset(a, 0, sizeof(a)); 
		memset(visited, 0, sizeof(visited));
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
					dfs(i,j);
				}
			}	
		}
		cout << ret << "\n";
	}

	return 0;
}
