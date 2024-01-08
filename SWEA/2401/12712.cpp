#include<iostream>
#include<algorithm>

using namespace std;

int n, m;
int a[15][15];
int dy[2][4] = {{1, -1, -1, 1}, {1, 0, -1, 0}};
int dx[2][4] = {{1, 1, -1, -1}, {0, 1, 0, -1}};

int sum(int y, int x){
    int sum[2];
    for(int i = 0; i <2; i++){
         sum[i] = a[y][x];
    	for(int j = 1; j<m; j++){
        	for(int dir = 0; dir < 4; dir++){
            	int ny = y + (dy[i][dir] * j);
            	int nx = x + (dx[i][dir] * j);
            	bool underflow = (ny < 0) || (nx < 0);
            	bool overflow = (ny >= n) || (nx >= n);
            	if(underflow || overflow) continue;
            	sum[i] += a[ny][nx];
        	}
    	}
    }
    return max(sum[0], sum[1]);
}

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
	int test_case;
	int T;
	
	cin>>T;

	for(test_case = 1; test_case <= T; ++test_case)
	{
        int ret = 0; int input = 0;
		cin >> n >> m;
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                cin >> input;
                a[i][j] = input;
            }
        }
        
        for(int y = 0;  y<n; y++)
            for(int x = 0; x<n; x++)
				ret = max(ret, sum(y, x));

        cout << "#" << test_case << " " << ret << "\n";
	}
	return 0;
}
