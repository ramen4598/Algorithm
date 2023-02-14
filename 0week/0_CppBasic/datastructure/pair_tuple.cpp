#include <iostream>
#include <tuple>
#include <utility>
using namespace std;

pair<int, int> pi;
tuple<int, int, int> tl;
int a, b, c, d, e, f;

int main(){
    pi = {1, 2};
    tl = make_tuple(1,2,3);
    tie(a,b) = pi;
    cout << a<<" : "<< b << endl;
    tie(a,b,c) = tl;
    cout << a << " : " << b << " : " << c << endl;

    d = pi.first;
    e = pi.second;
    cout << d << " : " << e << endl;
    d = get<0>(tl);
    e = get<1>(tl);
    f = get<2>(tl);
    cout << d << " : " << e << " : " << f << endl;
    return 0;
}