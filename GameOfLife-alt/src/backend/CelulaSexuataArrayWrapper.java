package backend;

import java.util.ArrayList;

public class CelulaSexuataArrayWrapper {
	private ArrayList<CelulaSexuata> cells;
	
	public CelulaSexuataArrayWrapper() {
		this.cells = new ArrayList<CelulaSexuata>();
	}
	
	public synchronized void addCell(CelulaSexuata c)
	{
		this.cells.add(c);
	}
	
	public synchronized void removeCell(CelulaSexuata c)
	{
		this.cells.remove(c);
	}
	
	public synchronized CelulaSexuata cellReadyToReproduce(int i)
	{
		if(i == -1)
			return null;
		else if(i == 0 && this.cells.size() > 1)
		{
			CelulaSexuata next = this.cells.get(i + 1);
			if(next.getNewState() == true)
				return next;
			else
				return null;
		}
		else if(i == 0 && this.cells.size() == 1)
		{
			return null;
		}
		else if(i == this.cells.size() - 1)
		{
			CelulaSexuata prev = this.cells.get(i - 1);
			if(prev.getNewState() == true)
				return prev;
			else
				return null;
		}
		else
		{
			CelulaSexuata next = this.cells.get(i + 1);
			CelulaSexuata prev = this.cells.get(i - 1);
			if(prev.getNewState() == true)
				return prev;
			else if(next.getNewState() == true)
				return next;
			else
				return null;
		}

	}
	
	public synchronized int getIndexOf(CelulaSexuata c)
	{
		return this.cells.indexOf(c);
	}
}
