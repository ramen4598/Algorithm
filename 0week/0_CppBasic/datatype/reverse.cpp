#include <iostream>
using namespace std;

int main(){
    string a = "It's hard to have a sore leg";
    reverse(a.begin(), a.end());
    cout << a << endl;
    reverse(a.begin(), a.end());
    cout << a << endl;
    reverse(a.begin() + 5, a.end());
    cout << a << endl;
    return 0;
}