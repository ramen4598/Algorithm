#include<iostream>
#include<vector>
using namespace std;

//2차원 벡터를 만드는 방법
vector<vector<int>> v;
//10*10 벡터를정적으로  만드는 방법
vector<vector<int>> v2(10, vector<int>(10, 0));

int main(){
	for(vector<int> v : v2){
		for(int i : v) cout << i << ' ';
		cout << endl;
	}
	for(int i=0; i<10; i++){
		vector<int> vv;
		v.push_back(vv);
	}
	return 0;
}
/*
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
 */
