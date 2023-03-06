#include<iostream>
#include<vector>
using namespace std;

vector<int> a {1,2,3,3,3,3,4,100};
int count(){
	cout << upper_bound(a.begin(), a.end(), 3) - lower_bound(a.begin(), a.end(), 3) << endl;
	return 0;
}

int near(){
	vector<int> v;
	for (int i=2; i <=5; i++) v.push_back(i);
	v.push_back(7);
	//2 3 4 5 7
	//0 1 2 3 4
	// 찾는 값이 없으면 가장 가까운 큰 값의 iterator 반환
	cout << upper_bound(v.begin(), v.end(), 6) - v.begin() << endl;
	//4 (7보단 작고 6은 없고 5보단 크고)
	cout << lower_bound(v.begin(), v.end(), 6) - v.begin() << endl;
	//4 (5보단 크고 6은 없고 7보단 작고)
	cout << upper_bound(v.begin(), v.end(), 9) - v.begin() << endl;
	//5 (7보다 커서)
	cout << lower_bound(v.begin(), v.end(), 9) - v.begin() << endl;
	//5 (7보다 커서)
	cout << upper_bound(v.begin(), v.end(), 0) - v.begin() << endl;
	//0 (2보다 작아서)
	cout << lower_bound(v.begin(), v.end(), 0) - v.begin() << endl;
	//0 (2보다 작아서)
	return 0;
}


int main(){
	count();
	near();
}
/*
4
4
4
5
5
0
0
*/
