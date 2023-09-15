// 백준 2852번: NBA 농구
#include<iostream>
#include<string>
#include<cstdlib>
using namespace std;

int N, score1=0, score2=0, t1=0, t2=0, prevTime=0, now=0;

string print(int sec){
  string ret="", MM="00", SS="00";

  MM+= to_string(sec/60);
  SS+= to_string(sec%60);

  MM= MM.substr(MM.size()-2, 2);
  SS= SS.substr(SS.size()-2, 2);

  ret+=MM; ret+=":"; ret+=SS;
  return ret;
}

int parse(string MMSS){
  int MM = atoi(MMSS.substr(0,2).c_str());
  int SS = atoi(MMSS.substr(3,2).c_str());
  return (MM*60)+SS;
}

int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(NULL); cout.tie(NULL);

  cin >> N;
  for(int i=0; i<N; i++){
    int tNum; string input;
    cin >> tNum >> input;
    now = parse(input);
    
    if(score1>score2){
      t1 += now - prevTime;
    }else if(score1<score2){
      t2 += now - prevTime;
    }
    prevTime = now;

    if(tNum==1)score1++;
    else score2++;
  }
  // 48:00 = 2880
  if(score1>score2){
    t1 += 2880 - prevTime;
  }else if(score1<score2){
    t2 += 2880 - prevTime;
  }

  cout << print(t1) << "\n";
  cout << print(t2) << "\n";

  return 0;
}
