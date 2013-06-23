/*
Title:Shortest Remaining Job first Scheduling
Author:Rahul Ravindran
*/

import java.util.*;

class Process
{
	int pno;
	int arrival;
	int start;
	int burst;
	int remaining;
}

class srtfScheduling
{
	static Process [] p;
	static int n;
	
	public static void main(String [] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("enter the number of processes");
		n=s.nextInt();
		p=new Process[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("enter the process number,arrival,burst time of each process");
			p[i]=new Process();
			p[i].pno=s.nextInt();
			p[i].burst=s.nextInt();
			p[i].arrival=s.nextInt();

		}
		
		srtf();
	}
	
	static void srtf()
	{
		Process temp=new Process();
		for(int i=0;i<n;i++)
			p[i].remaining=p[i].burst;
		int time=0;
		
		while(!isAllCompleted())
		{
			int min=0;
			while((p[min].arrival> time || p[min].remaining==0) && min<n)
			{
				min++;
				if(min==n)
					break;
			}
			int i=min+1;
			while(i<n)
			{
				if(p[i].arrival<=time && p[i].remaining<p[min].remaining && p[i].remaining!=0)
					min=i;
				i++;
			}
			if(min<n)
			{
				if(p[min].arrival<=time && p[min].remaining!=0)
				{
					p[min].remaining-=1;
					System.out.println(p[min].pno+" has executed from time "+time+" to "+(time+1));
				}
			}
			time++;
		}
	}
	
	static boolean isAllCompleted()
	{
		for(int i=0;i<n;i++)
			if(p[i].remaining!=0)
				return false;
		return true;
	}
				
		
			
		
		
}
		
		
		
		


	
		
		
