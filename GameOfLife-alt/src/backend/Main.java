package backend;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Food f = new Food();
		
		CelulaAsexuata c = new CelulaAsexuata(f);
		Thread t = new Thread(c);
		t.start();
		
		CelulaSexuataArrayWrapper w = new CelulaSexuataArrayWrapper();
		CelulaSexuata c1 = new CelulaSexuata(f, w);
		CelulaSexuata c2 = new CelulaSexuata(f, w);
		w.addCell(c1);
		w.addCell(c2);
		
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		t1.start();
		t2.start();
	}
}
