package generic_types;

public class Veterinaria<E extends Animal> {
	
	private E animal;

	public void setAnimal(E gato) {
		this.animal = gato;
	}
	
	public E getAnimal() {
		return animal;
	}

}