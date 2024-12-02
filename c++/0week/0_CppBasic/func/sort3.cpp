#include<iostream>
#include<vector>
using namespace std;

vector<pair<int, int>> v;
bool cmp(pair<int, int> a, pair<int, int> b){
	return a.first > b.first;
}
int main(){
	for(int i = 10; i >= 1; i--){
		v.push_back({i, 10-i});
	}
	sort(v.begin(), v.end(), cmp);
	for(auto it : v) cout << it.first << " " << it.second << endl;
	return 0;
}
/*
10 0
9 1
8 2
7 3
6 4
5 5
4 6
3 7
2 8
1 9
*/
