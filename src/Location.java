// used to store locations
public class Location implements Comparable<Location> {
	public String name;
	public String junction_1;;
	public String junction_2;
	public double latitude;
	public int minDistance;
	public boolean isInTree; 
	
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double longitude;
	
	public Location(double passedLatitude, double passedLongitude) {
		name = "";
		junction_1 = "";
		junction_2 = "";
		latitude = passedLatitude;
		longitude = passedLongitude;
		minDistance = 0;
	}
	
	public Location(String passedName, String passedJunction1, String passedJunction2, double passedLatitude, double passedLongitude) {
		name = passedName;
		junction_1 = passedJunction1;
		junction_2 = passedJunction2;
		latitude = passedLatitude;
		longitude = passedLongitude;
		minDistance = 0;
	}
	
	// passed String works with file
	public Location(String passedString) {
		// Example accepted strings
		// Atlanta 33.745020, -84.390392
		// Lake_Panasofkee@I-75/Floridas_Turnpike 28.859108, -82.090638
		
		String split[] = passedString.replaceAll(",", "").split(" ");
		String names[] = split[0].split("@");
		name = names[0];
		
		if (names.length == 1) {
			junction_1 = "";
			junction_2 = "";
		}
		
		else {
			String junctions[] = names[1].split("/");
			junction_1 = junctions[0];
			if (junctions.length == 2) {
				junction_2 = junctions[1];
			}
			else {
				junction_2 = "";
			}
			
		}
				
		latitude = Double.parseDouble(split[1]);
		longitude = Double.parseDouble(split[2]);
		minDistance = 0;
	}
	

	public String getName() {
		return name;
	}
	
	public String getFullName() {
		String output = "";
		output += name;
		if (junction_1.equals("")) {
			// do nothing
		}
		else {
			output += "@";
			output += junction_1;
			
			if (junction_2!="") {
				output += "/";
				output += junction_2;
			}
		}
		
		return output;
	}
	

	public void setName(String name) {
		this.name = name;
	}

	public String getJunction_1() {
		return junction_1;
	}

	public void setJunction_1(String junction_1) {
		this.junction_1 = junction_1;
	}

	public String getJunction_2() {
		return junction_2;
	}

	public void setJunction_2(String junction_2) {
		this.junction_2 = junction_2;
	}

	public String toString() {
		String output = "";
		output += getFullName();
		
		output += " " + latitude;
		output += ", " + longitude;
		
		return output;
	}
	
	public static void main(String[] args) {
		Location test = new Location("Lake_Panasofkee@I-75/Floridas_Turnpike 28.859108, -82.090638");
		System.out.println(test);
		
	}

	@Override
	public int compareTo(Location arg0) {
		
		return 0;
	}

	public int getMinDistance() {
		return minDistance;
	}

	public void setMinDistance(int minDistance) {
		this.minDistance = minDistance;
	}
}
