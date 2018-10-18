# TP7 Excepciones
```java
public class Excepcion1 extends Exception {}
public class Excepcion2 extends Excepcion1{}
public class Test1 {
	public static void main(String[] args) {
		try {
			throw new Excepcion2();
		} catch (Excepcion1 e1) {
			System.out.println("Se capturó la Excepción1");
		} catch (Excepcion2 e2) {
			System.out.println("Se capturó la Excepción2");
		}
	}
}
```
Este arroja el siguiente error: 
> Unreachable catch block for Excepcion2. It is already handled by the catch block for Excepcion1

```plantuml 
uml
(aca dibujar el uml de excepciones)
Exception2-> Exception1 -> Exception
```
```throw new Excepcion2();```  lanza la excepción y la trata el catch que está en el método ```Test1 ```. 
Cuando se lanza la excepción ```throw new Excepcion2();```, recordar que el orden de ejecución es el siguiente: 
Primero ``` catch (Excepcion1 e1)``` 
Segundo ``` catch (Excepcion2 e2)``` 
Cómo ```Exception2()``` es subclase de ```Exception1()```, entonces ``` catch (Excepcion2 e2)```   nunca va a ser alcanzada. Podemos brindar 2 soluciones:
Solución 1: 
```java
public class Excepcion1 extends Exception {}
public class Excepcion2 extends Excepcion1{}
public class Test1 {
	public static void main(String[] args) {
		try {
			throw new Excepcion2();
		} catch (Excepcion1 e1) {
			System.out.println("Se capturó la Excepción1");
		}
	}
}
```
Solución2:
```java
public class Excepcion1 extends Exception {}
public class Excepcion2 extends Excepcion1{}
public class Test1 {
	public static void main(String[] args) {
		try {
			throw new Excepcion2();
		} catch (Excepcion2 e2) {
			System.out.println("Se capturó la Excepción2");
		} catch (Excepcion1 e1) {
			System.out.println("Se capturó la Excepción1");
		}
	}
}
```

## Ejercicio 2

```java
try {
	System.out.println("Va a retornar 1");
	return 1;
} finally {
	System.out.println("Va a retornar 2");
	return 2;
}
```

Esto arroja como resultado :
```java
Va a retornar 1
Va a retornar 2
2
```
Siempre se ejecuta el bloque ``` finaly ```

## Ejercicio 3
```java
try {
	System.out.println("Primer try");
	try {
		throw new Exception();
	} finally {
		System.out.println("Finally del 2º try");
	}
} catch (Exception e) {
	System.out.println("Se capturó la Excepción ex del 1º Primer try");
} finally {
	System.out.println("Finally del 1º try");
}
```
Esto arroja como resultado:

```java
Test3
Primer try
Finally del 2º try
Se capturó la Excepción ex del 1º Primer try
Finally del 1º try
```
## Ejercicio 4
Recordar que cuando hago un throw de una excepción, puedo que arrojar 
1. excepciones que están definidas en el encabezado de la super clase
2. o subclases de las excepciones que están definidas en el encabezado de la super clase
Esto es posible
```java
class Partido {
	void jugada() throws EquipoIncompleto, FaltaException {}
}
public class Encuentro extends Partido implements Tormenta {
	void jugada() throws ManoException {}
}
public class ManoException extends FaltaException{}
```
Observar que como ```ManoException()``` es subclase de ```FaltaException()```, entonces puedo hacer 
```java 
	void jugada() throws ManoException {}
```
Pero no sería posible lo siguiente:

```java
class Partido {
	void jugada() throws EquipoIncompleto, FaltaException {}
}
public class Encuentro extends Partido implements Tormenta {
	void jugada() throws LluviaException {}
}
public class LluviaException extends ClimaException {}
public class ClimaException extends Exception{}
```
## Ejercicio 5

```
 java.lang.ArrayIndexOutOfBoundsException:

 java.lang.NumberFormatException

```java
