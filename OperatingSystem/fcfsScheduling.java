/*
Title:FCFS SCHEDULING
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

class fcfsScheduling
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
		
		fcfs();
	}
	
	static void fcfs()
	{
		Process temp=new Process();
		for(int i=0;i<n;i++)
			p[i].remaining=p[i].burst;
			
		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(p[i].arrival>p[j].arrival)
				{
					temp=p[i];
					p[i]=p[j];
					p[j]=temp;
				}
			}
		}	
		for(int j=0;j<n;j++)
		{	
			if(j==0)
				p[j].start = p[j].arrival;
			else
				p[j].start=p[j-1].start+p[j-1].burst;
		}
		
		display();
		int [] waiting = new int[n];
		
		for(int j=0;j<n;j++)
			waiting[j]=p[j].start-p[j].arrival;
		
		float average=0;
			
		for(int j=0;j<n;j++)
			average+=waiting[j];
		
		average=average/n;
		System.out.println("average waiting time"+average);
	}
		
		
	static void display()
	{
		System.out.println("pno\t arrival\t burst \tstart");
		for(int j=0;j<n;j++)
		{
			System.out.print(p[j].pno+"\t"+p[j].arrival+"\t"+p[j].burst+"\t"+p[j].start);
			System.out.println();
		}
	}
	

}