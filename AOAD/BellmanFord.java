/* 
title:Bellman Ford.
Author:Rahul Ravindran
*/

import java.util.*;

class BellmanFord
{
	static int cost[][];
	static int dist[];
	static int n;
	
	public static void main(String [] args)
	{
		System.out.println("enter number of vertices");
		Scanner s =new Scanner(System.in);
		n=s.nextInt();
		cost=new int[n+1][n+1];
		dist=new int[n+1];
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
			{
				if(i==j)
				{
					
					continue;				
				}
				System.out.println("provid the cost for vertex "+i+" to "+j+" (please five a 1000 value if no edge present");
				cost[i][j]=s.nextInt();				
			}
		System.out.println("resultant matrix is");
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)	
				System.out.print(cost[i][j]+" ");
			System.out.println();
		
		System.out.println("enter the source vertex");
		int v=s.nextInt();
		BellmanFord(v);
	
	}
	
	static void BellmanFord(int v)
	{
		int u=1;
		for(int i=1;i<=n;i++)
			dist[i]=cost[v][i];
		int i=1;
		for(int k=2;k<=n-1;k++)
		{
			for(;u<=n;u++)
			{
				if(u==v)
					continue;
				if(incoming(u))
					for(i=1;i<=n;i++)
					{
						if(cost[i][u]==0)
							continue;
						if(dist[u]> dist[i]+cost[i][u])
							dist[u]=dist[i]+cost[i][u];
					}
			}
		}
			

		show();	
	}
	
	static boolean incoming(int u)
	{
		for(int i=1;i<=n;i++)
			if(cost[i][u]!=0)
				return true;
		return false;
	}
	
	static void show()
	{
		System.out.println("resultant distance array is is");
		for(int i=1;i<=n;i++)
		{
			System.out.print(dist[i]+" ");				
		}
	}
	



}