#include <iostream>

using namespace std;

double a(int n)
{
    if (n==0) return 0.2;
    else return a(n-1)*-3;
}

int main()
{
    int i, x;
    cin>>x;

    for (i=0;i<x;i++)

    cout<<a(i)<<endl;

    return 0;
}
