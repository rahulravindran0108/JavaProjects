/* 
title:Dijkstra Shortest Path Algorithm.
Author:Rahul Ravindran
*/

import java.util.*;

class Dijkstra
{
public static void main(String args[])
{
	Scanner s=new Scanner(System.in);
	int source,des,v,i,j,min,nv,t,current,x,y,choice;
	int high=1000;
	System.out.println("enter total number of vertices:");
	v=s.nextInt();
	int adj[][]=new int[v+1][v+1];
	int dist[]=new int[v+1];
	int path[]=new int[v+1];
	boolean visited[]=new boolean[v+1];
	System.out.println("enter the weight(0 if not onnecting)");
for(i=1;i<=v;i++)
for(j=i+1;j<=v;j++)
{
System.out.println(i+" to "+j);
adj[i][j]=s.nextInt();		
		}
	for(i=1;i<=v;i++)
	{
		visited[i]=false;
		dist[i]=high;
		path[i]=0;
	}
	System.out.println("enter the vertext to start from:");
	source=s.nextInt();
	current=source;visited[source]=true;nv=1;t=0;
	while(nv!=v)
	{
		for(i=1;i<=v;i++)
		{
			if(adj[current][i]!=0)
			 if(visited[i]!=true)
			  if(dist[i]>adj[current][i]+t)
				{
					dist[i]=adj[current][i]+t;
					path[i]=current;
				}
		}
		min=high;
		for(i=1;i<=v;i++)
		{
			if(visited[i]!=true)
			 if(dist[i]<min)
			 {
				min=dist[i];
				current=i;
			 }
		}
		visited[current]=true;nv=nv+1;t=dist[current];	
	}
	
	System.out.println("enter destiation of the vertext to visit:");
	des=s.nextInt();
	System.out.println("shortest distance from source:"+dist[des]);
	System.out.println("shortest path between source and destination is:");
	y=des;
	do
	{
		x=path[y];
		System.out.println("vertex "+y+" to vertex "+x);
		y=x;
	}
	while(y!=source);
	
}
}
