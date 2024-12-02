#include<iostream>
#include<vector>
using namespace std;

vector<int> v;
int main(){
	for(int i=1; i<=5; i++){
		v.push_back(i);
		v.push_back(i);
	}
	for(int i : v) cout << i << " ";
	cout << endl;
	auto it = unique(v.begin(), v.end());
	cout << it - v.begin() << endl; // 중복되지 않는 요소의 수
	for(int i : v) cout << i << " ";
	cout << endl;
	for(auto cnt = v.begin(); cnt < it; cnt++){
		cout << *cnt << " ";
	}
	cout << endl;
	return 0;
}
//unique는 중복되는 요소를 제거하고 나머지 요소들은 삭제하지 않고 그대로 둔다. 중복되지 않는 요소 중 마지막 요소 다음 이터레이터를 반환한다.
/*
1 1 2 2 3 3 4 4 5 5
5
1 2 3 4 5 3 4 4 5 5
1 2 3 4 5
*/

