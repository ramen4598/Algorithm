#include<iostream>
#include<set>
using namespace std;

int main(){
	multiset<pair<string, int>> ms;
	ms.insert({"test", 1});
	ms.insert({"test", 1});
	ms.insert({"test", 1});
	cout << ms.size() << '\n';
	for(auto i : ms){
		cout << i.first << i.second << '\n';
	}

	multiset<int> ms2;
	ms2.insert(1);
	ms2.insert(1);
	ms2.insert(2);
	cout << ms2.size() << '\n';
	for(auto i : ms2){
		cout << i << '\n';
	}

	multiset<char> ms3;
	ms3.insert('a');
	ms3.insert('b');
	ms3.insert('b');
	cout << ms3.size() << '\n';
	for(auto i : ms3){
		cout << i << '\n';
	}

	return 0;
}
/*
3
test1
test1
test1
3
1
1
2
3
a
b
b
정령은 한다. 단 중복을 허용한다.
*/
