package compositor;

enum Figures {
	SEMIBREVE("w"),
	MINIM("h"),
	CROTCHET("q"),
	QUAVER("i"),
	SEMIQUAVER("s"),
	DEMISEMIQUAVER("t"),
	HEMIDEMISEMIQUAVER("x");

	Figures(String symbol){}
	
	public String toString() {
		return name().toLowerCase();
	}
}