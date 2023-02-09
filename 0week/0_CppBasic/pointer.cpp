#include <iostream>
using namespace std;

int main(){
    string a = "hello world";
    string * b = &a;
    cout << b << endl;
    cout << *b << endl;
    return 0;
}