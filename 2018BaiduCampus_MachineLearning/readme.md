##### 2018百度校招机器学习算法工程师笔试编程题之“双素数”   
   
定义：一个素数，将其反转后，仍是素数，这样的素数称为双素数；求：第N个双素数？[N小于1000000]     
解决方案如下：

```java
import java.util.Scanner;
/** this code is written by ChinaHQ, 
 * if you have better idea, please contact with me by emailing zheng_gao_xing@163.com;
 * */
public class double_prime {
	public static void main(String[] args){
        System.out.println("please input a integer number!");
        Scanner sc = new Scanner(System.in);
        int marker = 0;
        int n = 0;
        while(marker==0){
            n = sc.nextInt();
            if(n<=1000000){
            	marker = 1;
            }else{
            	System.out.println("your number is too large, please input another number!");
            	continue;
            }
        }
        sc.close();
        boolean flag = true;
        double count = 0; /*find the n-th number of the double prime number*/ 
        for(int i=0;i<=1000000;i++){
            if(prime(flag,i) && (i!=reverse(i)) && prime(flag,reverse(i))){
               count = count+1;
                if (count==n){
                    System.out.println("The "+n+"-th double number is: "+i);
                }
            }
        }
    }
    private static boolean prime(boolean flag, int num) {
		// /*looking for the prime number*/
    	    for(int j=2;j<=Math.sqrt(num);j++){
    	        if(num%j==0){
    	            flag = false;
    	        }
    	    }
		return flag;
	}
	static int reverse(int num){
		int result = 0; // store the reverse number
		// ref : http://blog.csdn.net/u012110719/article/details/42745831
		while(true)
		{
			int b = num % 10; // find out the number in the end
			result = result*10 + b;
			num = num/10;
			if(num==0)
			{
				break;
			}
		}
		return result;
	}
}
```
