package PDD;

/**
 * 给出平面上的n个点，现在需要你求出，在这n个点里选3个点能构成一个三角形的方案有几种。
 */

/**
 * 	#include<iostream>
 #include <vector>
 #include <assert.h>
 using namespace std;
 struct   node//点的坐标；
 {
 int x;
 int y;

 };
 int get_the_number(node *a, int n);
 //=========main函数
 int main()
 {
 int n;
 cin >> n;
 node *a = new node[n];
 //node *a=(node *)malloc(sizeof(node)*n);
 for (int i = 0; i < n; i++)
 cin >> a[i].x >> a[i].y;

 for(int i=0;i<n;i++)
 cout<<a[i].x<<" "<<a[i].y<<endl;

 int result = get_the_number(a, n);
 cout << result << endl;
 }
 int get_the_number(node *a, int n)
 {
 if (n <= 2)//不能满足组成三角形的情况；
 return 0;

 int number1 = n*(n - 1)*(n - 2) / 6;//从n个点中取三个点有多少种取法；

 int counts = 0;//求出不能组成三角形的情况；1、斜率相等；2、斜率不存在
 for (int i = 0; i < n;i++)
 for (int j = i + 1; j < n;j++)
 for (int k = j + 1; k < n; k++)
 {
 if ((a[k].y - a[j].y) / (a[k].x - a[j].x) == (a[j].y - a[i].y) / (a[j].x - a[i].x))
 counts++;
 if (a[k].x == a[j].x == a[i].x)
 counts++;
 }
 return number1 - counts;//两者之差就是三角形的个数；
 }
 */
public class Test4 {

}
