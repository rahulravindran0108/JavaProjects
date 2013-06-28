/* 
title:Sum of Subset.
Author:Rahul Ravindran
*/

import java.util.*;

public class SumOfSubset
{

	static int m;
	static int x[];
	static int n;
	static int w[];
	
	static void sumofsubset(int s,int k,int r)
	{
		x[k]=1;
		if(s+w[k]==m)
			show(k);
		else if(s+w[k]+w[k+1]<=m)
			sumofsubset(s+w[k],k+1,r-w[k]);
		if((s+r-w[k]>=m) && s+w[k+1]<=m)
		{
			x[k]=0;
			sumofsubset(s,k+1,r-w[k]);
		}				
	}
	
	static void show(int k)
	{
		System.out.println("one possible solution");
		for(int i=0;i<n;i++)
			System.out.print(x[i]+" ");
		for(int i=0;i<n;i++)
			x[k]=0;			
		System.out.println();
	
	
	}
	
	public static void main(String [] args)
	{
		System.out.println("enter the number of objects");
		Scanner s = new Scanner(System.in);
		n=s.nextInt();
		w= new int[n];x= new int[n];
		System.out.println("enter value of m");
		m=s.nextInt();
		System.out.println("enter the values");
		for(int i=0;i<n;i++)			
			w[i]=s.nextInt();			
		int temp=0;
		for(int i=0;i<n;i++)
			temp+=w[i];
		sumofsubset(0,0,temp);
	}	
			
			
}