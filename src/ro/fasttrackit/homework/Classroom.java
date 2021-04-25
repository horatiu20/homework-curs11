package ro.fasttrackit.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Classroom {
	private final List<StudentGrade> students;

	public Classroom(List<StudentGrade> students) {
		this.students = new ArrayList<>();
		this.students.addAll(students);
	}

	public List<Integer> getGradesForDiscipline(String discipline) {
		List<Integer> result = new ArrayList<>();
		for (StudentGrade student : students) {
			if (student.getDiscipline().equals(discipline)) {
				result.add(student.getGrade());
			}
		}
		return result;
	}

	public int getGradesForStudent(String student) {
		for (StudentGrade all : students) {
			if (student.equals(all.getName())) {
				return all.getGrade();
			}
		}
		return -1;
	}

	public int getMaxGrade(String discipline) {
		List<Integer> result = new ArrayList<>();
		for (StudentGrade all : students) {
			if (discipline.equals(all.getDiscipline())) {
				result.add(all.getGrade());
			}
		}
		return Collections.max(result);
	}

	public int getWorstGrade(String discipline) {
		List<Integer> result = new ArrayList<>();
		for (StudentGrade all : students) {
			if (discipline.equals(all.getDiscipline())) {
				result.add(all.getGrade());
			}
		}
		return Collections.min(result);
	}

	public int geAverageGrade(String discipline) {
		List<Integer> result = new ArrayList<>();
		int sum = 0;
		for (StudentGrade all : students) {
			if (discipline.equals(all.getDiscipline())) {
				result.add(all.getGrade());
				sum += all.getGrade();
			}
		}
		return sum / result.size();
	}

	public List<Integer> getMaxGrade() {
		List<Integer> result = new ArrayList<>();
		for (StudentGrade all : students) {
			if (10 == (all.getGrade())) {
				result.add(all.getGrade());
			}
		}
		return result;
	}
}