// 백준 1629번: 곱셈
#include <iostream>
#include <vector>

using namespace std;

int a, b, c, tmp, repeat;
long long ret;
vector<int> v;

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
			v.push_back(ret);
		}else if(tmp == ret){
			repeat = i;
			break;
		}else{
			v.push_back(ret);
		}
	}
	cout <<  "repeat : " << repeat << "\n";

	b%=repeat;
	ret = v[(b+v.size()-1)%v.size()];
	cout << ret << "\n";
	return 0;
}
