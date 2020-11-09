package backend;

public class CelulaAsexuata extends Celula implements Runnable{
	
	public CelulaAsexuata(Food f) {
		super(f);
	}

	public void reproduce() {
		System.out.println("Creating a new cell(asexuata).");
		CelulaAsexuata newCell = new CelulaAsexuata(super.getFood());
		super.setNumberOfMeals(0);
		Thread t = new Thread(newCell);
		t.start();
	}
	
	public void run() {
		long start = System.currentTimeMillis();
		
		// at this moment the cell is hungry
		while(System.currentTimeMillis() - start < super.getStarvationTime()) {

			if(super.eat())
			{
				super.incrementMeals();
				if(super.getNumberOfMeals() == 10)
				{
					this.reproduce();
				}
				long lastTimeAte = System.currentTimeMillis();
				// do nothing while the cell is full
				while(System.currentTimeMillis() - lastTimeAte > super.getFullTime()) {
					
				}
				start = System.currentTimeMillis(); // now the cell is hungry, reset the timer
			}
			
		}
		super.die(); // if there was no chance for the cell to eat while it was starving, the cell dies
	}
}
