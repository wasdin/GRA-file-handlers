// Use calcDist to calculate the distance between two locations or sets of points and return the distance in kilometers


// code base supplied by Dr. John Hunt, from http://kepler.covenant.edu/COS230/AsgDijkstraImproved/ConvertGPSCoordinantes.java
// He mentions to see http://www.movable-type.co.uk/scripts/latlong.html
public class ConvertGPSCoordinates {
	double calcDist(double lat1, double lon1, double lat2, double lon2){
		double R = 6371; //km
		double radLat1 = Math.toRadians(lat1);
		double radLat2 = Math.toRadians(lat2);
		double radDiffLat = Math.toRadians(lat2-lat1);
		double radDiffLon = Math.toRadians(lon2-lon1);
		
		double a = Math.sin(radDiffLat/2) * Math.sin(radDiffLat/2) +
				Math.cos(radLat1) * Math.cos(radLat2) *
				Math.sin(radDiffLon/2) * Math.sin(radDiffLon/2);
		double c = 2 * Math.atan2(Math.sqrt(a),  Math.sqrt(1-a));
		
		return R * c;
	}
	
	double calcDist(Location loc1, Location loc2) {
		double lat1 = loc1.getLatitude();
		double lat2 = loc2.getLatitude();
		double long1 = loc1.getLongitude();
		double long2 = loc2.getLongitude();
		
		return calcDist(lat1, long1, lat2, long2);
	}
	
	public ConvertGPSCoordinates() {
		// TODO Auto-generated constructor stub
	}

	// Test method
	public static void main(String[] args) {
		ConvertGPSCoordinates convertGPSCoordinantes = new ConvertGPSCoordinates();
		System.out.println(convertGPSCoordinantes.calcDist(33.796676,-84.394168,35.004133,-85.214009 ));
		System.out.println(convertGPSCoordinantes.calcDist(35.004133, -85.214009,34.971162, -85.449792 ));
		
		Location loc1 = new Location("Lake_Panasofkee@I-75/Floridas_Turnpike 28.859108, -82.090638");
		Location loc2 = new Location("Charelston@I-64/I-79 38.352426, -81.651978");
		
		ConvertGPSCoordinates convert = new ConvertGPSCoordinates();
		System.out.println(convert.calcDist(loc1, loc2));

	}

}