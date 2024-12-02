// 백준 9375번: 패션왕 신혜빈
#include <iostream>
#include <map>
#include <vector>

using namespace std;

int n, m, comb, ret;
map<string, int> mp;
string wear, type;
vector<string> v;

void combi(int start, int c, int r, vector<int> b){
	if(b.size() == r){
		for(int i : b){
			if(comb==0) comb = i;
			else comb *= i; 
		}
		ret += comb;
		comb=0;
		return;
	}
	for(int i=start+1; i<c; i++){
		string target = *(v.begin() + i);
		auto it = mp.find(target);
		//cout << i << " : " << target << " : " << it->first <<" : " << it->second << "\n";
		b.push_back(it->second);
		combi(i, c, r, b);
		b.pop_back();
	}
	return;
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;
	for(int i=0; i<n; i++){
		cin >> m;
		for(int j=0; j<m; j++){
			cin >> wear >> type;
			auto it = mp.find(type);
			if(it == mp.end()){
				mp.insert(make_pair(type, 1));
				v.push_back(type);
			}else{
				it->second++;
			}
		}
		// combination
		vector<int> b;
		for(int j=1; j<=mp.size(); j++){
			combi(-1, mp.size(), j, b);
			b.clear();
		}
		cout << ret << "\n";
		ret = 0;
		v.clear();
		mp.clear();
	}
	return 0;
}

