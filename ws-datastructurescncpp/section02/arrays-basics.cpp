#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
    int A[5];
    A[0] = 12;
    A[1] = 15;
    A[2] = 25;

    cout << sizeof(A) << endl;
    cout << A[1] << endl;

    return 0;
}
