/*
#include <iostream>
using namespace std;

string s;
int main(){
    getline(cin, s);
    cout << s << '\n';
    return 0;
}
*/

/*
#include <iostream>
using namespace std;

string n;
string s;
int main(){
	cin >> n;
	getline(cin, s);
	cout << n << s << '\n';
	return 0;
}
*/
#include<iostream>
using namespace std; int T;
string s;
int main(){
    cin >> T;
    string bufferflush;
    getline(cin, bufferflush); 
    for(int i = 0; i < T; i++){ 
        getline(cin, s);
        cout << s << "\n";
    }
    return 0; 
}