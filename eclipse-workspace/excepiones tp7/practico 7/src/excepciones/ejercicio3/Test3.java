package excepciones.ejercicio3;

public class Test3 {
	public static void main(String[] args) {
		System.out.println("Test3");
		try {
			System.out.println("Primer try");
			try {
				throw new Exception();
			} finally {
				System.out.println("Finally del 2� try");
			}
		} catch (Exception e) {
			System.out.println("Se captur� la Excepci�n ex del 1� Primer try");
		} finally {
			System.out.println("Finally del 1� try");
		}
	}
}
