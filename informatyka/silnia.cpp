#include <iostream>

using namespace std;

int silnia(double n)
{
    int i=0, s=1;

    for (i=2;i<=n;i++)
        s*=i;

    return s;
}

int main()
{
    double n;

    cin>>n;

    cout<<n;
}
