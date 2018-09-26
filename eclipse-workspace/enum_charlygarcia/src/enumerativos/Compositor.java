package enumerativos;

public enum Compositor {

	CHARLY_GARCIA("Charly García");
		
	private final String compositor; 
	
	Compositor(String compositor){
		this.compositor = compositor;
	}
	
	public void tocarCancionConPiano(Notas[] cancion, int duracion) {
		Piano piano = new Piano();
		for (int i = 0; i < cancion.length; i++) {
			piano.hacerSonar(cancion[i], duracion);
		}
	}
}
