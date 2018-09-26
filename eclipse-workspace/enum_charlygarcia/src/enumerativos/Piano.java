package enumerativos;

public class Piano implements InstrumentoMusical{

	@Override
	public void hacerSonar() {
		System.out.println("hacerSonar");
	}
	
	public void hacerSonar(Notas n, int duracion) {
		for (int i = 0; i < duracion; i++) {
			System.out.println(n);
		}
	}

	@Override
	public String queEs() {
		return null;
	}

	@Override
	public void afinar() {
		System.out.println("afinando el instrumento");
	}
}
