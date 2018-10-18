package excepciones.ejercicio5;

public class Suma {

	public static void main(String[] args) {
		int suma = 0;
		try {
			for (int i = 0; i < args.length; i++) {
				suma += Integer.parseInt(args[i]);
			}
		
		}catch (NumberFormatException e) {
			System.out.println("El argumento ingresado no es un número " + e.getMessage());
		}
		System.out.print("La suma es:" + suma);
	}

}
