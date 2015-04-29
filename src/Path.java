import java.util.List;

// used to show the path between two cities

public class Path implements Comparable<Path> {
	Location point1;
	Location point2;
	double distance;
	String route;
	
	// passed String from gra file
	public Path(String passedString, List<Location> verteces) {
		LocationMatcher matcher = new LocationMatcher(verteces);
		
		String parts[] = passedString.split(" ");
		int coord1 = Integer.valueOf(parts[0]);
		int coord2 = Integer.valueOf(parts[1]);
			
		point1 = matcher.PositionToLocation(coord1);
		point2 = matcher.PositionToLocation(coord2);
		
		ConvertGPSCoordinates converter = new ConvertGPSCoordinates();
		distance = converter.calcDist(point1, point2);
		
		route = parts[2];
	}
	
	public Path(Location one, Location two, String route) {

		point1 = one;
		point2 = two;
		ConvertGPSCoordinates converter = new ConvertGPSCoordinates();
		distance = converter.calcDist(point1, point2);
		this.route = route;
		
	}
	
	public Path(Location one, Location two) {

		point1 = one;
		point2 = two;
		ConvertGPSCoordinates converter = new ConvertGPSCoordinates();
		distance = converter.calcDist(point1, point2);
		route = two.junction_1;
	}
	
	// returns a path in a human readable format
	public String toString() {
		String output = "";
		output += point1.name + " ";
		output += point2.name + " ";
		output += route;
		
		return output;
	}
	
	public String toString(List<Location> verteces) {
		LocationMatcher matcher = new LocationMatcher(verteces);
		
		String output = "";
		output += matcher.LocationToPosition(point1) + " ";
		output += matcher.LocationToPosition(point2) + " ";
		output += route;
		
		return output;
	}

	@Override
	public int compareTo(Path o) {
		Double distance1 = distance;
		Double distance2 = o.distance;
		
		if (distance1>distance2) {
			return 1;
		}
		else if (distance1==distance2) {
			return 0;
		}
		else {
			return -1;
		}
	}
	
	public int getPoint1_int(List<Location> verteces) {
		LocationMatcher matcher = new LocationMatcher(verteces);
		
		return matcher.LocationToPosition(point1);
	}
	
	public int getPoint2_int(List<Location> verteces) {
		LocationMatcher matcher = new LocationMatcher(verteces);

		return matcher.LocationToPosition(point2);
	}

	
	// AUTOGENERATED GETTERS AND SETTERS
	public Location getPoint1() {
		return point1;
	}

	public void setPoint1(Location point1) {
		this.point1 = point1;
	}

	public Location getPoint2() {
		return point2;
	}

	public void setPoint2(Location point2) {
		this.point2 = point2;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}
	
	

}
