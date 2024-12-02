// 백준 4949번: 균형잡힌 세상
#include <iostream>
#include <stack>
using namespace std;

string str="";

bool check(string str){
  stack<char> stk;
  for(char c : str){
    if(c == '(' || c == '[')stk.push(c);
    if(c == ')'){
      if(stk.size() && stk.top() == '('){
        stk.pop();
      }else{
        return false;
      }
    }
    if(c == ']'){
      if(stk.size() && stk.top() == '['){
        stk.pop();
      }else{
        return false;
      }
    }
  }
  return stk.empty();
}

int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(NULL); cout.tie(NULL);

  while(getline(cin, str)){
    if(str==".")break;
    if(check(str)) cout << "yes\n";
    else cout << "no\n";
  }

  return 0;
}
