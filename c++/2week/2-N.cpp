//백준 9012번: 괄호
#include <iostream>
#include <stack>

using namespace std;

stack<char> stk;
int n;

int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(NULL); cout.tie(NULL);

  cin >> n;
  for(int tc=1; tc<=n; tc++){
    while(stk.size()){
      stk.pop();
    }

    bool underflow = false;
    string str ="";
    cin >> str;

    for(char c : str){
      if(c=='(')stk.push('(');
      if(c==')'){
        if(stk.size())
          stk.pop();
        else{
          underflow = true;
          break;
        }
      }
    }

    if(underflow){
      cout << "NO" << "\n";
      continue;
    }
    if(stk.size())
      cout << "NO" << "\n";
    else
      cout << "YES" << "\n";
  }

  return 0;
}
