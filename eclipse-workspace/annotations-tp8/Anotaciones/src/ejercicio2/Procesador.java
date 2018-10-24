package ejercicio2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.*;

public class Procesador	 {

	// pasar a método o constante: Archivo.class y AlmacenarAtributo.class

	
	
	public static void mapAndStoreBeanClassToFyleSystem(Class<?> bean) {
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
		return fileNameFromAnnotationArchivo.isEmpty() ? fileNameFromBeanClass : fileNameFromAnnotationArchivo;
		
	}

	private static HashMap<String, String> getFieldsWithAnnotationsFromBeanObjet(Class bean) {
		//Mapeado bean = new Mapeado(); // cambiar: se debe instanciar la clase "bean1"
		Class beanObject = null;
		HashMap<String, String> result = new HashMap<String, String>();
		try {
			beanObject = Class.forName(bean.getName());
			for (Field field : beanObject.getClass().getDeclaredFields()) {
				if (field.isAnnotationPresent(AlmacenarAtributo.class)) {
					try {
						field.setAccessible(true);
						result.put(field.getName(), field.get(bean).toString());
					} catch (IllegalArgumentException | IllegalAccessException e) {
						System.out.println("El campo " + field.getName()
								+ " no es accesile o no está definido en la clase" + beanObject.getName());
					}
				}
			}
		} catch (ClassNotFoundException e1) {
			System.out.println("No se pudo crear una instancia de la clase "+ bean.getSimpleName());
		}
		return result;
	}

	private static String[] generateXMLContent(Class bean, HashMap<String, String> fields) {
		String[] result = new String[fields.size()*2+1];
		result[0] =  "<nombreClase>" + bean.getSimpleName() + "</nombreClase>" ;
		int i = 1;
		for (Map.Entry<String, String> field : fields.entrySet()) {
			result[i] = "<nombreAtributo>" + field.getKey() + "<nombreAtributo>";
			result[i+1] = "<nombreValor>" + field.getValue() + "<nombreValor>";
			i=i+2;
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
			System.out.println("El archivo "+ file.getName() + "no pude abrirse o crearse por la siguiente razón:"+ e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println("Los datos fueron almacenados en "+file.getAbsolutePath() );
		} 
	}


	public static void main(String[] args) throws Exception {
		try {
			Class beanClass = Class.forName(args[0]);
			mapAndStoreBeanClassToFyleSystem(beanClass);
		} catch (ClassNotFoundException e) {
			System.out.println("La clase "+ args[0]+ " NO se encontró. Especifique la clase 'ejercicio2.Mapeado' en la sección 'Run configuration'");
		}
	}

}
