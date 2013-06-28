/* 
title:Radix Sort.
Author:Rahul Ravindran
*/

import java.util.*;

class RadixSort
{


	public static void main(String [] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("enter the number of elements");
		int x=s.nextInt();
		int [] arr1 = new int[x];
		int [] arr2 = new int[x];
		int count=0,y=0,t=1,n=1;
		System.out.println("enter the elements");
		for(int i=0;i<x;i++)
			arr1[i]=s.nextInt();
		int max=arr1[0];
		for(int i=1;i<x;i++)
			if(arr1[i]>max)
				max=arr1[i];
		System.out.println("max is"+max);
		while(max!=0)
		{
			max=max/10;
			count++;
		}
		System.out.println(count);		
		while(t<=count)
		{
			y=0;
			for(int i=0;i<=9;i++)
			{
				for(int j=0;j<x;j++)
				{
					if((arr1[j]/n)%10==i)
						arr2[y++]=arr1[j];			
				}
			}
			t++;
			n=n*10;
			for(int i=0;i<x;i++)
				arr1[i]=arr2[i];			
		}
		
		System.out.println("Sorted array is");
		for(int k=0;k<x;k++)
			System.out.print(arr1[k]+" ");
	
	}

}