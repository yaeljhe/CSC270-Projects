/**
 *
 * Name     Yael Hernandez
 * Course:  CSC270 Data Structures
 * Lab:     Number 1
 * File:    Complex.java
 *
 */

public class Complex {
	
	private int real;
	private int imaginary; 
	
	public Complex() {
		real = 0; 
		imaginary = 0; 	
	}
	
	public Complex(int x, int y) {
		real = x;
		imaginary = y;		
	}
	
	public Complex add (Complex x, Complex y) {
		real = x.real + y.real;
		imaginary = x.imaginary + y.imaginary;
		return this;
	}
	
	public Complex subtract (Complex x, Complex y) {
		real = x.real - y.real;
		imaginary = x.imaginary - y.imaginary;
		return this;
	}
	
	public void display () {
		System.out.println("("+real+" "+imaginary+")");
	}
	
	public static void printResult (Complex output) {
		output.display();
	}
	
	public static void main(String[]args)
	{
	Complex c1= new Complex(3, -5);
	Complex c2= new Complex(8, 7);
	Complex sum = new Complex();
	sum.add(c1, c2);
	Complex diff = new Complex();
	diff.subtract(c1, c2);
	System.out.println("The sum is ");
	Complex.printResult(sum);
	System.out.println("The difference is ");
	Complex.printResult(diff);
	}
	
}
