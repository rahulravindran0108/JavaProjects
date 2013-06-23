/*
Title:implementation of Philosophers Problem.
Author:Rahul Ravindran.
*/
class Philosophers
{
	static int [] fork = {0,0,0,0,0};
	static int i=1;
	static int status [][] = new int[6][2];
	
	
	
	O2()
	{
		philosopher(i);
	}	
	
	public static void main(String [] args)
	{
		O2 x = new O2();	
	}
	
	static void philosopher(int i)		
	{
		while(i<6)
		{
			think(i);
			wait(i-1,i);
			wait(i%5,i);
			eat(i);
			signal(i%5,i);
			signal(i-1,i);
			i++;
		}					
	}
	
	static void think(int i)
	{
		System.out.println("philosopher "+i+" thinking");
	}
	
	static void wait(int a,int b)
	{
			if(fork[a]==1)
			{
				System.out.println("philosopher "+b+" waiting on fork"+(a+1));
			}
			else
			{
				fork[a]=1;
				System.out.println("philosopher "+b+" picked up fork"+(a+1));
				status[b][a/b]=1;
			}
	}

	static void signal(int a,int b)
	{
		fork[a]=0;
		System.out.println("Philosopher "+b+" has put down fork "+(a+1));
		status[b][a/b]=0;
	}
	
	static void eat(int a)
	{
		if(status[a][0] == 1 && status[a][1] == 1)
			System.out.println("Philosopher "+a+" eating");
	}
	
	
	
	
}