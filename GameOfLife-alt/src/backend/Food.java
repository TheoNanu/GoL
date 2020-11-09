package backend;

public class Food {
	
	private int foodUnits; // variable accessed by multiple threads, needs to be protected
	
	public Food(int fUnits) {
		this.foodUnits = fUnits;
	}
	
	public synchronized boolean hasUnits()
	{
		if(this.foodUnits > 0)
			return true;
		else
			return false;
	}
	
	public synchronized boolean decrementUnits()
	{
		if(this.foodUnits > 0)
		{
			System.out.println("Eating...");
			this.foodUnits--;
			System.out.println("Food remaining after I ate: " + this.foodUnits);
			return true;
		}
		else
			return false;
	}
	
	public synchronized void increaseUnitsBy(int value)
	{
		this.foodUnits += value;
		System.out.println("Food units after increment: " + this.foodUnits);
	}
}
