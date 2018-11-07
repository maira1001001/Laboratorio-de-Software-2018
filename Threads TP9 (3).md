
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


# Android 
1. Entorno: Android Studio
2.  application name
3. phone and tablet api 15 icecreamsandwich
4. configure activity: check compatibility
5.  error conflicto de dependencia: comentar los que generan error.  volver a sincronizar
6. sdk manager: android sdk plattform
7. emulador: avd manager (esquina superior derecha)


list view
array adapter (arreglo como argumento)

  ## Error del tipo:
> Error:Execution failed for task ':app:preDebugAndroidTestBuild'.
 Conflict with dependency 'com.android.support:support-annotations' in project ':app'. Resolved versions for app (26.1.0) and test app (27.1.1) differ. See https://d.android.com/r/tools/test-apk-dependency-conflicts.html for details.

Puedo resolverlo de la siguiente forma:
1.  Ctrl+Shift+n -> build gradle
2. comentar las ultimas 3 líneas de `dependencies`
> /*   
>  testImplementation 'junit:junit:4.12'  
 androidTestImplementation 'com.android.support.test:runner:1.0.2' 
 androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2' */
3. Volver a sincronizar:   `Gradle` -> `Refresh all gradle`



# Ejercicio 1
1. nuevo proyecto
2. lo sincronizo
3. agrego un listview
4. agrego un adapter al listview con los 4 valores (nombre, comentario, url, tipo recurso) [ListView simple example](https://androidexample.com/Create_A_Simple_Listview_-_Android_Example/index.php?view=article_discription&aid=65)
