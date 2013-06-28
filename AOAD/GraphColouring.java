/* 
title:Graph Colouring.
Author:Rahul Ravindran
*/

import java.util.*;

public class GraphColouring
{
	static int m;
	static int x[];
	static int n;
	static int g[][];
	static int count;
	
	static void mcolouring(int k)
	{
		for(int i=1;i<=n;i++)
		{
			nextvalue(k);
			if(x[k]==0)
				return;
			if(k==n)
				show();
			else
				mcolouring(k+1);	
		}
	}
	
	static void nextvalue(int k)
	{
		do
		{
			x[k]=(x[k]+1)%(m+1);
			if(x[k]==0)
				return;
			int j;
			for(j=1;j<=n;j++)
				if((x[k]==x[j]) && g[k][j]==1)
					break;
			if(j==n+1)
				return;
		}while(true);
	
	}
	
	static void show()
	{
		for(int i=1;i<=n;i++)
			System.out.print(i+":"+x[i]+" ");
		count++;
		System.out.println();
	}
	
	public static void main(String [] args)
	{
		Scanner s =new Scanner(System.in);
		System.out.println("enter number of colours");
		m=s.nextInt();
		System.out.println("enter number of vertices:");
		n=s.nextInt();
		g=new int[n+1][n+1];
		x=new int[n+1];
		for(int i=1;i<=n;i++)
			for(int j=i+1;j<=n;j++)
			{
				System.out.println("if connected enter 1 else 0 plz for vertice"+(i)+" and "+(j));
				g[i][j]=s.nextInt();
				g[j][i]=g[i][j];
			}
			
		mcolouring(1);		
		System.out.println("total solutions"+count);
	
	}
	


}