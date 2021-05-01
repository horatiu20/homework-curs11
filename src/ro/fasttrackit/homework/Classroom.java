package ro.fasttrackit.homework;

import java.util.*;

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

	public StudentGrade getGradesForStudent(String student) {
		for (StudentGrade all : students) {
			if (student.equals(all.getName())) {
				return all;
			}
		}
		return null;
	}

	public StudentGrade getMaxGrade(String discipline) {
		List<StudentGrade> result = new ArrayList<>();
		for (StudentGrade all : students) {
			if (discipline.equals(all.getDiscipline())) {
				result.add(all);
			}
		}
		return Collections.max(result, Comparator.comparing(StudentGrade::getGrade));
	}

	public StudentGrade getMaxGrade() {
		List<StudentGrade> result = new ArrayList<>();
		result.addAll(students);
		return Collections.max(result, Comparator.comparing(StudentGrade::getGrade)); // imi returneaza doar primul obiect intalnit cu nota maxima si
	}                                                                                 // nu imi dau seama cum pot sa fac sa treaca mai departe

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

	public StudentGrade getWorstGrade(String discipline) {
		List<StudentGrade> result = new ArrayList<>();
		for (StudentGrade all : students) {
			if (discipline.equals(all.getDiscipline())) {
				result.add(all);
			}
		}
		return Collections.min(result, Comparator.comparing(StudentGrade::getGrade));
	}
}
