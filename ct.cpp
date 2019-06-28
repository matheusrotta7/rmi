#include <bits/stdc++.h>

using namespace std;

int main() {


    for (int i = 1; i <= 6; i++) {
        string copt = "copt";
        string sopt = "sopt";
        string txt = ".txt";
        string client_file = copt + to_string(i) + txt ;
        string server_file = sopt + to_string(i) + txt ;
        string result_file = "resopt" + to_string(i) + txt ;

        const char * cfile = client_file.c_str();
        const char * sfile = server_file.c_str();
        const char * rfile = result_file.c_str();

        FILE* cf = fopen(cfile, "r");
        FILE* sf = fopen(sfile, "r");
        FILE* rf = fopen(rfile, "w");
        int cv, sv;
        while (fscanf(cf, "%d", &cv) != EOF && fscanf(sf, "%d", &sv) != EOF) {
            fprintf(rf, "%d\n", cv - sv);
        }
    }



    return 0;
}
