#include<iostream>
#include<set>
using namespace std;

int main(){
	set<pair<string, int>> st;
	st.insert({"test", 1});
	st.insert({"test", 1});
	st.insert({"test", 1});
	cout << st.size() << '\n';
	for(auto i : st){
		cout << i.first << i.second << '\n';
	}

	set<int> st2;
	st2.insert(1);
	st2.insert(1);
	st2.insert(2);
	cout << st2.size() << '\n';
	for(auto i : st2){
		cout << i << '\n';
	}

	set<char> st3;
	st3.insert('a');
	st3.insert('b');
	st3.insert('b');
	cout << st3.size() << '\n';
	for(auto i : st3){
		cout << i << '\n';
	}

	return 0;
}
/*
1
test1
2
1
2
2
a
b
*/
