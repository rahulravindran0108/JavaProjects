/* 
title:All Pair Shortest Path.
Author:Rahul Ravindran
*/

import java.util.*;

class AllPairShortestPath
{
	static int cost[][];
	static int a[][];
	static int n;
	
	public static void main(String [] args)
	{
		System.out.println("enter number of vertices");
		Scanner s =new Scanner(System.in);
		n=s.nextInt();
		cost=new int[n+1][n+1];
		a=new int[n+1][n+1];
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
			{
				if(i==j)
					continue;				
				System.out.println("provid the cost for vertex "+i+" to "+j+" (please five a 1000 value if no edge present");
				cost[i][j]=s.nextInt();				
			}
		Allpaths();
	
	}
	
	static void Allpaths()
	{
	
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
				a[i][j]=cost[i][j];
		for(int k=1;k<=n;k++)
			for(int i=1;i<=n;i++)
				for(int j=1;j<=n;j++)
					a[i][j]=min(a[i][j],a[i][k]+a[k][j]);
		show();	
	}
	
	static void show()
	{
		System.out.println("resultant matrix is");
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
				System.out.print(a[i][j]+" ");
			System.out.println();	
		}
	}
	
	static int min(int a,int b)
	{
		if(a<b)
			return a;
		else
			return b;	
	}


}