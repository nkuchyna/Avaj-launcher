package simulator;

import simulator.vehicles.Coordinates;
import weather.WeatherProvider;

import java.io.IOException;

public class WeatherTower extends Tower{

	public static String[]		weather = {"SUN", "RAIN", "FOG", "SNOW"};
	public WeatherTower(){}
	public String getWeather(Coordinates coordinates)
	{
		return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
	}
	void changeWeather() throws IOException {
		this.conditionsChanged();
	}
}