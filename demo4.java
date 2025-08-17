import java.util.*;
class demo4
{
public static void main(String[] args)
  {
	int a=10,b=0,c;
    int k[]={1,2,3,4};

	try
	{
		c=a/b;
        int x=k[5]/0;
		System.out.println("result= "+c);
        System.out.println(x);
	}
	// catch(ArithmeticException ae)
	// {
	// 	System.out.println(ae);
	// }
    catch(ArrayIndexOutOfBoundsException ai){System.out.println(ai);}
	finally
	{
		System.out.println("This will execute");
	}
	System.out.println("END");   
}
}

