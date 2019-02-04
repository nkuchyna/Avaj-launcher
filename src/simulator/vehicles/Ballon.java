package simulator.vehicles;

import simulator.WeatherTower;
import weather.Logger;

public class Ballon extends Aircraft implements Flyable {
private WeatherTower weatherTower;

Ballon(String name, Coordinates coordinates)
{
	 super(name, coordinates);
}

public void	updateConditions()
{
	String weather = this.weatherTower.getWeather(this.coordinates);

	Logger.getLogger().printf("Ballon#%s(%d): ", this.name, this.id);
	if (weather.equals(WeatherTower.weather[0])) {
		Logger.getLogger().println("Oh the weather is sooo good!");
		this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
		this.coordinates.setHeight(this.coordinates.getHeight() + 4);
	}
	else if (weather.equals(WeatherTower.weather[1])) {
		Logger.getLogger().println("Oh no, rain! I can swim in a ballon basket...");
		this.coordinates.setHeight(this.coordinates.getHeight() - 5);
	}
	else if (weather.equals(WeatherTower.weather[2])) {
		Logger.getLogger().println("So foggy! Hope, I won't meet a JetPlane!");
		this.coordinates.setHeight(this.coordinates.getHeight() - 3);
	}
	else if (weather.equals(WeatherTower.weather[3])){
		Logger.getLogger().println("I am freezing... Better I will be in a Helicopter.");
		this.coordinates.setHeight(this.coordinates.getHeight() - 15);
	}

	if (this.coordinates.getHeight() > 100)
		this.coordinates.setHeight(100);
	else if (this.coordinates.getHeight() < 0)
		this.coordinates.setHeight(0);

	if (this.coordinates.getHeight() == 0)
	{
		Logger.getLogger().printf("Ballon#%s(%d) landing.%n", this.name, this.id);
		this.register = 0;
		Logger.getLogger().printf("Tower says: Ballon#%s(%d) unregister from weather tower.%n", this.name, this.id);
		Logger.getLogger().printf("Ballon#%s(%d) current coordinates: Latitude %d, Longitude %d, Height %d.%n", this.name, this.id,
				this.coordinates.getLatitude(), this.coordinates.getLongitude(), this.coordinates.getHeight());
	}
}
public void	registerTower(WeatherTower weatherTower)
{
	if (this.coordinates.getHeight() == 0)
	{
		Logger.getLogger().printf("Tower says: Ballon#%s(%d) can not be registered to weather tower.%n", this.name, this.id);
		Logger.getLogger().printf("Ballon#%s(%d) current coordinates: Latitude %d, Longitude %d, Height %d.%n", this.name, this.id,
				this.coordinates.getLatitude(), this.coordinates.getLongitude(), this.coordinates.getHeight());
		return;
	}
	weatherTower.register(this);
	Logger.getLogger().printf("Tower says: Ballon#%s(%d) registered to weather tower.%n", this.name, this.id);
	this.weatherTower = weatherTower;
}

public void checkRegister()
{
    if (this.register == 0)
    this.weatherTower.unregister(this);
}
public int checkHeight()
{
	if (this.coordinates.getHeight() < 1)
		return (0);
	return (1);
}

}