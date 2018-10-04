package collections;

public class Student extends Person implements Comparable<Student>{
	
	private int id;
	private String name;
	private String lastname;
	private String documentNumber;
	
	public Student(int id, String name, String lastname, String documentNumber) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.documentNumber = documentNumber;
	}
	
	public String toString() {
		return "[Name= "+this.name+", last name= "+this.lastname+", id= "+this.id+", document_number="+ this.documentNumber+"]";
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getDocumentNumber() {
		return documentNumber;
	}
	
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	@Override
	public int compareTo(Student s) {
		//ordenado por número de legajo de menor a mayor
		return (this.id-s.id);
	}
}
