package ro.fasttrackit.homework;

/*Continua exercitiul precedent si creeaza un obiect ReportGenerator care primeste lista cu notele studentilor.
ReportGenerator are o metoda generateReport care genereaza urmatorul raport intr-un fisier: grade-reports.out
	a) Cea mai mare nota:  <studentul cu cea mai mare nota> <nota>
	b) Nota medie: <nota medie>
	c) Cea mai mica nota: <studentul cu cea mai mica nota> <nota>*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReportGenerator {
	public static void main(String[] args) throws Exception {
		List<StudentGrade> students = readStudents();
		generateReport();
	}

	private static StudentGrade studentInfo(String studentInfo) {
		String[] studentData = studentInfo.split("\\|");

		String name = studentData[0];
		String discipline = studentData[1];
		int grade = Integer.parseInt(studentData[2]);

		return new StudentGrade(name, discipline, grade);
	}

	private static List<StudentGrade> readStudents() throws Exception {
		List<StudentGrade> students = new ArrayList<>();
		BufferedReader fileReader = new BufferedReader(new FileReader("files/grades.txt"));
		String line;
		while ((line = fileReader.readLine()) != null) {
			students.add(studentInfo(line));
		}
		return students;
	}

	private static void generateReport() throws Exception {

	}
}
