package backend;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

public abstract class Celula {
	private int timeFull;
	private int timeStarve;
	private int numberOfMeals;
	private Food food = null;
	private Random rand;
	
	public Celula(Food f) {
		this.food = f;
		this.rand = new Random();
		this.numberOfMeals = 0;
		try (InputStream input = new FileInputStream("config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            String tFull = prop.getProperty("timeFull");
            String tStarve = prop.getProperty("timeStarve");
            
            input.close();
            
            this.timeFull = Integer.parseInt(tFull);
            this.timeStarve = Integer.parseInt(tStarve);

        } catch (IOException ex) {
        	this.timeFull = 5000;
            this.timeStarve = 10000;
        }
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
		System.out.println("I'm dying! (" + Thread.currentThread().getName() + ")");
		int randNumberOfFood = rand.nextInt(5) + 1;
		System.out.println("Food produced: " + randNumberOfFood + " (" + Thread.currentThread().getName() + ")");
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
