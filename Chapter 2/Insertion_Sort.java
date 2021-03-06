import java.util.ArrayList;
import java.util.Scanner;

/*插入排序*/
/* @Author: ChinaHQ
 * @Date 2017/06/24 */

public class Insertion_Sort {
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一列数组");
		ArrayList<String> arr = new ArrayList<String>();  // 创建一个ArrayList用来接收元素

		while(sc.hasNextLine()){ 
			String a = sc.nextLine();
			if (a.equals(("end"))){break;}  // 数组输入以end结束
			else{
				arr.add(a);
			}
		}

		System.out.println("您输入的数组如下");  // 输出原数组
		for (String str : arr){ 
			System.out.print(str);
			String tem = str;
			String[] m = tem.trim().split(" ");
			
			int[] array = new int[m.length];
			for(int i=0; i<m.length; i++){
				int b = Integer.parseInt(m[i]);
				array[i] = b;
			}

			for(int i=1;i<array.length;i++){ //插入排序(从小到大排序)
				int key = array[i];  // 初始把第三个作为最小值
				int j = i-1;
				while(j>=0 && array[j]>key){
					array[j+1] = array[j];
					j = j-1;
				}
				array[j+1] = key;
			}
			
			System.out.println("\n插入排序算法的数组是：");
			for(int i=0;i<array.length;i++){System.out.print(array[i]+" ");}
		}
	}
}
