#include<iostream>
#include<vector>
using namespace std;

vector<int> v;

int main(){
	for(int i=1; i<=10; i++) v.push_back(i);
	for(int a : v) cout << a << " ";
	cout << endl;

	v.pop_back();
	for(int a : v) cout << a << " ";
	cout << endl;

	v.erase(v.begin(), v.begin() + 3);
	for(int a : v) cout << a << " ";
	cout << endl;
	
	auto a = find(v.begin(), v.end(), 100); //string.find()랑은 다른 것이다.
	if(a == v.end()) cout << "not found" << endl;

	fill(v.begin(), v.end(), 10);
	for(int a : v) cout << a << " ";
	cout << endl;

	v.clear();
	cout << "clear!" << endl;
	for(int a : v) cout << a << " ";
	cout << endl;

	//vector static
	vector<int> v1(5, 100);
	cout << "벡터의 정적인 할당" << endl;
	for(int a : v1) cout << a << " "; 
	cout << endl;
	cout << v1.front() << " : " << v1.back() << endl;
	
	return 0;
}
/*
1 2 3 4 5 6 7 8 9 10
1 2 3 4 5 6 7 8 9
4 5 6 7 8 9
not found
10 10 10 10 10 10
clear!

벡터의 정적인 할당
100 100 100 100 100 
100 : 100
*/
