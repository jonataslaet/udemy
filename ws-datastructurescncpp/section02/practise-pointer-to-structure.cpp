#include <iostream>
#include <stdio.h>

using namespace std;

struct Rectangle
{
    int length;
    int breadth;
};

int main(int argc, char const *argv[])
{
    Rectangle r = {10, 5};

    cout << r.length << endl;
    cout << r.breadth << endl;

    Rectangle *p = &r;
    cout << p->length << endl;
    cout << p->breadth << endl;

    return 0;
}
