// 백준: 2559번: 수열
#include <iostream>

using namespace std;

int n, k, temp, psum[100001], big= -10000004;

int main(){
	cin >> n >> k;
	for(int i = 1; i <= n; i++){
		cin >> temp; psum[i] = psum[i-1] + temp;
	}
	for(int i =k; i <= n; i++){
		big=max(big, psum[i] - psum[i-k]);
	}
	cout << big << "\n";
	return 0;
}
