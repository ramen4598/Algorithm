// 백준 4375번: 1
#include <iostream>
using namespace std;

int n;
typedef long long ll;

int main(){
	//ios_base::sync_with_stdio(false);
	//cin.tie(NULL); cout.tie(NULL);
	while(scanf("%d", &n) != EOF){
		ll cnt = 1, ret = 1;
		while(true){
			if(cnt % n == 0){
				printf("%lld\n", ret);
				break;
			}else{
				cnt = (cnt * 10) + 1;
				ret++;
			}
		}
	}
	return 0;
}
