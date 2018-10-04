#Practica 6

2. Indicar cual es el siguiente resultado

1. The following sentence have a type error 
```
Veterinaria <Animal> veterinaria1 = new Veterinaria <Gato>();

```
*Error:* `type mismatch` cannot convert from Veterinaria<Gato> to Veterinaria<Animal>



We can modify the class definition

```
public class Veterinaria<E extends Animal>()  { ...  }
```
or modify the instantiation

```
Veterinaria<Gato> veterinara1 = new Veterinaria<Gato>();
```

2. The following sentence have a type error 

```
Veterinaria<Gato> veterinaria2 = new Veterinaria <Animal>();

```

*Error:* `type mismatch` cannot convert from Veterinaria<Animal> to Veterinaria<Gato>

We can modify the execise as follow:

```
Veterinaria<Gato> veterinara2 = new Veterinaria<Gato>();
```

or on the class definition

```
public class Veterinaria<E extends Animal>()  { ...  }
```

3. The following sentence is syntactically correct, but has type error

```
Veterinaria <?> veterinaria3 = new Veterinaria<Gato>();
veterinaria3.setAnimal(new Gato());
```

`<?>` is a *wildcard*. It can be used in
+ variable declarations 
+ instantiations 
+ method definitions
But it cannot be used in the definition of a generic type.

4. The following sentence is correct 

```
Veterinaria veterinaria4 = new Veterinaria ();
veterinaria4.setAnimal(new Perro());
```

5. The following sentence has a type error: `Cannot instantiate the type Veterinaria<?>`
```
 Veterinaria vet5 = new Veterinaria <?>();
```

6. The following sentence is correct:
```
 Veterinaria <? extends Animal> veterinaria6 = new Veterinaria<Gato>();
```
But it is not possible to set elements.
