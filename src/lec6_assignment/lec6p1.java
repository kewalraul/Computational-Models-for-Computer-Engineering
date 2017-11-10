package lec6_assignment;

public class lec6p1 {
	
	public long mult(long x, long y) {
		
		if(y==1) {
			return x;
		}else {
			return(x+mult(x, y-1));
		}	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 lec6p1 obj= new lec6p1();
		 long a=3;
		 long b=4;
		 long out=obj.mult(a,b);
		 System.out.println("Multiplication Output of ("+a+","+b+") :" +out);
	}

}
