import java .io.*;
public class array7
{
public static void main()throws IOException
{
BufferedReader ob=new BufferedReader(new InputStreamReader(System.in));
System.out.println("enter limit");
int n=Integer.parseInt(ob.readLine());
int a[]=new int[n];int i;
System.out.println("enter elements");
for(i=0;i<n;i++)
{
a[i]=Integer.parseInt(ob.readLine());
}
System.out.println("print elements");
int s=0;int f=0;
for(i=0;i<n;i++)
{
s=s+a[i];
f=s/n;
}
System.out.println(f);
}
}


