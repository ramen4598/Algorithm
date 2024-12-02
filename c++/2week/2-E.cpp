// 백준 1992번 퀴드트리
#include <iostream>
#include <string>

using namespace std;

const int max_n = 64;
const int dy[] = {0, 0, 1, 1};
const int dx[] = {0, 1, 0, 1};
int n, a[max_n][max_n];
string s, ret="";

string quadtree(int y, int x, int n){
	string str = "";
	bool pass = true;
	int tmp = a[y][x];
	
	for(int i=y; i<y+n; i++)
		for(int j=x; j<x+n; j++)
			if(a[i][j] != tmp)
				pass = false;

	if(pass){
		str += to_string(tmp); 
	}else{
		str += "(";
		for(int i=0; i<4; i++){
			int ny = y+dy[i]*n/2;
			int nx = x+dx[i]*n/2;
			str +=	quadtree( ny, nx, n/2);
		}
		str += ")";
	}

	return str;
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin  >> n;

	for(int i = 0; i < n; i++){
		cin >> s;
		for(int j = 0; j < n; j++){
			a[i][j] = s[j] - '0';
		}
	}

	ret = quadtree(0,0, n);

	cout << ret << "\n";

	return 0;
}
