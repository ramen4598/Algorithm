// 백준 1629번: 곱셈
#include <iostream>

using namespace std;

int a, b, c, tmp, repeat;
long long ret;

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> a >> b >> c;
	ret = a; 
	for(int i = 0; i<b; i++){
		ret *= a;
		ret %=c;
		if(i==0){
			tmp = ret;
		}else if(tmp == ret){
			repeat = i;
			break;
		}
	}

	b%=repeat;
	if(b==0)b=repeat;
	ret = a;
	for(int i = 0; i<b; i++){
		ret *= a;
		ret %=c;
		//cout << i << " : " << ret << "\n";
	}
	cout << ret << "\n";
	return 0;
}
