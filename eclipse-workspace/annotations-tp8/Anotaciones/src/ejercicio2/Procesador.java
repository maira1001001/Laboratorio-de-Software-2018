package ejercicio2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;

public class Procesador {

	// pasar a método o constante: Archivo.class y AlmacenarAtributo.class

	
	public static void mapAndStoreBeanClassToFyleSystem(Class<?> bean) {
		File file = createFileFromAnnotationBeanClass(bean);
		HashMap<String, String> fields = getFieldsWithAnnotationsFromBeanObjet(bean);
		String[] xmlContent = generateXMLContent(file.getName(), fields);
		//BufferedWriter bufWriter = createFileWithName_(file.getName());
		writeContent_ToFileSystem_(xmlContent, file);
	}

	private static File createFileFromAnnotationBeanClass(Class bean) {
		Archivo archivo = (Archivo) bean.getAnnotation(Archivo.class);
		return new File(defineFileNameBetween(archivo.nombre(), bean.getName()));
	}

	private static String defineFileNameBetween(String fileNameFromAnnotationArchivo, String fileNameFromBeanClass) {
		return fileNameFromAnnotationArchivo.isEmpty() ? fileNameFromAnnotationArchivo : fileNameFromBeanClass;
	}

	private static HashMap<String, String> getFieldsWithAnnotationsFromBeanObjet(Class bean1) {
		Mapeado bean = new Mapeado(); // cambiar: se debe instanciar la clase "bean1"
		HashMap<String, String> result = new HashMap<String, String>();
		for (Field field : bean.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(AlmacenarAtributo.class)) {
				try {
					field.setAccessible(true);
					result.put(field.getName(), field.get(bean).toString());
				} catch (IllegalArgumentException | IllegalAccessException e) {
					System.out.println("The field " + field.getName()
							+ " is not accesible or it is not defined in the class " + bean1.getName());
				}
			}
		}
		return result;
	}

	private static String[] generateXMLContent(String className, HashMap<String, String> fields) {
		String[] result = { "<nombreClase>" + className + "</nombreClase>" };
		Collection<String> listFields = fields.values();
		int i = 1;
		for (String fieldName : listFields) {
			result[i] = "<nombreAtributo>" + fields.get(fieldName) + "<nombreAtributo>";
			result[i + 1] = "<nombreValor>" + fieldName + "<nombreValor>";
			i++;
		}
		return result;
	}

	private static void writeContent_ToFileSystem_(String[] xmlContent, File file) {
		FileWriter fileWriter = null;
		BufferedWriter bufWriter = null;
		try {
			fileWriter = new FileWriter(file);
			bufWriter = new BufferedWriter(fileWriter);
			for (String content : xmlContent) {
				bufWriter.write(content);
				bufWriter.newLine();
			}
			bufWriter.flush();
			fileWriter.close();
			bufWriter.close(); 
		} catch (IOException e) {
			System.out.println("the file "+ file.getName() + "can not be opened or created for the following reason "+ e.getMessage());
			e.printStackTrace();
		} 
	}

//	private static FileWriter createOtherFile() {
//		/*
//		 * It 's not implemented. It is executed only if the file which throw the exception can not be opened or created for any reason
//		 */
//		return null;
//	}

	public static void main(String[] args) throws Exception {
		try {
			Class beanClass = Class.forName(args[0]);
			mapAndStoreBeanClassToFyleSystem(beanClass);
		} catch (ClassNotFoundException e) {
			System.out.println("Class "+ args[0] +" not found. Specify the class on 'Run configurations' section");
		}
	}

}
