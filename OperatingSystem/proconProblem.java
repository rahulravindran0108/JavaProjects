/*
Title:Producer Consumer Problem
Author:Rahul Ravindran
*/

class Semaphore
{
	int value;
}

class proconProblem
{
	static Semaphore mutex = new Semaphore();
	static int bufferCapacity=10;
	static int [] buffer=new int[bufferCapacity];
	static int full=0;
	static int empty=bufferCapacity;
	static int ptr=0;
	
	class Producer extends Thread
	{
		
		public void run()
		{
			try{
			while(true)
			{
				if(empty==0)
				{
					System.exit(0);
				}
				else
				{
					if(check()==0)
					{
						System.out.println("producer blocked");
						Thread.sleep(100);
					}
					else
					{
						down();
						System.out.println("producer produced");
						buffer[full]=1;
						full++;
						empty--;				
						Thread.sleep(100);
						up();		
						Thread.sleep(50);
					}
				}
			}}catch(Exception e){}
		}
		
		void down()
		{
			mutex.value-=1;
		}
		
		void up()
		{
			mutex.value+=1;
		}
						
		int check()
		{
			return mutex.value;
		}
		
		
	
	}
	
	class Consumer extends Thread
	{		
		public void run()
		{
			try {
			while(true)
			{
				if(ptr>full)
				{
					Thread.sleep(200);
				}
				else
				{
					if(check()==0)
					{
						System.out.println("consumer blocked");
						Thread.sleep(100);
					}
					else
					{
						down();
						buffer[ptr]=0;
						ptr++;
						System.out.println("consumer consumed");
						Thread.sleep(200);
						up();
					}
				}
			}}catch(Exception e){}
		}
		
		void down()
		{
			mutex.value-=1;
		}
		
		void up()
		{
			mutex.value+=1;
		}
						
		int check()
		{
			return mutex.value;
		}		
		
	}
	
	O11()
	{
		mutex.value = 1;
		new Producer().start();
		new Consumer().start();
	}
	
	public static void main(String [] args)
	{
		O11 o =new O11();
	}
	
	
}