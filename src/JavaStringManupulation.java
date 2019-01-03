import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JavaStringManupulation {
	//REVERSE STRING by String 
	private static void reverseString(String s) {
		String rev="";
		int l=s.length();
		//Array a[l-1]=s.toCharArray();
		for(int i=l-1;i>=0;i--) {
			rev=rev+s.charAt(i);
		}
		System.out.println("Reverse String of given----> "+s+" is: "+rev);
	}
	//REVERSE STRING by StringBuffer
	public static void reverseWithStringBuffer(String s) {
		StringBuffer sb=new StringBuffer(s);
		System.out.println("Reverse String of given----> "+s+" is: "+sb.reverse());	
	}
	//String modify by removing Space
	public static void stringModify(String s) {
		String s1=s.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(s1);
	}
	//Reverse Intiger
	public static void reverseInt(int n) {
int rev=0;	
		while(n!=0) {
			rev=rev*10 + n%10;
			n=n/10;
		}
		System.out.println(rev);
	}
	
	public static void main(String[] args) {
		//Method 1: 
		//reverseString("zeela rafija");
		//Method 2:
		//reverseWithStringBuffer("Ebadul Karim");
		//Method 3: 
		//stringModify("He asked me!@# how are you?");
		//Method 4: 
		//reverseInt(587);
		//Finding no of occurance or Duplicate String
		String str[]= {"java", "parl", "rubi", "java", "rubi","java"};
		HashSet<String>hm=new HashSet<String>();
		for(String name: str) {
			int count=0;
			if(hm.add(name)==false) {
				System.out.println("Duplicate element is: "+name);
				count++;}	}	
System.out.println(hm);
	}

}
