package annotations;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.*;

public class Procesador {


	public static void mapAndStoreBeanClassToFyleSystem(Class<?> bean) throws InstantiationException, IllegalAccessException {
		File file = createFileFromAnnotationBeanClass(bean);
		HashMap<String, String> fields = getFieldsWithAnnotationsFromBeanObjet(bean);
		String[] xmlContent = generateXMLContent(bean, fields);
		writeContent_ToFileSystem_(xmlContent, file);
	}

	private static File createFileFromAnnotationBeanClass(Class bean) {
		Archivo archivo = (Archivo) bean.getAnnotation(Archivo.class);
		return new File(defineFileNameBetween(archivo.nombre(), bean.getSimpleName()));
	}

	private static String defineFileNameBetween(String fileNameFromAnnotationArchivo, String fileNameFromBeanClass) {
		return fileNameFromAnnotationArchivo.isEmpty() ? fileNameFromBeanClass+".txt" : fileNameFromAnnotationArchivo;

	}

	private static HashMap<String, String> getFieldsWithAnnotationsFromBeanObjet(Class beanClass) throws InstantiationException, IllegalAccessException {
		HashMap<String, String> result=null;
		Object beanObject = beanClass.newInstance(); 
		result = new HashMap<String, String>();
		for (Field field : beanObject.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(AlmacenarAtributo.class)) {
				try {
					field.setAccessible(true);
					result.put(field.getName(), field.get(beanObject).toString());
				} catch (IllegalArgumentException | IllegalAccessException e) {
					System.out.println("El campo " + field.getName() + " no es accesile o no está definido en la clase"
							+ beanObject);
				}
			}
		}
		return result;
	}

	private static String[] generateXMLContent(Class bean, HashMap<String, String> fields) {
		String[] result = new String[fields.size() * 2 + 1];
		result[0] = "<nombreClase>" + bean.getSimpleName() + "</nombreClase>";
		int i = 1;
		for (Map.Entry<String, String> field : fields.entrySet()) {
			result[i] = "<nombreAtributo>" + field.getKey() + "<nombreAtributo>";
			result[i + 1] = "<nombreValor>" + field.getValue() + "<nombreValor>";
			i = i + 2;
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
			System.out.println("El archivo " + file.getName() + "no pude abrirse o crearse por la siguiente razón:"
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println("Los datos fueron almacenados en " + file.getAbsolutePath());
		}
	}

	public static void main(String[] args) throws Exception {
		try {
			Class beanClass = Class.forName(args[0]);
			mapAndStoreBeanClassToFyleSystem(beanClass);
		} catch (ClassNotFoundException  e) {
			System.out.println("La clase "+args[0]+" NO se encontró. Especifique la clase 'annotations.Mapeado' en la sección 'Run configuration'");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Especifique la clase 'ejercicio2.Mapeado' en la sección 'Run configuration'");
		} catch (InstantiationException e) {
			System.out.println("No se pude instanciar la clase 'annotations.Mapeado' por algún motivo");
		} catch (IllegalAccessException e) {
			System.out.println("No se pude acceder a la clase 'annotations.Mapeado'");
		}
	}

}