import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Set;

public class JavaBasic {
	
	
	
	private static void arrayListExample() {
	ArrayList ar=new ArrayList();
		ar.add("abc");
	ar.add(123);
		ar.add('g');
		
		for(Object obj: ar) {
			System.out.println(obj);
		}
			
	}
	private static void HashMapExample() {
		
		HashMap<Integer,String>hm=new HashMap<Integer,String>();
		hm.put(1, "Selenium");
		hm.put(2, "QTP");
		hm.put(4, "RFT");
		hm.put(5, null);
		hm.put(3, "UFT");
		hm.put(null, null);
		
		
		System.out.println("Key 1 has value-"+hm.get(1));
		System.out.println(" Values are-"+hm.values());
		System.out.println(hm.containsValue("selenium"));	
		
	}
	public static void hashMapAdvance() {

		HashMap<Integer, Employee>emp=new HashMap<Integer, Employee>();
		Employee e1=new Employee("Tom", 27, "Marketting");
		Employee e2=new Employee("Karim", 29, "Admin");
		Employee e3=new Employee("Ebad", 7, "Toy");
		emp.put(1, e1);
		emp.put(2, e2);
		emp.put(3, e3);
		
		for(Entry<Integer, Employee> m : emp.entrySet()) {
			int key=m.getKey();
			Employee e = m.getValue();
			System.out.println(key +" no employee info:");
			System.out.println(e.name+" "+e.age+" "+e.depertment );	
		}
		
	}
	public static void HashTableExample() {
		Hashtable <Integer,String>ht=new Hashtable<Integer,String>();
		ht.put(1, "Tom");
		ht.put(2, "Sam");
		ht.put(3, "Alan");
		ht.put(5, "Nick");
		ht.put(1, "Tod");
		ht.put(7, "Ebad");
		//ht.put(null, "Ebad");==No null Key or Value==No same key value pair 
		
		boolean b= (ht.contains("alan"));
		System.out.println(b);
		System.out.println("Value in Key 3:"+ht.get(3));
		System.out.println(ht.hashCode());
		Enumeration e=ht.elements();
		System.out.println("Getting values by enumeration======");
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
		System.out.println("Getting values by entrySet=========");
		Set s=ht.entrySet();
		System.out.println(s);
	}
	public static void hashtableEquality() {
		Hashtable <Integer,String>ht=new Hashtable<Integer,String>();
		ht.put(1, "Tom");
		ht.put(2, "Sam");
		ht.put(3, "Alan");
		ht.put(5, "Nick");
		ht.put(1, "Tod");
		ht.put(7, "Ebad");
		Hashtable <Integer,String>ht1=new Hashtable<Integer,String>();
		ht.put(1, "Tom");
		ht.put(2, "Sam");
		ht.put(3, "Alan");
		ht.put(5, "Nick");
		ht.put(7, "Ebad");
		if(ht.equals(ht1)) {
			System.out.println("ht and ht1 are Equal Hashtable");
		}
		else System.out.println("ht and ht1 are Not Equal Hashtable");
		
	}
	
	

	public static void main(String[] args) {
		
		System.out.println("Printing from arrayListExample ==========");
		JavaBasic.arrayListExample();
		System.out.println("Printing from HashMapExample=============");
		JavaBasic.HashMapExample();
		System.out.println("Printing from hashMapAdvance==========");
		JavaBasic.hashMapAdvance();
		System.out.println("Printing from HashTableExample===========");
		JavaBasic.HashTableExample();
		System.out.println("Printing from hashtableEquality==============");
		JavaBasic.hashtableEquality();
		
	}

}
