//백준 10709번: 기상캐스터
#include <iostream>
#define MAXHW 100

using namespace std;

int H, W, ret[MAXHW][MAXHW];

int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(NULL); cout.tie(NULL);

  cin >> H >> W;
  for(int i=0; i<H; i++){
    bool isClody = false;
    int cnt = 0;
    for(int j=0; j<W; j++){
      char input; cin >> input;
      cnt++;
      if(input == 'c'){
        ret[i][j]=0;
        isClody=true;
        cnt=0;
      }else if(isClody){
        ret[i][j]=cnt;
      }else{
        ret[i][j]=-1;
      }
    }
  }
  for(int i=0; i<H; i++){
    for(int j=0; j<W; j++){
      cout << ret[i][j] << " ";
    }
    cout <<"\n";
  }

  return 0;
}
