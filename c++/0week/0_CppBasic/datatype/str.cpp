#include <iostream>
using namespace std;
int str_out(){
    string a = "가나다";
    cout << a[0] << endl;
    cout << a[0] << a[1] << a[2] << endl;
    cout << a << endl;
    string b = "abc";
    cout << b[0] << endl;
    cout << b << endl;
    return 0;
}
int str_method(){
    string a = "love is";
    a += " pain!";
    a.pop_back();
    a.pop_back();
    cout << a << " : " << a.size() << "\n";
    cout << char(*a.begin()) << "\n";
    cout << char(*(a.end()-1)) <<  "\n";
    a.insert(0, "test ");
    cout << a << " : " << a.size() << "\n";
    a.erase(0, 5);
    cout << a << " : " << a.size() << "\n";
    auto it = a.find("love");
    if (it != string::npos){
        cout << "포함되어 있다." << "\n";
    }
    cout << it << '\n';
    cout << string::npos << '\n';
    cout << a.substr(5, 2) << '\n';
    return 0;
}

int main(){
    str_out();
    str_method();
}
