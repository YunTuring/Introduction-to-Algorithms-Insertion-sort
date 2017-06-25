import java.util.Scanner;

public class BinaryPlus {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请输入一组元素为0或1的长度为7的数组:");
		int[] arr1 = new int[7];
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<arr1.length;i++){
			arr1[i] = sc.nextInt();
		}
		System.out.println("您输入的数组是:");
		for(int elem:arr1){
			System.out.print(elem+" ");
		}
		System.out.println("\n请输入另一组元素为0或1的长度为7的数组:");
		int[] arr2 = new int[7];
		for(int i=0;i<arr2.length;i++){
			arr2[i] = sc.nextInt();
		}
		sc.close();
		System.out.println("您输入的数组是:");
		for(int elem1:arr2){
			System.out.print(elem1+" ");
		}
		
		int[] arr3 = new int[8];
		arr3[arr3.length-1] = arr1[arr1.length-1] + arr2[arr1.length-1];
		for(int i=arr1.length-1;i>0;i--){
			if(arr3[i+1] ==2){
				arr3[i+1] = 0;
				arr3[i] = arr1[i-1] + arr2[i-1]+1;
			}else if(arr3[i+1] ==3){
				arr3[i+1] = 1;
				arr3[i] = arr1[i-1] + arr2[i-1]+1;
			}
			else{
				arr3[i] = arr1[i-1] + arr2[i-1];
				continue;}
		}
		if (arr3[1] >1){
			arr3[1] = 0;
			arr3[0] = 1;
		}else{arr3[0] = 0;}
		
		System.out.println("\n两数组相加后的数组为：");
		for(int elem3:arr3){
			System.out.print(elem3+" ");
		}
	}
}
