//백준 2979번: 트럭 주차
#include <iostream>

using namespace std;

int A, B, C, a, b, cnt[104], sum;
int main(){
	cin >> A >> B >> C;
	for(int i = 0; i < 3; i++){
		cin >> a >> b;
			for(int j = a; j < b; j++){
				cnt[j]++;
			}
	}
	for(int j = 1; j < 100; j++){
		if(cnt[j]){
			if(cnt[j] == 1) sum += A;
			else if(cnt[j] == 2) sum += 2*B;
			else if(cnt[j] == 3) sum += 3*C;
		}
	}
	cout << sum << "\n";
	return 0;
}
