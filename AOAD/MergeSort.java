/* 
title:Merge Sort.
Author:Rahul Ravindran
*/


import java.util.*;

public class MergeSort
{
	static int a[];
	static int b[];
	static int n;
	
	static void mergesort(int low,int high)
	{
		if(low<high)
		{
			int mid=(low+high)/2;
			mergesort(low,mid);
			mergesort(mid+1,high);
			merge(low,mid,high);
			
		}
	}
	
	static void merge(int low,	int mid,int high)
	{
		int h=low;int i=low;int j=mid+1;
		while(h<=mid && j<=high)
		{
			if(a[h]<a[j])
				b[i++]=a[h++];
			else
				b[i++]=a[j++];		
		}
		
		if(h>mid)
		{
			for(int k=j;k<=high;k++)
				b[i++]=a[k];
		}
		else
		{
			for(int k=h;k<=mid;k++)
				b[i++]=a[k];			
		}
		
		for(int x=low;x<=high;x++)
			a[x]=b[x];
	
	}
	
	static void show()
	{
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	
	public static void main(String [] args)
	{
		System.out.println("enter the size of the array");
		Scanner s = new Scanner(System.in);
		n=s.nextInt();
		a=new int[n];
		b=new int[n];
		System.out.println("enter the elements");
		for(int i=0;i<n;i++)
			a[i]=s.nextInt();
		mergesort(0,a.length-1);
		show();
		
	}
}