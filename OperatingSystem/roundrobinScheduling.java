/*
Title:Round Robin scheduling
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

class roundrobinScheduling
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
		int slot=3;
		int min=-1;
		
		while(!isAllCompleted())
		{
			min++;
			int count=0;
				if(min==n)
					min=0;
			while((p[min].arrival> time || p[min].remaining==0) && min<n)
			{
				min++;
				if(min==n)
					min=0;
				count++;	
				if(count==n)
					break;
			}
			if(p[min].arrival<=time)
			{
				int t;
				if(p[min].arrival<=time && p[min].remaining!=0 && p[min].remaining<slot)
				{
					t=time;
					time=time+p[min].remaining;
					p[min].remaining=0;
					System.out.println(p[min].pno+" executed from time "+t+" to "+time);					
					
				}
				else
				{
					t=time;
					p[min].remaining-=slot;
					time+=slot;
					System.out.println(p[min].pno+" executed from time "+t+" to "+time);
				}
				
			}
			else
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
		
		
		
		


	
		
		
