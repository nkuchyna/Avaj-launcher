package simulator;

import simulator.vehicles.AircraftFactory;
import simulator.vehicles.Flyable;
import simulator.vehicles.CoordinatesException;
import weather.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Simulator{
	private static WeatherTower weatherTower;
	private static List<Flyable> flyables = new ArrayList<Flyable>();

	public static void main (String []  arg) throws InterruptedIOException, NoArgumentException, DirectoryException {

		try{
			if (arg.length != 1)
				throw new NoArgumentException();
			File myFile = new File(arg[0]);
			if (myFile.exists() && myFile.isDirectory())
				throw new DirectoryException();
			
			BufferedReader br = new BufferedReader(new FileReader(arg[0]));
			Logger.createLogger();
			String line = br.readLine();
			if (line != null){
				WeatherTower weatherTower = new WeatherTower();
				int simulations = Integer.parseInt(line.split(" ")[0]);

				if (simulations < 0) {
					System.out.println("Error! Simulations must be positive integer!");
					System.exit(1);
				}
				while ((line = br.readLine()) != null) {
					Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
							Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
							Integer.parseInt(line.split(" ")[4]));
					flyables.add(flyable);
				}
				for (int i = 0; i < flyables.size(); i++) {

				    flyables.get(i).registerTower(weatherTower);
                    weatherTower.register(flyables.get(i));
				}

				for (int i = 0; i < simulations; i++) {
					weatherTower.changeWeather();
				}
				Logger.getLogger().close();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error! Could not find file " + arg[0]);
		} catch (IOException e) {
			System.out.println("Error while reading file " + arg[0]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error! Wrong scenario file");
		}
		catch (NumberFormatException e){
			System.out.println("Error! Coordinates must be integers.");
		} catch (CoordinatesException e) {}
		catch (NoArgumentException e) {}
		catch (DirectoryException e) {}
	}
}