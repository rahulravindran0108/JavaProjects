/* 
title:Knutt Morris Pratt.
Author:Rahul Ravindran
*/

import java.util.*;

class KnuttMorrisPratt
{
	static int pi[];
	static int q;
	static String s,p;
	
	public static void main(String [] args)
	{
		Scanner sc =new Scanner(System.in);
		System.out.println("enter the string");
		s=sc.next();
		System.out.println("enter the string to be searched");
		p=sc.next();
		pi=new int[s.length()];
		KMP(s,p);
	}
		
	
	static void prefix(String p)
	{
			int m=p.length();
			pi[1]=0;
			int k=0;
			for(int q=2;q<m;q++)
			{
				while(k>0 && p.charAt(k+1)!=p.charAt(q))
					k=pi[k];
				if(p.charAt(k+1)!=p.charAt(q))
					k+=1;
				pi[q]=k;
			}
	}
	
	static void KMP(String s,String p)
	{
		int n=s.length();
		int m=p.length();
		q=0;
		prefix(p);
		for(int i=0;i<n;i++)
		{
			while(q>0 && p.charAt(q+1)!=s.charAt(i))
				q=pi[q];
			if(p.charAt(q+1)==s.charAt(i))
				q+=1;
			if(q==m-1)
			{
				System.out.println("String occurs at a shift "+(i-m));
				q=pi[q];
			}
		
		
		}
	
	
	}
	

}