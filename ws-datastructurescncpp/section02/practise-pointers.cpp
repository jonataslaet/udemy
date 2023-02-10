#include <iostream>
#include <stdio.h>

using namespace std;

int main(int argc, char const *argv[])
{
    int a = 10;
    int *p;
    p = &a;

    int A[5] = {2, 4, 6, 8, 10};
    int *pA;
    pA = &A[0]; // or pA = A;

    int *pB;
    pB = new int[5];
    pB[0] = 20;
    pB[1] = 40;
    pB[2] = 60;
    pB[3] = 80;
    pB[4] = 100;

    for (int i = 0; i < 5; i++)
    {
        cout << pA[i] << " | dynamic alloc in heap -> " << pB[i] << endl;
    }

    cout << a << endl;
    printf("Using pointer %d %d", p, &a);

    delete[] pB;
    return 0;
}
