//백준 2309번: 일곱 난쟁이
#include<iostream>
#include<vector>
using namespace std;
int a[9];
int n =9, r =7;

void solve(){
	int sum =0;
	for(int i=0; i<r; i++) sum += a[i];
	if(sum == 100){
		sort(a, a+r);
		for(int i=0; i<r; i++) cout << a[i] << " ";
		cout << '\n';
		exit(0);
	}
	return;
}

void print(){
	for(int i=0; i<r; i++) cout << a[i] << " ";
	cout << '\n';
}

void makePermutation(int depth){
	if(depth == r){
		solve();
		return;
	}
	for(int i=depth; i<n; i++){
		swap(a[i], a[depth]);
		makePermutation(depth +1);
		swap(a[i], a[depth]);
	}
}

int main(){
	for(int i=0; i<9; i++){
		cin >> a[i];
	}
	makePermutation(0);

	return 0;
}


/*
입력
20
7
23
19
10
15
25
8
13
출력
7 8 10 13 19 20 23
*/
