
public class OccupancyMonitor {
	public Boolean occupied = false;

	public OccupancyMonitor() {
		System.out.println("Inside Occupance Monitor.Person Detected!!Turn ON Signal sent to CubeEquipments.");
		occupied = true;
		new CubeEquipments();
	}

}
