package enumerativos;

public enum FrecuenciaDeLA {
	
	Hz440("Organización Internacional de Estandarización ISO 16"),
	Hz444("Afinación de cámara"),
	Hz446("Renacimiento"),
	Hz480("Órganos alemanes que tocaba");
	 
	private final String description;
	
	FrecuenciaDeLA(String description){
		this.description = description;
	}
	
	public String toString() {
		return name().substring(2)+"Hz: "+description;
	}
}
