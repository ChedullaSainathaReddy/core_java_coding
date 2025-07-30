package com.wiprojava;

public class School {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Standard std = new Standard();

	        std.addStudent(new Student("Ravi", 85, 90, 78));
	        std.addStudent(new Student("Anjali", 92, 95, 89));
	        std.addStudent(new Student("Kiran", 75, 80, 70));
	        std.addStudent(new Student("Deepa", 88, 85, 84));
	        std.addStudent(new Student("Sunil", 70, 72, 75));
	        std.addStudent(new Student("Meena", 95, 98, 96));
	        std.addStudent(new Student("Rahul", 60, 65, 68));
	        std.addStudent(new Student("Pooja", 78, 82, 79));

	        System.out.println("\n1. Display by Roll No:");
	        std.displayByRollNo();

	        System.out.println("\n2. Highest Percentage:");
	        std.displayHighestPercentageStudent();

	        System.out.println("\n3. Highest Marks in Maths:");
	        std.displayHighestMathsMarkStudent();

	        System.out.println("\n4. Ascending order of Maths + Science:");
	        std.displayByMathsScienceTotal();

	        System.out.println("\n5. Rank List:");
	        std.displayRankList();
	    }
	

	}

//OUTPUT:. Display by Roll No:
//	Roll No: 1, Name: Ravi
//	Roll No: 2, Name: Anjali
//	Roll No: 3, Name: Kiran
//	Roll No: 4, Name: Deepa
//	Roll No: 5, Name: Sunil
//	Roll No: 6, Name: Meena
//	Roll No: 7, Name: Rahul
//	Roll No: 8, Name: Pooja
//
//	2. Highest Percentage:
//	Topper (Percentage): Roll No: 6, Name: Meena
//
//	3. Highest Marks in Maths:
//	Maths Topper: Roll No: 6, Name: Meena
//
//	4. Ascending order of Maths + Science:
//	Roll No: 7, Name: Rahul
//	Roll No: 5, Name: Sunil
//	Roll No: 3, Name: Kiran
//	Roll No: 8, Name: Pooja
//	Roll No: 1, Name: Ravi
//	Roll No: 4, Name: Deepa
//	Roll No: 2, Name: Anjali
//	Roll No: 6, Name: Meena
//
//	5. Rank List:
//	Rank: 1, Roll No: 6, Name: Meena, Total: 289, Percentage: 96.33
//	Rank: 2, Roll No: 2, Name: Anjali, Total: 276, Percentage: 92.00
//	Rank: 3, Roll No: 4, Name: Deepa, Total: 257, Percentage: 85.67
//	Rank: 4, Roll No: 1, Name: Ravi, Total: 253, Percentage: 84.33
//	Rank: 5, Roll No: 8, Name: Pooja, Total: 239, Percentage: 79.67
//	Rank: 6, Roll No: 3, Name: Kiran, Total: 225, Percentage: 75.00
//	Rank: 7, Roll No: 5, Name: Sunil, Total: 217, Percentage: 72.33
//	Rank: 8, Roll No: 7, Name: Rahul, Total: 193, Percentage: 64.33
//
