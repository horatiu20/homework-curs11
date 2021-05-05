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
		for (StudentGrade grade : students) {
			if (student.equals(grade.getName())) {
				return grade;
			}
		}
		return null;
	}

	public List<StudentGrade> getMaxGrade(String discipline) {
		List<StudentGrade> result = new ArrayList<>();
		int grade = Integer.MIN_VALUE;
		for (StudentGrade all : students) {
			if (discipline.equals(all.getDiscipline())) {
				if (all.getGrade() > grade) {
					grade = all.getGrade();
					result.clear();
					result.add(all);
				} else if (all.getGrade() == grade) {
					result.add(all);
				}
			}
		}
		return result;
	}

	public int getMaxGrade() {
		List<Integer> result = new ArrayList<>();
		for (StudentGrade all : students) {
			result.add(all.getGrade());
		}
		return Collections.max(result);
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

	public List<StudentGrade> getWorstGrade(String discipline) {
		List<StudentGrade> result = new ArrayList<>();
		int grade = Integer.MAX_VALUE;
		for (StudentGrade all : students) {
			if (discipline.equals(all.getDiscipline())) {
				if (all.getGrade() < grade) {
					grade = all.getGrade();
					result.clear();
					result.add(all);
				} else if (all.getGrade() == grade) {
					result.add(all);
				}
			}
		}
		return result;
	}
}