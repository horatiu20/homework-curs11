package ro.fasttrackit.homework;

/*You have grades.txt a file containing the name of the student, discipline and grade in the following format:
	<name & surname>|<discipline>|<grade>

Have an object StudentGrade(name, discipline, grade).
Create an object that will receive the path to this file,
and it will have a method that will read this file and return a list of StudentGrade.

Have an object Classroom that will receive a list of StudentGrade and implement the following methods:
	a) getGradesForDiscipline(String discipline): List<Integer>
	b) getGradesForStudent(String student): StudentGrade
	c) getMaxGrade(String discipline): StudentGrade
	d) getMaxGrade(): StudentGrade
	e) getAverageGrade(String discipline): Integer
	f) getWorstGrade(String discipline): StudentGrade

Create a Main object that tests the functionality*/

import java.util.List;

public class Main {
	public static void main(String[] args) {
		Classroom classroom = new Classroom(List.of(
				new StudentGrade("Ealhstan Saira", "Computer Science", 8),
				new StudentGrade("Gasparo Sava", "Mathematics", 7),
				new StudentGrade("Demetria Cosme", "Mathematics", 4),
				new StudentGrade("Majken Olgica", "History", 10),
				new StudentGrade("Miriana Rómulo", "Computer Science", 10),
				new StudentGrade("Utu Arcadius", "Physics", 3),
				new StudentGrade("Branwen Evelina", "Physics", 4),
				new StudentGrade("Amilia Hilaria", "Mathematics", 9),
				new StudentGrade("Marina Alimjan", "Computer Science", 5),
				new StudentGrade("Duilio Marius", "Physics", 7),
				new StudentGrade("Richa Ansgar", "Mathematics", 4),
				new StudentGrade("Bennett Frieda", "Mathematics", 7),
				new StudentGrade("Ermingard Tome", "Physics", 10),
				new StudentGrade("Jannike Lucianv", "Computer Science", 3),
				new StudentGrade("Neela Amaltheia", "Physics", 6),
				new StudentGrade("Asim Jeltje", "Computer Science", 17),
				new StudentGrade("Dulf Siguror", "Mathematics", 4),
				new StudentGrade("Eilert Mechteld", "Mathematics", 6),
				new StudentGrade("Storm Lital", "Computer Science", 9),
				new StudentGrade("Mubin Vyquoxpi", "Physics", 9)));

		System.out.println("All grades for discipline: " + classroom.getGradesForDiscipline("Physics"));
		System.out.println("Student grade for student: " + classroom.getGradesForStudent("Bennett Frieda"));
		System.out.println("Max grade for discipline: " + classroom.getMaxGrade("Physics"));
		System.out.println("Worst grade for discipline: " + classroom.getWorstGrade("Physics"));
		System.out.println("Average grade for discipline: " + classroom.geAverageGrade("Physics"));
		System.out.println("Max grade: " + classroom.getMaxGrade());
	}
}
