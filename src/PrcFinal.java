
public class PrcFinal {

	public static void strReverse(String str) {
		
		
		StringBuffer sb=new StringBuffer(str);
		System.out.println( sb.reverse());
		
		
	}
	
	
	public static void main(String[] args) {
		//PrcFinal.strReverse("otherwise");
		
//		int n=789008;
//		int rev=0;
//		while(n!=0) {
//			 rev=rev*10+n%10;
//			n=n/10;
//		}
//		System.out.println(rev);
		String s="he is a boy";
		String r="";
		for(int i=s.length()-1;i>=0; i--) {
			r=r+s.charAt(i);
		}
		System.out.println(r);
		
		

	}

}
