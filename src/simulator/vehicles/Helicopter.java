package simulator.vehicles;

import weather.Logger;
import simulator.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {

	private WeatherTower weatherTower;
	
	Helicopter(String name, Coordinates coordinates)
	{
		 super(name, coordinates);
	}

	public void	updateConditions()
	{
		String weather = this.weatherTower.getWeather(this.coordinates);

		Logger.getLogger().printf("Helicopter#%s(%d): ", this.name, this.id);
		if (weather.equals(WeatherTower.weather[0])){
			Logger.getLogger().println("The weather is sunny!");
			this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
			this.coordinates.setHeight(this.coordinates.getHeight() + 2);
		}
		else if (weather.equals(WeatherTower.weather[1])){
			Logger.getLogger().println("It is raining. Every weather is good, when you are good equipped!");
			this.coordinates.setLongitude(this.coordinates.getLongitude() - 5);
		}
		else if (weather.equals(WeatherTower.weather[2])){
			Logger.getLogger().println("The weather is so foggy! I can not see, but I have a good navigation.");
			this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
		}
		else if (weather.equals(WeatherTower.weather[3])){
			Logger.getLogger().println("White flies flew in...");
			this.coordinates.setHeight(this.coordinates.getHeight() - 12);
		}

		if (this.coordinates.getHeight() > 100)
			this.coordinates.setHeight(100);
		else if (this.coordinates.getHeight() < 0)
			this.coordinates.setHeight(0);

		if (this.coordinates.getHeight() == 0)
		{
			Logger.getLogger().printf("Helicopter#%s(%d) landing.%n", this.name, this.id);
			this.register = 0;
			Logger.getLogger().printf("Tower says: Helicopter#%s(%d) unregister from weather tower.%n", this.name, this.id);
			Logger.getLogger().printf("Helicopter#%s(%d) current coordinates: Latitude %d, Longitude %d, Height %d.%n", this.name, this.id,
					this.coordinates.getLatitude(), this.coordinates.getLongitude(), this.coordinates.getHeight());
		}
	}
	public void	registerTower(WeatherTower weatherTower)
	{
		if (this.coordinates.getHeight() == 0)
		{
			Logger.getLogger().printf("Tower says: Helicopter#%s(%d) can not be registered to weather tower.%n", this.name, this.id);
			Logger.getLogger().printf("Helicopter#%s(%d) current coordinates: Latitude %d, Longitude %d, Height %d.%n", this.name, this.id,
				this.coordinates.getLatitude(), this.coordinates.getLongitude(), this.coordinates.getHeight());
			return;
		}
		weatherTower.register(this);
		Logger.getLogger().printf("Tower says: Helicopter#%s(%d) registered to weather tower.%n", this.name, this.id);
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