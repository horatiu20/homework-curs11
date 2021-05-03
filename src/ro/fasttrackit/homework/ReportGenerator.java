package ro.fasttrackit.homework;

/*Continua exercițiul precedent si creează un obiect ReportGenerator care primește lista cu notele studenților.
ReportGenerator are o metoda generateReport care generează următorul raport într-un fișier: grade-reports.out
	a) Cea mai mare nota:  <studentul cu cea mai mare nota> <nota>
	b) Nota medie:         <nota medie>
	c) Cea mai mica nota:  <studentul cu cea mai mica nota> <nota>*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ReportGenerator {
	public static void main(String[] args) throws Exception {
		List<StudentGrade> students = readStudents();
		generateReport(students);
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

	private static void generateReport(List<StudentGrade> students) throws Exception {
		List<StudentGrade> result = new ArrayList<>();
		List<Integer> averageGrade = new ArrayList<>();
		int gradeMin = Integer.MIN_VALUE;
		int gradeMax = Integer.MAX_VALUE;
		int sum = 0;
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("files/grade-reports.out"))) {
			for (StudentGrade all : students) {
				if (all.getGrade() > gradeMin) {
					gradeMin = all.getGrade();
					result.clear();
					result.add(all);
				} else if (all.getGrade() == gradeMin) {
					result.clear();
					result.add(all);
					writer.write("Cea mai mare nota: " + result);
					writer.newLine();                   // nu stiu de ce nu imi scoate si PRIMUL student cu nota cea mai mare
				}                                       // pe care il intalneste
			}
			for (StudentGrade all : students) {
				if (all.getGrade() < gradeMax) {
					gradeMax = all.getGrade();
					result.clear();
					result.add(all);
				} else if (all.getGrade() == gradeMax) {
					result.clear();
					result.add(all);
					writer.write("Cea mai mica nota: " + result);
					writer.newLine();                   // nu stiu de ce nu imi scoate si ULTIMUL student cu nota cea mai mica
				}                                       // pe care il intalneste
			}
			for (StudentGrade all : students) {
				if (all.getGrade() >= gradeMax) {
					averageGrade.add(all.getGrade());
					sum += all.getGrade();
				}
			}
			writer.write("Nota medie (nr. intreg) a clasei este: " + sum / averageGrade.size());
			writer.newLine();
		}
	}
}
