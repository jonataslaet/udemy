#include <iostream>
#include <stdio.h>

using namespace std;

void fun(int A[])
{
    for (int i = 0; i < 5; i++)
    {
        cout << A[i] << endl;
    }
}

int main(int argc, char const *argv[])
{
    int A[] = {2, 4, 6, 8, 10};
    fun(A);
    for (int x : A)
    {
        cout << x << ", ";
    }
    return 0;
}
