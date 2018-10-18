package excepciones.ejercicio4;

public interface Tormenta {
	
	void evento() throws FutbolException, Lluvia;
	void diluvio() throws Lluvia;
}
