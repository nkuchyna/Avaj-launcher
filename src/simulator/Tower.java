package simulator;

import simulator.vehicles.Flyable;
import simulator.vehicles.Ballon;
import simulator.vehicles.Helicopter;
import simulator.vehicles.Ballon;
import simulator.vehicles.Coordinates;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public abstract class Tower{

	private List<Flyable> observers = new ArrayList<Flyable>();

	public void		register(Flyable flyable)
	{
		if (flyable != null && !observers.contains(flyable) && flyable.checkHeight() == 1)
			observers.add(flyable);
	}
	public void		unregister(Flyable flyable)
	{
		if (flyable != null && observers.contains(flyable))
			observers.remove(flyable);
	}
	protected void	conditionsChanged() throws IOException
	{
		if (observers.size() > 0)
			for (int i = 0; i < observers.size(); i++)
			{
				observers.get(i).updateConditions();
			}
		if (observers.size() > 0)
			for (int i = 0; i < observers.size(); i++)
			{
				observers.get(i).checkRegister();
			}
	}
}