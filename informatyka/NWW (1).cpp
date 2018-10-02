#include <iostream>

using namespace std;

int NWD(int a, int b)
{
    if (b==0) return a;
    cout<<"a="<<a<<" b="<<b<<endl;
    return NWD(b, a%b);
}

int main()
{
    int a, b;

    cin>>a;
    cin>>b;

    cout<<NWD(a,b);

return 0;
}
