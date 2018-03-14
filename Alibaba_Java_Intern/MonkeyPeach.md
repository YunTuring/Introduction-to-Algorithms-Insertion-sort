2018阿里秋招在线编程题 (Java开发工程师)

**题目：**小猴子下山，沿着下山的路有一排桃树，每棵树都结了一些桃子。小猴子想摘桃子，但是又一些条件需要遵守，小猴子只能沿着下山的方向走，不能回头，每棵树最多摘一个，而且一旦摘了一棵树的桃子，就不能再摘比这棵树结的桃子少的树上的桃子，那么小猴子最多能摘到几课桃子呢？ 
距离说明，比如有五棵树，分别结了10，4，5，12，8棵桃子，那么小猴子最多能摘3颗桃子，来自于结了4，5，12颗桃子的桃树。

**输入范例：** 
5 
10 
4 
5 
12 
8 
**输出范例：** 
3

分析：这是一个典型的最长递增子序列求解的问题。

```Java
// 此问题可以转化为最长递增子序列
// if you have better solutions, please contact the email zheng_gao_xing@163.com;
// Thank you very much!
import java.util.Scanner;

public class MonkeyPeach {
	static int[] a;
	static int[] d;
	
	public static int dmax(int n) {
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(a[j] <= a[i]) {
					d[i] = 	Math.max(d[i], d[j] + 1);
				}
			}
		}
		int dmax = d[0];
		for(int i=0;i<n;i++) {
			if (d[i] > dmax) {dmax = d[i];}
		}
		return dmax;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		a = new int[n];
		d = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = s.nextInt();
			d[i] = 1; // 初始化所有的值
		}
		System.out.println("猴子一共可以摘 "+dmax(n)+"个桃子!");
	}
}
```



