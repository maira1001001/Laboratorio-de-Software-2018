package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SubjectTest {

	public static void main(String[] args) {
		
		Subject geografie = new Subject("Geografie");
		int randomNum;
		
		for (int i = 0; i < 10; i++) {
			randomNum = ThreadLocalRandom.current().nextInt(0, 50 + 1);
			geografie.addStudentToListSortedById(new  Student(randomNum,"name_"+i, "lastname_"+i, "documentNumer_"+i));
			geografie.addStudentToListSortedByLastName(new  Student(randomNum,"name_"+i, "lastname_"+i, "documentNumer_"+i));
			geografie.addStudentToSortedSetSortedById(new  Student(randomNum,"name_"+i, "lastname_"+i, "documentNumer_"+i));
			geografie.addStudentToSortedSetSortedByLastName(new  Student(randomNum,"name_"+i, "lastname_"+i, "documentNumer_"+i));
		}
	
		System.out.println("Print elements from List sorted by Id");
		for (Student s : geografie.getStudentsListSortedById()) {
			System.out.println(s);
		}
		
		System.out.println("Print elements from List sorted by Last Name");
		for (Student s : geografie.getStudentsListSortedByLastName()) {
			System.out.println(s);
		}
		
		System.out.println("Print elements from SortedSet sorted by Id");
		for (Student s : geografie.getStudentsSortedSetSortedById()) {
			System.out.println(s);
		}
		
		System.out.println("Print elements from SortedSet sorted by Last Name");
		for (Student s : geografie.getStudentsSortedSetSortedByLastName()) {
			System.out.println(s);
		}
	
		List<? extends Person> l;
		l = new ArrayList<Person>();
		//l.add(new Student(1,"Eva", "Duarte", "12345"));
		
	}

	
}
