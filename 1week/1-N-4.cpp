// 백준 1629번: 곱셈
#include <iostream>

using namespace std;

int a, b, c, tmp, repeat, arr[32];
long long ret;

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> a >> b >> c;
	ret = a; 
	for(int i = 0; i<b; i++){
		ret *= a;
		ret %=c;
		//cout << i << " : " << ret << "\n";
		if(i==0){
			tmp = ret;
			arr[i]=ret;
		}else if(tmp == ret){
			repeat = i;
			break;
		}else{
			arr[i]=ret;
		}
	}
	//cout <<  "repeat : " << repeat << "\n";

	b%=repeat;
	ret = arr[(b+repeat-1)%repeat];
	cout << ret << "\n";
	return 0;
}
