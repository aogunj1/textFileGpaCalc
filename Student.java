package project;

	// Implement the class Student by extending the class Person 
	import java.io.*;
import java.util.ArrayList;

	public class Student extends Person
	{
		 // Fields
		  //    -- Your Code Here
		int studentId;//
		boolean isTuitonPaid;// make these private!!!?
		String studentName;
		int numofCourses;
		double gpa;
	
		ArrayList<Course> Scourse = new ArrayList<Course>();
		
		  //    -- Your Code Here
		public Student() {
			super();
		}
		public void setStudentName(int name) {
			
		}
		public String getStudentName() {
			return studentName;
		}
		public void setStudentId(int id) {
			 studentId = id;
		}
		public int getStudentId() {
			return studentId;
		}
		public void setTuitonPaid(Boolean paid) {
			isTuitonPaid = paid;
		}
		public void setNumOfCourses(int NumofCourses) {
			numofCourses = NumofCourses;
		}
		public int getNumOfCourses() {
			return numofCourses;
		}
		public boolean getTuitionPaid() {
			return isTuitonPaid;
		}
		
		
		/*
		public void addToArrayCourse(String course) {
			this.course.add(course);
		}*/
		//only need top or bottom
		public void addToArrayCourse(Course course) {
			this.Scourse.add(course);
		}
		public void printArrayCourse() {
			for (int i=0;i<Scourse.size();i++) {//Change to Scourse?
				System.out.println(Scourse.get(i));//Scourse??
			}
		}
		
		
		

		public void calcGpa() {
			double courseCred = 0;
			double Totcredits = 0;
			int total =0;
			for(int i =0;i<Scourse.size();i++) {
				
				switch(Scourse.get(i).getGrade())
				{
				
				case  "A":	
					courseCred = 4.0;
			break;
				
				case  "B":
					courseCred = 2.67;
			break;
	
				case  "C":
					courseCred = 2.0;
			break;
	
				case  "D":
					courseCred = 1.33;
			break;
			
				}
				
				Totcredits = (Scourse.get(i).getCredits() * courseCred) + Totcredits;
				
			}
			gpa = Totcredits / Scourse.size();
			
		}
		public double getGpa() {
			return gpa;
		}
	
		public double gettotalCreditHours() {///Check if this works
			
			double totalCredits=0;
			for(int i =0;i<Scourse.size();i++) 
			{
			 totalCredits +=Scourse.get(i).getCredits();
			}
			return totalCredits;
			}
		public int totalCoursesEnrolled() {
			return Scourse.size();
		}
		public double TuitonAmountDue() {
			double tuiton = 360;
			double tuitonAmountDue = Scourse.size() * tuiton;
			return tuitonAmountDue;
			
		}
	
	
		 }
	


