#include <iostream>
#include <stdio.h>

using namespace std;

int main(int argc, char const *argv[])
{
    int a = 10, b = 30;
    int &r = a;
    r = 25;
    r = b;
    cout << a << endl;
    cout << r << endl;

    return 0;
}
