#include <iostream>
#include <stdio.h>

using namespace std;

void fun(int A[], int size)
{
    for (int i = 0; i < size; i++)
    {
        cout << A[i] << endl;
    }
}

int main(int argc, char const *argv[])
{
    int A[] = {2, 4, 6, 8, 10};
    int n = 5;
    fun(A, n);
    for (int x : A)
    {
        cout << x << ", ";
    }
    return 0;
}
