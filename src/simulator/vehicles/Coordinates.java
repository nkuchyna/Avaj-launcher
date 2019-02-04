package		simulator.vehicles;

public class Coordinates{
private	int		longitude;
private int		latitude;
private int		height;
Coordinates(int longitude, int latitude, int height) throws CoordinatesException{

	if (longitude < 0 || latitude < 0 || height < 0)
		throw new CoordinatesException();
	this.longitude = longitude;
	this.latitude = latitude;
	this.height = height;
	if (this.height > 100)
		this.height = 100;

}
	public int		getLongitude(){return (this.longitude); }
	public int		getLatitude(){return (this.latitude); }
	public int		getHeight(){return (this.height); }

	public void		setLongitude(int longitude) {this.longitude = longitude; }
	public void		setLatitude(int latitude){this.latitude = latitude; }
	public void		setHeight(int height){this.height = height; }
}