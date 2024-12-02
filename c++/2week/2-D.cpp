// 백준 2583: 영역 구하기
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

const int mn = 100;
int m, n, k, ret=0, area, a[mn][mn], visited[mn][mn];
int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};
vector<int> v;

void dfs(int y, int x){
	visited[y][x] = 1;
	area++;
	for(int i=0; i<4; i++){
		int ny = y + dy[i];
		int nx = x + dx[i];
		bool underflow = ny < 0 || nx < 0;
		bool overflow = m <= ny || n <= nx;
		if(underflow || overflow) continue;
		if(a[ny][nx] == 1 && !visited[ny][nx])
			dfs(ny, nx);
	}
	return;
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	fill(&a[0][0], &a[0][0] + mn*mn, 1);
	fill(&visited[0][0], &visited[0][0] + mn*mn, 0);

	cin >> m >> n >> k;
	for(int i=0; i<k; i++){
		int x1,x2,y1,y2;
		cin >> x1 >> y1 >> x2 >> y2;
		for(int y=y1; y<y2; y++){
			for(int x=x1; x<x2; x++){
				a[y][x] = 0;
			}
		}
	}

	for(int y=0; y<m; y++){
		for(int x=0; x<n; x++){
			if(a[y][x]==1 && !visited[y][x]){
				area = 0;
				ret++;
				dfs(y,x);
				v.push_back(area);
			}
		}
	}
	cout << ret << "\n";
	sort(v.begin(), v.end());
	for(int i : v) cout << i << " ";
	cout << "\n";

	return 0;
}
