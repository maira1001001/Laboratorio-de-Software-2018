package generic_types;

public class VeterinariaTesting {

	public static void main(String[] args) {
		
		Veterinaria<Gato> vet = new Veterinaria <Gato>();
		Veterinaria<Animal> vet2	 = new Veterinaria <Animal>();
		Veterinaria <?> vet3 = new Veterinaria<Gato>();
		
		Veterinaria vet4 = new Veterinaria ();
		vet4.setAnimal(new Perro());
		
//		Veterinaria vet5 = new Veterinaria <?>();
//		Veterinaria <? extends Animal> vet6 = new Veterinaria<Gato>();
//		vet6.setAnimal(new Gato());
	}
	
}
