package simulator.vehicles;

public abstract class Aircraft {

	protected long			id;
	protected String		name;
	protected Coordinates	coordinates;
	private static long		idCounter = 0;
	protected int			register;
	protected Aircraft(String name, Coordinates coordinates)
	{
		this.name = name;
		this.coordinates = coordinates;
		this.idCounter = this.nextId();
		this.id = this.idCounter;
		this.register = 1;
	}
	public Aircraft() {}
	private long	nextId()
	{
		return (++idCounter);
	}
}