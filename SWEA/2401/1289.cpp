#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

int solve(vector<char>& input){
	int cnt = 0;
	char before = '0';

	for(int i = 0; i < input.size(); i++){
		if(input[i] != before){
			before = input[i];
			cnt++;
		}
	}
	return cnt;
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int T;
	cin >> T;
	for(int tc = 1; tc <= T; tc++){
		int ret;
		string str;
		vector<char> input;

		cin >> str;
		for(char c : str){
			input.push_back(c);
		}
		
		ret = solve(input);

		cout << "#" << tc << " " << ret << '\n';
	}
	return 0;
}
