/*
Title:Clock Page Replacement
Author:Rahul Ravindran
*/
import java.util.*;

class clock
{
	static int pageSize=3;
	static int [] frame =new int[pageSize];
	static int [] sequence;
	static int n;
	static Scanner s =new Scanner(System.in);
	static int [] used_bits = new int[pageSize];
	static int ptr;	
	static int pageHit;
	static int pageFault;
	
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
			
		for(int i=0;i<pageSize;i++)
			used_bits[i]=0;			
			
		for(int j=0;j<n;j++)
		{
			clock(j);		
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
	
	static void clock(int i)
	{
		int j;
		
		if(ptr==pageSize)
		ptr=0;
		
		for(j=0;j<pageSize;j++)
			if(sequence[i]==frame[j])
			{
				pageHit++;
				return;								
			}
			
		while(true)
		{
			if(used_bits[ptr]==0)
			{
				frame[ptr]=sequence[i];
				used_bits[ptr]=1;
				pageFault++;				
				break;
			}
			else
			{
				used_bits[ptr]=0;
				ptr++;
				if(ptr==pageSize)
				ptr=0;
			}
		}
		
	}
	
	static boolean isEmpty()
	{
		for(int j=0;j<pageSize;j++)
			if(frame[j]==-1)
				return true;
		return false;		
	}
	

}