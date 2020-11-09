package backend;

import java.util.Random;

public abstract class Celula {
	private int timeFull = 5000;
	private int timeStarve = 10000;
	private int numberOfMeals;
	private Food food = null;
	private Random rand;
	
	public Celula(Food f) {
		this.food = f;
		this.rand = new Random();
		this.numberOfMeals = 0;
	}
	
	public abstract void reproduce();
	
	public boolean eat() {
		return this.food.decrementUnits();
	}
	
	public int getFullTime() {
		return this.timeFull;
	}
	
	public int getStarvationTime() {
		return this.timeStarve;
	}
	
	public void die() {
		System.out.println("I'm dying!");
		int randNumberOfFood = rand.nextInt(5);
		System.out.println("Food produced: " + randNumberOfFood);
		this.food.increaseUnitsBy(randNumberOfFood);
		/*int fUnits = this.food.getFoodUnits();
		System.out.println("Food after I died: " + fUnits);*/
	}
	
	public Food getFood() {
		return this.food;
	}
	
	public int getNumberOfMeals() {
		return this.numberOfMeals;
	}
	
	public void setNumberOfMeals(int value)
	{
		this.numberOfMeals = value;
	}
	
	public void incrementMeals() {
		this.numberOfMeals++;
	}
}
