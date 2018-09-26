## To remember:
1. **When coding**:  Every program i code has extensión `.java`
2. **When compiling**: The program compiles into a file with extension `.class`. This file is known as `Java byte code`. It's executed on the `Java Virtual Machine`.
3. **When executing**: After execute the compiled program `name.java`, the jre generates a file with extension `.jar`

## Within console
1. **When executing**: first search the file location (usually within the workspace, inside the package name -estudiante-). Second find the `bin` folder and select the class which contains an entry point (TestEstudiante). Thrird, write the following command `$java estudiante.TestEstudiante`

## Build .jar
We can build this file with eclipse (new->jar). Remember to select the entry point (TestEstudiante in this case) and choose a name (tp1.jar). To execute this file, write the following command `$ java -jar  tp1.jar`.

## Metadata MANIFEST.MF
Whithin tp1.jar, we can find `META-INF` folder. This folder contains the file ``MANIFEST.MF``. This file specify some important data. The below MANIFEST.MF is an example:

`Manifest-Version: 1.0`
`Main-Class: estudiante.TestEstudiante`
