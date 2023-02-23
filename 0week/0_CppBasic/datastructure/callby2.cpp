#include<iostream>
#include<vector>
using namespace std;

vector<int> v(3, 0);
void go_vec(vector<int> v){
	v[1] = 100;
}

int a[3] = {0,0,0};
void go_arr(int a[]){
	a[1] = 100;
}
 
int main(){
	cout << "vector" <<endl;
	for(int i : v) cout << i << " ";
	cout << endl;
	go_vec(v);
	for(int i : v) cout << i << " ";
	cout << endl;

	cout << "array" <<endl;
	for(int i : a) cout << i << " ";
	cout << endl;
	go_arr(a);
	for(int i : a) cout << i << " ";
	cout << endl;

	return 0;
}

/*
vector
0 0 0 
0 0 0 
array
0 0 0 
0 100 0 
vector -> call by value
array -> call by reference
*/
