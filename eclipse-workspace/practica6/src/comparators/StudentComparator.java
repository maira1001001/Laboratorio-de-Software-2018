package comparators;

import java.util.Comparator;
import collections.Student;

public class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		return (s1.getLastname().compareTo(s2.getLastname()));
	}

}
