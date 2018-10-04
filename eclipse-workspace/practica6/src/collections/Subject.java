package collections;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import comparators.StudentComparator;

import java.util.ArrayList;
import java.util.Collections;

public class Subject {
	
	private String name;
	private List<Student> studentsListSortedById;
	private List<Student> studentsListSortedByLastName;
	private SortedSet<Student> studentsSortedSetSortedById;
	private SortedSet<Student> studentsSortedSetSortedByLastName;
	
	public Subject(String name) {
		this.name = name;
		this.studentsListSortedById = new ArrayList<Student>();
		this.studentsListSortedByLastName = new ArrayList<Student>();
		this.studentsSortedSetSortedById = new TreeSet<Student>();
		this.studentsSortedSetSortedByLastName = new TreeSet<Student>(new StudentComparator());
	}

	public void addStudentToListSortedById(Student s) {
		this.studentsListSortedById.add(s);
		Collections.sort(this.studentsListSortedById);
	}
	
	public void addStudentToListSortedByLastName(Student s) {
		this.studentsListSortedByLastName.add(s);
		Collections.sort(this.studentsListSortedByLastName, new StudentComparator());
	}
	
	public void addStudentToSortedSetSortedById(Student s) {
		this.studentsSortedSetSortedById.add(s);
	}
	
	public void addStudentToSortedSetSortedByLastName(Student s) {
		this.studentsSortedSetSortedByLastName.add(s);
	}
	
	public List<Student> getStudentsListSortedById() {
		return studentsListSortedById;
	}
	
	public List<Student> getStudentsListSortedByLastName() {
		return studentsListSortedByLastName;
	}
	
	public SortedSet<Student> getStudentsSortedSetSortedById() {
		return studentsSortedSetSortedById;
	}
	
	public SortedSet<Student> getStudentsSortedSetSortedByLastName() {
		return studentsSortedSetSortedByLastName;
	}
	
}
