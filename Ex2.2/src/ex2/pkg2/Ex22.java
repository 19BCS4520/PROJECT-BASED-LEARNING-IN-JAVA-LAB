/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2.pkg2;

/**
 *
 * @author dell
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
public class Ex22 {

    /**
     * @param args the command line arguments
     */
    Scanner sc;
    String str;
    public void append(ArrayList AL)
	{
		char ans;
		do
		{
			System.out.println("Enter string:");
			sc = new Scanner(System.in);
			str=sc.next();
			AL.add(str);

			System.out.println("Do u wanna append more strings?");
			ans=sc.next().charAt(0);
		}while(ans=='y');

		System.out.println("The array elements are:" +AL);
		System.out.println("The array size is:" +AL.size());
	}
    public void insert(ArrayList AL)
	{
		System.out.println("Enter string:");
		sc = new Scanner(System.in);
		str=sc.next();
		
		while(true)
		{
			try
			{	
			System.out.println("Enter index at which the string to be inserted:");
			sc=new Scanner(System.in);
			int index = sc.nextInt();
			AL.add(index,str);
			System.out.println("The array elements are:" +AL);
			break;
	    		}
     			catch(Exception e)
    			{
				System.out.println("Invalid index");
	     		}
                }
        }
    
	public void search(ArrayList AL)
	{
		//append(AL);
		String searchstr;
		System.out.println("Enter string for searching:");
		sc=new Scanner(System.in);
		searchstr=sc.next();
		
		boolean found = false;
		
		Iterator <String> iter = AL.iterator();
		
		String curitem = "";
		int pos = 0;
		
		while(iter.hasNext() == true)
		{
			pos=pos+1;
			curitem=(String)iter.next();
			
			if(curitem.equals(searchstr))
			{
				found=true;
				break;
			}
		}
		if(found)
		{
			System.out.println(searchstr + "String found in position:" +pos);
		}
		else
		{
			System.out.println(searchstr + "String not found");
		}

	}
        public void findParticular(ArrayList AL)
	{
		//append(AL);
		String[] str_list = new String[AL.size()];
                str_list = (String[]) AL.toArray(str_list);  
		
		System.out.println("Enter starting letter to search:"); //Searching
		sc=new Scanner(System.in);
		String searchchar=sc.next();

		System.out.println("The string's starting with letter's "  +searchchar + " are:");
		for(int i=0; i<str_list.length; i++)
		{
			if(str_list[i].startsWith(searchchar)) //Checking first letter match
			System.out.println(str_list[i]); //if found display
		}
	}
}
class ArrayListDemo
{
	public static void main(String args[])
	{
	System.out.println("\n---Implementing ArrayList for List of Strings---");
	ArrayList AL = new ArrayList<String>( );
	AList obj = new AList();
	char ans;
	do
	   {
		System.out.println("Main Menu");
		System.out.println("1.Append \n 2.Insert at particular index \n 3.Search \n 4.List strings");
		System.out.println("Enter your choice");
		Scanner sc = new Scanner(System.in);
		int ch = sc.nextInt();
	
		switch(ch)
		{
			case 1: obj.append(AL);
				break;
			case 2: obj.insert(AL);
				break;
			case 3: obj.search(AL);
				break;
			case 4: obj.findParticular(AL);
				break;
		}
		System.out.println("Do you wanna go to Main Menu?(y/n):");
		ans=sc.next().charAt(0);
	    }while(ans=='y');
	}
}
        
    

    

