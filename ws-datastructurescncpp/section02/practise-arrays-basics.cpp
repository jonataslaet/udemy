#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
    int a = 10;
    int &r = a;
    r = 25;
    cout << a << endl
         << r << endl;

    return 0;
}
