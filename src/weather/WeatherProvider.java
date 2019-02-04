package weather;

import simulator.vehicles.Coordinates;

public	class WeatherProvider{
private static String[]		weather = {"SUN", "RAIN", "FOG", "SNOW"};
private WeatherProvider(){};
public static WeatherProvider getProvider() {return (new WeatherProvider()); }

public String	getCurrentWeather(Coordinates coordinates)
	{
		if (coordinates.getLongitude() > 50 && coordinates.getLatitude() > 50 && coordinates.getHeight() > 50)
			return(weather[0]);
		else if (coordinates.getLongitude() < 10 && coordinates.getHeight() > 10)
			return (weather[1]);
		else if (coordinates.getLongitude() > 50 && coordinates.getLatitude() < 10 && coordinates.getHeight() < 10)
			return (weather[2]);
		else
			return (weather[3]);
	}
}