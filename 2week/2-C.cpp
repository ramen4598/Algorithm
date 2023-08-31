//백준 2468번: 안전 영역
#include <iostream>
#include <cstring>

using namespace std;

const int max_n = 100;
int n, max_h=0, ret=0; 
int a[max_n][max_n]={{0}}, visited[max_n][max_n]={{0}};
int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};

void dfs(int y,int x, int h){
	visited[y][x] = 1;
	for(int i=0; i<4; i++){
		int ny = y + dy[i];
		int nx = x + dx[i];
		bool underflow = ny < 0 || nx < 0;
		bool overflow = n <= ny || n <= nx; 
		if(underflow || overflow) continue;
		if(a[ny][nx] > h && !visited[ny][nx]){
			dfs(ny, nx, h);
		}
	}
	return;
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> n;
	for(int y=0; y<n; y++){
		for(int x=0; x<n; x++){
			int tmp;
			cin >> tmp;
			if(max_h < tmp) max_h = tmp;	
			a[y][x] = tmp;
		}
	}
	for(int h=1; h<= max_h; h++){
		int cnt = 0;
		memset(visited, 0, sizeof(visited));
		//또는 
		//fill(&visited[0][0], &visited[0][0] + 101 * 101, 0);
		for(int y=0; y<n; y++){
			for(int x=0; x<n; x++){
				if(a[y][x] > h && !visited[y][x]){
					cnt++;
					dfs(y, x, h);
				}
			}
		}
		if(ret < cnt) ret = cnt;
		//ret = max(ret, cnt);
	}	
	cout << ret << "\n";

	return 0;
}
