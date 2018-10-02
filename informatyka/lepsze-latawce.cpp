#include <iostream>
#include <cstdlib>

using namespace std;

int main()
{
    int i=0,j,n;

    cin>>n;

    for (j=0;j<2*n;j++)

    if (j==n-1-i || j==n+1+i)
        cout<<"*"<<endl;
    else cout<<" ";


return 0;
}
