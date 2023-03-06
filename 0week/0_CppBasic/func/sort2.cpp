#include<iostream>
#include<vector>
using namespace std;

vector<pair<int, int>> v;
int main(){
	for(int i =10; i>= 1; i--){
		v.push_back({i, 10-i});
	}
	sort(v.begin(), v.end());
	for(auto it : v) cout << it.first << " : " << it.second << endl;
	return 0;
}
// default : first, second, third 순으로 차례차례 오름차순
/*
1 : 9
2 : 8
3 : 7
4 : 6
5 : 5
6 : 4
7 : 3
8 : 2
9 : 1
10 : 0
*/
