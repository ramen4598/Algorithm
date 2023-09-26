//백준 1436번: 영화감독 숌
#include<iostream>
#include<string>
using namespace std;

int n, i=666, cnt=1, ret=666;

int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(NULL); cout.tie(NULL);

  cin >> n;
  do{
    i++;
    string str = to_string(i);
    auto it = str.find("666");
    if(it != string::npos){
      cnt++;
      ret = i;
    }
  }while(cnt!=n);

  cout << ret << "\n";

  return 0;
}
