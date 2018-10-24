#callable
https://www.journaldev.com/1090/java-callable-future-example


# Threads : TP9
**Ejercicio2:** 
el método `run()` bloquea `System.out` con la palabra clave `synchronized`. Define un bloque entre `{` y  `}` y hasta que no termine de ejecutarse el bloque, no libera `System.out`
Existen 2 tipos de `lock`
1. `lock` definido sobre un objeto
```java
	public class SynchronizedCounter 
	{ 
		private int c = 0;
		public synchronized void increment() { c++; }
		public synchronized void decrement() { c--; } 
		public synchronized int value() { return c; } 
		public int sinBloquear() { hace_algo() }
	}
```
Si se invoca algún `synchronized`, se bloquean los demás definidos como `synchronized`
Ejemplo: 

El objeto `synchronizedCounterObject`  invoca `increment`

**Mientras se ejecuta `increment()`**,     

1. el objeto `synchronizedCounterObject`  **puede invocar** `sinBloquear()`, pero **no puede invocar** a `decrement()` ni a `value()`
2. el método `increment()` puede hacer uso de todos los métodos de `SynchronizedCounter`, es decir de `increment()`, `decrement()`, `value()` y `sinBloquear()`

Tipos de **lock**
-  `lock` definido sobre un método
````java
	public synchronized int f() {}
````
- `lock` definido sobre un objeto
````java
	synchronized (System.out) {} 
````

