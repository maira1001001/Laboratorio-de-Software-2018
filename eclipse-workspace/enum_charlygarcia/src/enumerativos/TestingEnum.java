package enumerativos;

public class TestingEnum {

	private static void testingNotas() {
		System.out.println("Notas musicales:");
		for(Notas n: Notas.values()) {
    		System.out.println(n);
    	}
    	System.out.println(Notas.DO);
	}
	
	private static void testingFrecuenciaDeLA() {
		System.out.println("Frecuencia de LA:");
		for(FrecuenciaDeLA f: FrecuenciaDeLA.values()) {
    		System.out.println(f);
    	}
	}
	
	private static void testingCharlyGarcia() {
		System.out.println("Charly toca el piano");
		Notas[] cancion =  {Notas.DO, Notas.RE, Notas.MI, Notas.FA, Notas.SOL};
		int duracionDeLaNota = 5; //utilizo la misma duración para todas las notas musicales
		Compositor.CHARLY_GARCIA.tocarCancionConPiano(cancion, duracionDeLaNota);
	}
	
	public static void main(String args[]) {
		testingNotas();
		testingFrecuenciaDeLA();
		testingCharlyGarcia();
    }
}
