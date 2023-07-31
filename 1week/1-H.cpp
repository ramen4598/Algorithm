//백준 2559번: 수열
#include <iostream>

using namespace std;

int N, K, sum, big, a[100004];

int main(){
	cin >> N >> K;
	for(int i=0; i<N; i++){
		cin >> a[i];
	}
	for(int i=0; i+K<N; i++){
		sum = 0;
		for(int j=0; j<K; j++){
			sum += a[i+j];
		}
		if(sum > big) big = sum;
	}
	cout << big << "\n";
	return 0;
}
