#include<iostream>
#include<algorithm>

using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
	int test_case;
	int T;
    
	cin>>T;

	for(test_case = 1; test_case <= T; ++test_case)
	{
        string bufferflush = "";
        int input;
        int ret = 0;
        int cnt[101]; fill(cnt, cnt + 101, 0);
        
		cin >> bufferflush;
		for(int i = 0; i <1000; i++){
			cin >> input;
            cnt[input]++;
        }
        
        for(int i = 0; i<101; i++){
            if(cnt[ret] < cnt[i])
				ret = i;
           	else if(cnt[ret] == cnt[i])
                ret = max(ret, i);
        }
        
        cout << "#" << test_case << " " << ret << "\n";
	}
	return 0;
}
