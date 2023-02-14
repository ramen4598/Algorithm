#include<iostream>
#include<vector>
using namespace std;

vector<int> v;

int main(){
	for(int i=1; i <=5; i++)v.push_back(i);
	for(int i=0; i < 5; i++){
		cout << i << "번째 요소 : " << *(v.begin()+i) << endl;
		cout << &*(v.begin()+i) <<endl;
	}
	for(auto it = v.begin(); it !=v.end(); it++){
		cout << *it << ' ';
	}
	cout << endl;
	for(vector<int>::iterator it = v.begin(); it != v.end(); it++){
		cout << *it << ' ';
	}
	auto it = v.begin();
	advance(it, 3);
	cout << endl;
	cout << *it << endl;
}
/*
0번째 요소 : 1
0x600000e791a0
1번째 요소 : 2
0x600000e791a4
2번째 요소 : 3
0x600000e791a8
3번째 요소 : 4
0x600000e791ac
4번째 요소 : 5
0x600000e791b0
1 2 3 4 5
1 2 3 4 5
4
*/
