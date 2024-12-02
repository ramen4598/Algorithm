// 백준 2828번: 사과 담기 게임
#include <iostream>
#include <cstdlib>

using namespace std;

int n, m, j, pos=0, ret;

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m >> j;
	for(int i=0; i<j; i++){
		int apple;
		cin >> apple;
		apple--;

		bool goLeft = apple < pos;
		if(goLeft){
			ret += abs(apple - pos);
			pos = apple;
		}else{
			bool notMove = (apple - pos) < m;
			if(notMove) continue;
			int distance = apple - pos - m +1;
			ret += distance;
			pos += distance;
		}
	}

	cout << ret << "\n";

	return 0;
}
