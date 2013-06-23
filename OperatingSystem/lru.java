/*
Title:LRU Replacement Policy
Author:Rahul Ravindran
*/
import java.util.*;

class lru
{
	static int pageSize=3;
	static int [] frame =new int[pageSize];
	static int [] sequence;
	static int n;
	static Scanner s =new Scanner(System.in);
	static int ptr;	
	static int pageHit;
	static int pageFault;
	static int [] hits = new int[pageSize];
	
	public static void main(String [] args)
	{
		System.out.println("enter the number of requests");
		n=s.nextInt();
		sequence = new int[n];
		System.out.println("enter the requests");
		for(int i=0;i<n;i++)
			sequence[i]=s.nextInt();
		
		for(int i=0;i<pageSize;i++)
			frame[i]=-1;
			
		for(int j=0;j<n;j++)
		{
			lru(j);		
			display();		
		}
		System.out.println("page fault:"+pageFault);
		System.out.println("page Hit:"+pageHit);
	}
	
	static void display()
	{
		for(int i=0;i<pageSize;i++)
			System.out.print(frame[i]+" ");
		System.out.println();
	}
	
	static void lru(int i)
	{
		if(isEmpty())
		{
			frame[ptr]=sequence[i];
			pageFault++;
			ptr++;
			if(ptr==pageSize)
				ptr=0;
			return;
		}
		int j;
		for(j=0;j<pageSize;j++)
			if(sequence[i]==frame[j])
			{
				pageHit++;
				return;
			}

		System.out.println();
		for(j=0;j<pageSize;j++)
		{
			for(int k=0;k<i;k++)		
			{
				
				if(sequence[k]==frame[j])
				{					
					hits[j]=k;
				}
			}	
		}


		System.out.println();
		int min=hits[0];
		int minloc=0;
		int k;
		for(k=0;k<pageSize;k++)
			if(hits[k]<min)
			{
				min=hits[k];
				minloc=k;
			}
			
		ptr=minloc;
		frame[ptr]=sequence[i];
		pageFault++;
		ptr++;
		if(ptr==pageSize)
			ptr=0;
		
				
	}
	
	static boolean isEmpty()
	{
		for(int j=0;j<pageSize;j++)
			if(frame[j]==-1)
				return true;
		return false;		
	}
	

}