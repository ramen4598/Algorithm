// 2178번 미로 탐색
#include <iostream>
#include <queue>
#include <utility> // for pair
#include <tuple> // for tie
using namespace std;

const int max_nm = 104;

int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
int n, m, a[max_nm][max_nm], visited[max_nm][max_nm], y, x, sy, sx, ey, ex;

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	cin >> n >> m;
	sy = 0; sx = 0;
	ey = n-1; ex = m-1;

	//맵 입력
	for(int i=0; i<n; i++){
		string s;
		cin >> s;
		for(int j=0; j<m; j++){
			a[i][j] = s[j] - '0';
		}
	}

	queue<pair<int, int>> q;

	visited[0][0] = 1;
	q.push({0,0});
	while(q.size()){
		tie(y, x) = q.front(); q.pop();
		for(int i = 0; i < 4; i++){
			int ny = y + dy[i];
			int nx = x + dx[i];
			bool underflow = ny < 0 || nx < 0;
			bool overflow = ny >= n || nx >= m;
			if(underflow || overflow) continue;
			bool noAccess  = a[ny][nx] == 0;
			if(noAccess || visited[ny][nx]) continue;
			visited[ny][nx] = visited[y][x] + 1;
			q.push({ny, nx});
		}
	}
	cout << visited[ey][ex] << "\n";
	
	return 0;
}
