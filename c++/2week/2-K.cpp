//백준 3474번: 교수가 된 현우
#include<iostream>

using namespace std;

int T;

int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(NULL); cout.tie(NULL);

  cin >> T;
  for(int tc = 1; tc <= T; tc++){
    int N, ret=0, i=5;
    cin >> N;
    while(N >= i){
      ret += N/i;
      i*=5;
    }
    cout << ret << "\n";
  }

  return 0;
}
