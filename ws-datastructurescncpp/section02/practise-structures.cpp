#include <iostream>
#include <stdio.h>

struct Rectangle
{
    int length;
    int breadth;
    char x;
};

using namespace std;

int main(int argc, char const *argv[])
{
    struct Rectangle r1 = {10, 5};

    printf("%lu\n", sizeof(r1));

    cout << r1.length << endl;
    cout << r1.breadth << endl;

    r1.length = 15;
    r1.breadth = 7;

    cout << r1.length << endl;
    cout << r1.breadth << endl;

    return 0;
}
