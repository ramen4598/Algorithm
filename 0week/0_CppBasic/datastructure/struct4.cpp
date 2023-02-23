#include<iostream>
#include<vector>
using namespace std;

struct Point{
	int x, y;
};
bool cmp(const Point & a, const Point & b){
	return a.y > b.y; //y값 기준 내림차순
}
vector<Point> v;
int main(){
	for(int i = 10; i >= 1; i--){
		v.push_back({i, 10-i});
	}
	sort(v.begin(), v.end(), cmp); //custom 비교 함수가 true이도록 정렬
	for(auto i : v) cout << i.x << " : " << i.y << '\n';
	return 0;
}
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

