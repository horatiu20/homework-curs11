package ro.fasttrackit.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class GradesFile {
	public static void main(String[] args) throws Exception {
		List<StudentGrade> students = readStudents();
		System.out.println(students);
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

	private static StudentGrade studentInfo(String studentInfo) {
		String[] studentData = studentInfo.split("\\|");

		String name = studentData[0];
		String discipline = studentData[1];
		int grade = Integer.parseInt(studentData[2]);

		return new StudentGrade(name, discipline, grade);
	}
}
