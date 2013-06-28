/* 
title:KnapSack Problem.
Author:Rahul Ravindran
*/

import java.util.*;

public class KnapSack
{
	static float w[];
	static int n,p[];
	
	public static void main(String [] args)
	{
		Scanner s =new Scanner(System.in);
		System.out.println("enter number of objects");
		n=s.nextInt();
		System.out.println("enter knapsack capacity");
		int m=s.nextInt();
		w=new float[n];
		p=new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("enter weights and profits of object"+(i+1));
			w[i]=s.nextFloat();
			p[i]=s.nextInt();
		}

		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if((p[j]/w[j])>(p[i]/w[i]))
				{
					float temp=w[i];
					w[i]=w[j];
					w[j]=temp;
					int t=p[i];
					p[i]=p[j];
					p[j]=t;
				}
			}
		}
		for(int i=0;i<n;i++)
		{
			System.out.println("weight:"+w[i]+" profit"+p[i]);
		}
		
		float u=m;
		float x[]=new float[n];
		
		int profits=0;
		for(int i=0;i<n;i++)
		{
			if(u-w[i]>0)
			{
				x[i]=1;
				profits+=p[i];
				u=u-w[i];
			}
			else
			{
				float fraction=(float)u/w[i];
				x[i]=fraction;
				profits+=fraction*p[i];
				break;
			}
			
		}
				
		System.out.println("profit is "+profits);
		
		for(int i=0;i<n;i++)
			System.out.println(x[i]+" for weight "+w[i]);
		}
			
}

	




