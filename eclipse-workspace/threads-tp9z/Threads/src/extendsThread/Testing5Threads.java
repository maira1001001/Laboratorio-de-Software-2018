package extendsThread;

public class Testing5Threads {

	public static void main (String[] args) {
		for (int i = 0; i < 5; i++) {
			new ThreadTest(i).start();
		}
	}

}
