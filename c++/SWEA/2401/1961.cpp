#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

void turn(vector<vector<char>>& input){
	vector<vector<char>> copy(input.size(), vector<char>(input.size()));
	for(int y = 0; y < input.size(); y++){
		for(int x = 0; x < input.size(); x++){
			copy[x][input.size()-1-y] = input[y][x];
		}
	} 
	input = copy;
	return;
}

string doit(vector<vector<char>>& input){
    string ret = "";
    vector<string> lines(input.size());

    for(int i = 0; i < 3; i++){
		turn(input);
		for(int j = 0; j < input.size(); j++){
			for(char c : input[j]){
				lines[j] += c;
			}
			lines[j] += " ";
		}
	}
	
	for(string line : lines){
		ret += line;
		ret += "\n";
	}
    
    return ret;
}

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

	int test_case;
	int T;
	
	cin>>T;
	
	for(test_case = 1; test_case <= T; ++test_case)
	{
	    int n;

        cin >> n;
		vector<vector<char>> input(n, vector<char>(n));

        for(int y = 0; y < n; y++)
            for(int x = 0; x < n; x++)
                cin >> input[y][x];

        string ret = doit(input);
        cout << "#" << test_case << "\n" << ret;

	}
	return 0;
}
