package project;

	// Complete the Program with main functions

	import java.io.*;
	import java.util.*;

	public class GradeReportProgram
	{
	  public static void main(String[] args) throws FileNotFoundException,IOException {
	    // Add your code Here to generate the report.
		  FileWriter f = new FileWriter("OutputGrade.txt");
		  Scanner fileReader = new Scanner(new File("src/project/stData.txt"));//change to match different IDE. This is for eclipse.
		  double total = 0;
		  int numofStudents; 
		  int tuitonRate;
		  String firstName;
		  String lastName;
		  int studentId;
		  String isTuitonPaid;
		  int numofCoursesTaken=0;
		  String courseName;
		  String courseId;
		  String grade;
		  int creditAmount = 0;
		  double courseCredAsNum = 0;
		double totalCreditsHours = 0;
			double gpa=0;
			double totalPointsTowardGpa=0;
			double pointsTowardGpa=0;
	
		 // Course tempCourse = new Course();
	 
		  numofStudents = fileReader.nextInt();
          tuitonRate = fileReader.nextInt();
         
          System.out.println(numofStudents);
          System.out.println(tuitonRate);
       
          
          f.write("Amount of students is " + numofStudents);
          f.write("\n");
          f.write("The tuiton Rate is " + tuitonRate);
          f.write("\n");
          
      
      Student[] studentArray = new Student[numofStudents];
      Course[] courseArray = new Course[numofCoursesTaken];
     
      
      for (int i=0;i<numofStudents;i++) {
    	  
    	  firstName= fileReader.next();
    	  lastName= fileReader.next();
    	  studentId = fileReader.nextInt();	
    	  isTuitonPaid = fileReader.next();
    	  
    	  try {numofCoursesTaken = fileReader.nextInt();
    	  courseArray = new Course[numofCoursesTaken];
    	  }
    	  catch(Exception e) 
    	  {
    		  
    	  }
    	  
    	  studentArray[i]= new Student();
    	  studentArray[i].setName(firstName, lastName);
    	  studentArray[i].setName(firstName, lastName);
    	  studentArray[i].setStudentId(studentId);
    	  studentArray[i].setTuitonPaid(isTuitonPaid.equals("Y"));
    	  studentArray[i].setNumOfCourses(numofCoursesTaken);
    	System.out.println();
    	System.out.println(firstName + " " + lastName + " "  + studentId );//Can add isTuitonPaid + numofCoursesTaken
    	System.out.println();
    	System.out.println("This student takes " + numofCoursesTaken + " classes");
    	  
    	f.write("\n");
    	f.write(firstName + " " + lastName + " "  + studentId + " " + isTuitonPaid + " " + numofCoursesTaken +"\n");
    	f.write("\n");
    	f.write("This student takes " + numofCoursesTaken + " classes"+ "\n");
    	  
    	
    	
    	for(int j=0;j<numofCoursesTaken;j++) {
    		  
    		 try {
    			 courseArray[j]=new Course();
    			 courseName = fileReader.next();
       		  courseId = fileReader.next();
       		  creditAmount =  fileReader.nextInt();
       		  
       		  grade = fileReader.next();
       		 
       		  if(studentArray[i].isTuitonPaid) {
       		  System.out.println(courseName + " "+ courseId +" "+ creditAmount+" "+grade + " ");
             	f.write(courseName + " "+ courseId +" "+ creditAmount+" "+grade + " \n");  
       		  }
       		  else {
             System.out.println(courseName + " "+ courseId +" "+ creditAmount+" "+"***" + " ");
       		  f.write(courseName + " "+ courseId +" "+ creditAmount+" "+"***" + " \n");
       		  
       		  }	
       		
  
       		courseArray[j].setCourseInfo(courseName, courseId, creditAmount, grade);
       				
       		courseCredAsNum = 0;
			totalCreditsHours = 0;
			
			for(int k =0;k<numofCoursesTaken;k++) {
				
				
				switch(grade)
				{
				
				case  "A":	
					courseCredAsNum = 4.0;
			break;
				
				case  "B":
					courseCredAsNum = 3;
			break;
	
				case  "C":
					courseCredAsNum = 2.0;
			break;
	
				case  "D":
					courseCredAsNum = 1.0;
			break;
			
				}
				
				pointsTowardGpa = courseCredAsNum* creditAmount;
				totalPointsTowardGpa += pointsTowardGpa;
				//gpa= totalPointsTowardGpa / totalCreditsHours;
				
				
			}
       		
    		 }catch(Exception e) 
    		 {
    			 
    		 }
    	  }
    	gpa =0;
    	int totalcourseCredAsNum = 0;
    	for(int k =0; k < courseArray.length;k++) {
    		switch(courseArray[k].getGrade())
			{
			case  "A":	
				courseCredAsNum = 4.0;
		break;
			
			case  "B":
				courseCredAsNum = 3.0;
		break;

			case  "C":
				courseCredAsNum = 2.0;
		break;

			case  "D":
				courseCredAsNum = 1.0;
		break;
		
			}
    		 
    		total += courseCredAsNum * creditAmount;
    		totalCreditsHours+=courseArray[k].getCredits();
    		
    	}
    	System.out.println();
    	System.out.println("Total Amount of credits hours is : " + totalCreditsHours);
    	
    	f.write("\n");
    	f.write("Total Amount of credits hours is : " + totalCreditsHours + "\n");
    	
    	if(studentArray[i].isTuitonPaid) {
    	System.out.println("Midmester GPA is :..... " + total/totalCreditsHours);
    	f.write("Midmester GPA is :..... " + total/totalCreditsHours);
    	}
    	else {
    		
    		System.out.println("Grades withheld you owe " + tuitonRate * courseArray.length);
    		f.write("Grades withheld you owe : " + tuitonRate * courseArray.length);
    	}
    	System.out.println(); 
    	f.write("\n");
    	
    	
    	pointsTowardGpa = 0;
		totalPointsTowardGpa = 0;
		gpa=0;
		total = 0;
		totalCreditsHours = 0;	
      }
      f.close();
	  }
	}



