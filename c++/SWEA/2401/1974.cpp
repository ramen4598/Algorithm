#include<iostream>
#include<algorithm>

using namespace std;

const int MAX_N = 9;
int visited[MAX_N];

int check1(int a[MAX_N][MAX_N]){
	for(int y = 0; y < MAX_N; y++){
		fill(&visited[0] ,&visited[0] + MAX_N, 0);
		for(int x = 0; x < MAX_N; x++){
			int tmp = a[y][x] - 1;
			if(visited[tmp]) 
				return 0;
			else
				visited[tmp]++;
		}
	}
	return 1;
}

int check2(int a[MAX_N][MAX_N]){
	for(int x = 0; x < MAX_N; x++){
		fill(&visited[0] ,&visited[0] + MAX_N, 0);
		for(int y = 0; y < MAX_N; y++){
			int tmp = a[y][x] - 1;
			if(visited[tmp]) 
				return 0;
			else
				visited[tmp]++;
		}
	}
	return 1;
}

int check3(int a[MAX_N][MAX_N]){
	for(int i = 0; i<3; i++){
		for(int j = 0; j < 3; j++){
			fill(&visited[0] ,&visited[0] + MAX_N, 0);
			for(int dy = 0; dy < 3; dy++){
				for(int dx = 0; dx < 3; dx++){
					int ny = 3 * i + dy;
					int nx = 3 * j + dx;
					int tmp = a[ny][nx] - 1;
					if(visited[tmp]) 
						return 0;
					else
						visited[tmp]++;
				}
			}
		}
	}
	return 1;
}

int solve(int a[MAX_N][MAX_N]){
	return check1(a) && check2(a) && check3(a);
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int T;
	cin >> T;
	for(int test_case = 1; test_case <= T; test_case++){
		int a[MAX_N][MAX_N];
		for(int y = 0; y < MAX_N; y++)
			for(int x = 0; x < MAX_N; x++)
				cin >> a[y][x];
		
		int ret = solve(a);

		cout << "#" << test_case << " " << ret << '\n';
	}
	return 0;
}
