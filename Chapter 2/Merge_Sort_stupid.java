/*归并排序算法*/
/* @Author: YunTuring
 * @Contact: zheng_gao_xing@163.com
 * @Date 2017/07/01 */
//参考网址：http://blog.csdn.net/morewindows/article/details/6678165/

// 本代码(edition 1)是stupid的做法，没有运用递归，不是通用的方法，如果数组更长或是更短点，则会报错
// 这是第一次尝试归并排序，经过这一次自己琢磨发现自己存在一些问题，在下一版edition 2中我会写出通用的归并排序
public class Merge_Sort_stupid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   int[] arr = {12,34,15,11,54,67,77,12,5,32,12,9,17};
		   printArray("排序前：",arr);
		   MergeSort(arr);
		   printArray("排序后：",arr);
	}
	
	private static void printArray(String str, int[] arr){ // 思考为什么用static修饰
		System.out.println(str);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}System.out.println();
	}
	
	private static void MergeSort(int[] arr){
		// 把一个数组按照每两个元素相比较形成的二个元素的有序数组
		Sort(arr);
		// 将二个有序的序列合并起来
	}
	
	private static void Sort(int[] arr){ // 将一个数组按照每两个元素相比较形成的有序数组
		// 比如arr = {12,34,24,53,46,78,19}  (12,34) (24,53) (46,78) (19)
		System.out.println("第一次排序为：");
		int i = 0;
		int[] tem = new int[2];
		while(i<arr.length){
			if(i+1>=arr.length){  // 预防最后一个元素的下标越界
				System.out.print("("+arr[i]+")");
				break;
			}
			if(arr[i] > arr[i+1]){
				tem[0] = arr[i+1];
				tem[1] = arr[i];
			}else{
				tem[0] = arr[i];
				tem[1] = arr[i+1];
			}
			System.out.print("("+tem[0]+" "+tem[1]+")");
			arr[i] = tem[0]; // 把第一次排序好的仍放回原数组
			arr[i+1] = tem[1];
			i = i+2;
		}
		System.out.println();
		
		System.out.println("第二次排序为：");
		int size = 2;
		int[] tem2 = new int[arr.length];
		int index = 0,index1 = 0,index2 = 0;
		int i1 = 0;
		while(i1 <= arr.length-4){
			int j1 = i1 + 1;
			int[] arr1 = new int[size];
			int[] arr2 = new int[size];
			while(i1<=j1){
				arr1[index1] = arr[i1];
				arr2[index2] = arr[i1+size];
				if(index1>=1 && index2>=1){
					int[] tem1 = new int[arr1.length+arr2.length];
					tem1 = Merge(arr1,arr2);
					System.out.print("(");
					for(int i2=0;i2<tem1.length;i2++){
						tem2[index] = tem1[i2];
						System.out.print(tem2[index] + " ");
						index++;
						}
					System.out.print(")");
					index1 = -1;
					index2 = -1;
				}
				index1++;
				index2++;
				i1++;
			}
			i1 = i1 - 2;
			i1 = i1 + 4;
		}
		size = size*2;
		System.out.print("(");
		while(i1<arr.length){
			tem2[index] = arr[i1];
			System.out.print(tem2[index]+" ");
			index++;
			i1++;
		}System.out.print(")");
		
		System.out.println("\n第三次排序为：");
		int[] tem4 = new int[arr.length];
		int i3=0,index3=0,index4=0,index5=0;
		while(i3<=arr.length-8){
			int j3 = i3+3;
			int[] arr3 = new int[size];
			int[] arr4 = new int[size];
			while(i3<=j3){
				arr3[index3] = tem2[i3];
				arr4[index4] = tem2[i3+size];
				if(index3>=3 && index4>=3){
					int[] tem3 = new int[arr3.length+arr4.length];
					tem3 = Merge(arr3,arr4);
					
					System.out.print("(");
					for(int i4=0;i4<tem3.length;i4++){
						tem4[index5] = tem3[i4];
						System.out.print(tem4[index5] + " ");
						index5++;
						}
					System.out.print(")");
					
				}
				index3++;
				index4++;
				i3++;
			}
			i3 = i3-4;
			i3 = i3+8;
		}
	
		System.out.print("(");
		boolean flag = true;
		if(arr.length-i3>size && arr.length-i3<size*2){
			int[] arrx = new int[size];
			int[] arrx1 = new int[arr.length-i3-size];
			for(int ix=0;ix<arrx.length;ix++){
				arrx[ix] = tem2[ix+i3];
			}
			for(int ix1=0;ix1<arrx1.length;ix1++){
				arrx1[ix1] = tem2[ix1+i3+size];
			}
			int[] temx = new int[arrx.length+arrx1.length];
			temx = Merge(arrx,arrx1);
			for(int ix2=0;ix2<temx.length;ix2++){
				tem4[i3+ix2] = temx[ix2];
				System.out.print(tem4[i3+ix2]+" ");
			}
			flag = false;
		}
		while(i3<arr.length && flag){
			tem4[index5] = arr[i3];
			System.out.print(tem4[index5]+" ");
			index5++;
			i3++;
		}System.out.print(")");
		
		System.out.println("\n第四次排序为：");
		size = size*2;
		int i4=0,index6=0,index7=0,index8=0;
		int[] tem6 = new int[arr.length];
		boolean flag11 = true;
		while(i4<=arr.length-16){
			int j4 = i4+7;
			int[] arr5 = new int[size];
			int[] arr6 = new int[size];
			while(i4<=j4){
				arr5[index6] = tem4[i4];
				arr6[index7] = tem4[i4+size];
				if(index6>=7 && index7>=3){
					int[] tem5 = new int[arr5.length+arr6.length];
					tem5 = Merge(arr5,arr6);
					
					System.out.print("(");
					for(int i5=0;i5<tem5.length;i5++){
						tem6[index8] = tem5[i5];
						System.out.print(tem6[index8] + " ");
						index8++;
						}
					System.out.print(")");
					
				}
				index6++;
				index7++;
				i4++;
			}
			i4 = i4 - 8;
			i4 = i4 + 16;
			flag11 = false;
		}
		
		System.out.print("(");
		while(i4<arr.length && !flag11){
			tem6[index8] = arr[i4];
			System.out.print(tem6[index8]+" ");
			i4++;
			index8++;
		}
		int[] tem7 = new int[arr.length];
		if(flag11){
			int[] arr7 = new int[size];
			while(i4 < size){
				arr7[index8] = tem4[i4];
				i4++;
				index8++;
			}
			int[] arr8 = new int[arr.length-size];
			while(index8<arr.length){
				arr8[index8-8] = tem4[i4];
				i4++;
				index8++;
			}
			
			tem7 = Merge(arr7,arr8);
			for(int i6=0;i6<tem7.length;i6++){
				System.out.print(tem7[i6]+" ");
			}
		}
		System.out.print(")");
		System.out.println();
		
		for(int l=0;l<arr.length;l++){
			int t = arr[l];
			arr[l] = tem7[l];
		}
	}
	
	private static int[] Merge(int[] arr1, int[] arr2){ // 将两个有序的序列合并起来
		int size = arr1.length + arr2.length;
		int[] arr = new int[size];
		int index = 0,index1 = 0,index2 = 0;
		while(index1<arr1.length && index2<arr2.length){ //至少有一列数组全部会被归并
			if (arr1[index1]<= arr2[index2]){
				arr[index++] = arr1[index1++];
			}else{
				arr[index++] = arr2[index2++];
			}
		}
		while(index1<arr1.length){ //把arr1中剩余的归并
			arr[index++] = arr1[index1++];
		}
		while(index2<arr2.length){ // 把arr2中剩余的归并
			arr[index++] = arr2[index2++];
		}
		return arr;
	}
}
