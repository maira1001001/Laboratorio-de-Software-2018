package excepciones.ejercicio4;

class Partido {
	
	Partido() throws FutbolException {}

	void evento() throws FutbolException, Lluvia {}

	void jugada() throws EquipoIncompleto, Falta {}

	void penal() throws Mano {}
}
