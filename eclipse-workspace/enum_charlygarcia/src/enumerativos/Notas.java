package enumerativos;

public enum Notas {
	DO("C"),
	RE("D"),
	MI("E"),
	FA("F"),
	SOL("G"),
	LA("A"),
	SI("B");
	
    private final String note;
    
    Notas(String note) {
       this.note = note;
    }
    
    public String toString() {
       return note;
    }
}
