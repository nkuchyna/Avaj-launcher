package simulator.vehicles;

import weather.Logger;
import simulator.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void	updateConditions()
    {
        String weather = this.weatherTower.getWeather(this.coordinates);

        Logger.getLogger().printf("JetPlane#%s(%d): ", this.name, this.id);
        if (weather.equals(WeatherTower.weather[0])){
            System.out.println("SUN! SUN! SUN!");
            this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
            this.coordinates.setHeight(this.coordinates.getHeight() + 2);
        }
        else if (weather.equals(WeatherTower.weather[1])){
            Logger.getLogger().println("RAIN! RAIN! RAIN!");
            this.coordinates.setLatitude(this.coordinates.getLatitude() - 5);
        }
        else if (weather.equals(WeatherTower.weather[2])){
            Logger.getLogger().println("FOG! FOG! FOG!");
            this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
        }
        else if (weather.equals(WeatherTower.weather[3])){
            Logger.getLogger().println("SNOW! SNOW! SNOW!");
            this.coordinates.setHeight(this.coordinates.getHeight() - 7);
        }

        if (this.coordinates.getHeight() > 100)
            this.coordinates.setHeight(100);
        else if (this.coordinates.getHeight() < 0)
            this.coordinates.setHeight(0);

        if (this.coordinates.getHeight() == 0)
        {
            Logger.getLogger().printf("JetPlane#%s(%d) landing.%n", this.name, this.id);
            this.register = 0;
            Logger.getLogger().printf("Tower says: JetPlane#%s(%d) unregister from weather tower.%n", this.name, this.id);
            Logger.getLogger().printf("JetPlane#%s(%d) current coordinates: Latitude %d, Longitude %d, Height %d.%n", this.name, this.id,
                    this.coordinates.getLatitude(), this.coordinates.getLongitude(), this.coordinates.getHeight());
        }
    }
    public void	registerTower(WeatherTower weatherTower)
    {
        if (this.coordinates.getHeight() == 0)
        {
            Logger.getLogger().printf("Tower says: JetPlane#%s(%d) can not be registered to weather tower.%n", this.name, this.id);
            Logger.getLogger().printf("JetPlane#%s(%d) current coordinates: Latitude %d, Longitude %d, Height %d.%n", this.name, this.id,
                this.coordinates.getLatitude(), this.coordinates.getLongitude(), this.coordinates.getHeight());
            return;
        }
        weatherTower.register(this);
        Logger.getLogger().printf("Tower says: JetPlane#%s(%d) registered to weather tower.%n", this.name, this.id);
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