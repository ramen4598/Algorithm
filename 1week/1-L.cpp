//백준 1940: 주몽
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int n, m, cnt, a[100001];
vector<int> v;

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;
	
	for(int i=0; i<n; i++){
		int tmp;
		cin >> tmp;
		a[tmp]++;
		if(tmp<=m/2) v.push_back(tmp);
	}
	for(int i : v) 
		if(a[m-i] != 0) 
			cnt++;
	
	cout << cnt << "\n";
	return 0;
}
