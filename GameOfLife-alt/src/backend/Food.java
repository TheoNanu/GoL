package backend;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Food {
	
	private int foodUnits; // variable accessed by multiple threads, needs to be protected
	
	public Food() {
		try (InputStream input = new FileInputStream("config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            String value = prop.getProperty("foodUnits");
            
            input.close();
            
            this.foodUnits = Integer.parseInt(value);

        } catch (IOException ex) {
        	this.foodUnits = 50;
        }
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
			System.out.println("Food remaining after I ate: " + this.foodUnits + " (" + Thread.currentThread().getName() + ")");
			return true;
		}
		else
			return false;
	}
	
	public synchronized void increaseUnitsBy(int value)
	{
		this.foodUnits += value;
		System.out.println("Food units after increment: " + this.foodUnits + " (" + Thread.currentThread().getName() + ")");
	}
}
