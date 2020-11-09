package backend;

public class CelulaSexuata extends Celula implements Runnable {

	private boolean isReady;
	private CelulaSexuataArrayWrapper w;

	// primeste din afara un array list in care pune celulele nou create
	public CelulaSexuata(Food f, CelulaSexuataArrayWrapper c) {
		super(f);
		this.w = c;
		this.isReady = false;
	}

	public void reproduce() {
		System.out.println("Create a new cell(sexuata).");

		CelulaSexuata newCell = new CelulaSexuata(super.getFood(), this.w);
		this.w.addCell(newCell);
		super.setNumberOfMeals(0);
		Thread t = new Thread(newCell);
		t.start();
	}

	public void setNewState(boolean isReady) {
		this.isReady = isReady;
	}

	public boolean getNewState() {
		return this.isReady;
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
					this.setNewState(true);
					int i = this.w.getIndexOf(this);
					CelulaSexuata c = this.w.cellReadyToReproduce(i);
					if(c != null)
					{
						this.reproduce();
						c.setNumberOfMeals(0);
					}
				}
				long lastTimeAte = System.currentTimeMillis();
				// do nothing while the cell is full
				while(System.currentTimeMillis() - lastTimeAte > super.getFullTime()) {
					
				}
				start = System.currentTimeMillis(); // now the cell is hungry, reset the timer
			}
			
		}
		super.die(); // if there was no chance for the cell to eat while it was starving, the cell dies
		this.w.removeCell(this);
	}
}
