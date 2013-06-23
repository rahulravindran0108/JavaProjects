
/* 
title:IMPLEMENTATION OF BANKERS ALGORITHM.
Author:Rahul Ravindran
*/

import java.util.*;

class Bankers
{
	static int [][] max;
	static int [][] current;
	static int [] avail;
	static int [][] need;
	static int n;
	static int r;
	static boolean [] finished;
	
	public static void main(String [] args)
	{
		Scanner s =new Scanner(System.in);
		System.out.println("enter number of process:");
		n=s.nextInt();
		System.out.println("enter number of resources:");
		r=s.nextInt();
		finished = new boolean[n];
		for(int k=0;k<n;k++)
			finished[k]=false;
		max=new int[n][r];
		need=new int[n][r];
		current=new int[n][r];
		avail=new int[r];
		for(int i=0;i<n;i++)
		{
			System.out.println("enter resource allocation for "+"process "+(i+1)+" for resources 1 to "+r);
			for(int j=0;j<r;j++)
				current[i][j]=s.nextInt();
		}
		for(int i=0;i<n;i++)
		{
			System.out.println("enter max allocation of resources for "+"process "+(i+1)+" for resources 1 to "+r);
			for(int j=0;j<r;j++)
				max[i][j]=s.nextInt();
		}		
		System.out.println("enter available number of eact type of resource(1 to "+r+")");
		for(int j=0;j<r;j++)
			avail[j]=s.nextInt();
		for(int i=0;i<n;i++)
			for(int j=0;j<r;j++)
				need[i][j]=max[i][j]-current[i][j];
		int i;
		for(i=0;i<n;i++)
		{
			if(isallCompleted())
				break;
			if(finished[i]!=true && check(i))
			{
				add(i);
				finished[i]=true;
				System.out.println("process "+(i+1)+" executed");
				i=0;
			}							
		}
		if(i==n)
			System.out.println("deadlock");
	}
	
	static boolean check(int i)
	{
		int [] checker = new int[r];
		
		for(int j=0;j<r;j++)
		{
			if(need[i][j]-avail[i]<=0)
			{
				continue;
			}
			else
				return false;
		}
		
		return true;
		
	}
		
	static boolean isallCompleted()
	{
		
		for(int i=0;i<finished.length;i++)
			if(finished[i]==false)
				return false;
		return true;
	}
	
	static void add(int i)
	{
		for(int j=0;j<r;j++)
			avail[j]+=current[i][j];
	}
	
	
		
	
}	
		
			



