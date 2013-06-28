/* 
title:KrushKal's Algorithm.
Author:Rahul Ravindran
*/

import java.util.*;

class edge
{
	int a,b,wt;
}

class Krushkal
{
	static int path[];
	
	public static void main(String [] args)
	{
		Scanner s =new Scanner(System.in);
		System.out.println("enter number of vertices and edges");
		int n=s.nextInt();
		int m=s.nextInt();
		edge temp = new edge();
		edge e[] = new edge[m];
		for(int i=0;i<m;i++)
		{
			e[i]=new edge();
			System.out.println("enter the weights from vertex a to b");
			e[i].a=s.nextInt();
			e[i].b=s.nextInt();
			e[i].wt=s.nextInt();			
		}
		
		path=new int[n+1];
		
		for(int i=0;i<m-1;i++)
			for(int j=i+1;j<m;j++)
			{
				if(e[i].wt>e[j].wt)
				{
					temp=e[i];
					e[i]=e[j];
					e[j]=temp;				
				}
			}	
		for(int i=0;i<m;i++)
			System.out.println(e[i].wt);
		int i=0,j=0;
		int mincost=0;
		while((i!=n-1) && j!=m)
		{
			if(check(e[j].a,e[j].b,e[j].wt))
			{
				System.out.println("edge from "+e[j].a+" to "+e[j].b+" has been added");
				mincost+=e[j].wt;
				i++;
			}
			else
			{

				j++;			
			}
		}
		
		if(i!=n-1)
			System.out.println("not possible");
		System.out.println("mincost is "+mincost);		
	}
	
	static boolean check(int a,int b,int wt)
	{
		while(path[a]>0)
			a=path[a];
		while(path[b]>0)
			b=path[b];
		if(a!=b)
		{
			path[a]=b;
			return true;
		}
		return false;
	}
	
}
