import java.util.List;

// used to match locations and array indeces

public class LocationMatcher {
	List<Location> verteces;
	
	public LocationMatcher(List<Location> passedVerteces) {
		verteces = passedVerteces;
	}
	
	
	int LocationToPosition(Location location) {
		for (int i=0; i<verteces.size(); i++) {
			Location tempLocation = (Location) verteces.get(i);
			if ((tempLocation.latitude == location.latitude) && (tempLocation.longitude == location.longitude))
				return i;
		}
		
		return 0;
	}
	
	Location PositionToLocation(int position) {
		return (Location) verteces.get(position);
	}
	
	
}
