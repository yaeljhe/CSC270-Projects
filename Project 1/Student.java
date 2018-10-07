/**
 *
 * Name     Yael Hernandez
 * Course:  CSC270 Data Structures
 * Lab:     Number 1
 * File:    Student.java
 *
 */

public class Student {
	
	private String studentID;
	private String name;
	private int quiz1;
	private int quiz2;
	private int midterm;
	private int finalexam;
	private double avg;
	private String grade;
	
	public Student ()
	{
		this ("na", "na", 0, 0, 0, 0, 0.0, "na");
	}
	
	public Student (String id, String n, int q1, int q2, int m, int f)
	{
		this(id, n, q1, q2, m, f, 0.0, "na");
	}
	public Student (String id, String n, int q1, int q2, int m, int f, double a, String letterGrade)
	{
		studentID = id;
		name = n;
		quiz1 = q1;
		quiz2 = q2;
		midterm = m;
		finalexam = f;
		avg = a;
		grade = letterGrade;
	}
	
	public void set(String id, String n, int q1, int q2, int m, int f, double a, String g)
	{
		studentID = id;
		name = n;
		quiz1 = q1;
		quiz2 = q2;
		midterm = m;
		finalexam = f;
		avg = a;
		grade = g;
	}
	
	public void calcAvg()
	{
		avg = (quiz1 * 10 * .125) + (quiz2 * 10 * .125) + (midterm *.25) + (finalexam * .50 ); 
	}
	
	public void calcGrade()
	{
		if (avg > 90) {
		    grade = "A";
		}
		else if (avg > 80) {
			grade = "B";
		}	
		else if (avg > 70) {
			grade = "C";
		}	
		else if (avg > 60) {
			grade = "D";
		}	
		else {
		    grade = "F";
	}}
	
	public String getID()
	{
		return studentID;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getQuiz1()
	{
		return quiz1;
	}
	
	public int getQuiz2()
	{
		return quiz2;
	}
	
	public int getMidterm()
	{
		return midterm;
	}
	
	public int getFinalexam()
	{
		return finalexam;
	}
	
	
	public double getAvg()
	{
		calcAvg();
		return avg;
	}
	
	public String getGrade()
	{
		calcGrade();
		return grade;
	}
	

}
