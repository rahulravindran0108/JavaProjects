/* 
title:N-Queen.
Author:Rahul Ravindran
*/

public class Nqueens
{

	static int x[];	
	static int count=0;
	

	static boolean place(int k,int i)
	{
		for(int j=1;j<=k-1;j++)
		{
		if((x[j]==i)||((Math.abs(x[j]-i)==(Math.abs(j-k)))))
				return false;

		}
		return true;
	}
	
	static void Nqueen(int k,int n)
	{
		for(int i=1;i<=n;i++)
		{
			if(place(k,i))
			{
				x[k]=i;
				
				if(k==n)
					show(n);
				else
					Nqueen(k+1,n);
			}

				
		}
	
	}
	
	static void show(int n)
	{
		for(int i=1;i<=n;i++)
			System.out.println("queen "+i+" at location "+x[i]+" of row "+i);
		System.out.println();
		count++;
	}
	
	public static void main(String [] args)
	{
			x=new int[9];
			Nqueen(1,8);
			System.out.println("count:"+count);
	}
	
}