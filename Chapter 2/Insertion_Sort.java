import java.util.ArrayList;
import java.util.Scanner;

/*��������*/
/* @Author: ֣����
 * @Contact: zheng_gao_xing@163.com
 * @Date 2017/06/24 */

public class Insertion_Sort {
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ������");
		ArrayList<String> arr = new ArrayList<String>();  // ����һ��ArrayList��������Ԫ��

		while(sc.hasNextLine()){ 
			String a = sc.nextLine();
			if (a.equals(("end"))){break;}  // ����������end����
			else{
				arr.add(a);
			}
		}

		System.out.println("���������������");  // ���ԭ����
		for (String str : arr){ 
			System.out.print(str);
			String tem = str;
			String[] m = tem.trim().split(" ");
			
			int[] array = new int[m.length];
			for(int i=0; i<m.length; i++){
				int b = Integer.parseInt(m[i]);
				array[i] = b;
			}

			for(int i=1;i<array.length;i++){ //��������(��С��������)
				int key = array[i];  // ��ʼ�ѵ�������Ϊ��Сֵ
				int j = i-1;
				while(j>=0 && array[j]>key){
					array[j+1] = array[j];
					j = j-1;
				}
				array[j+1] = key;
			}
			
			System.out.println("\n���������㷨�������ǣ�");
			for(int i=0;i<array.length;i++){System.out.print(array[i]+" ");}
		}
	}
}
