
// used to work with Gra file

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*The gra format has 3 parts: 

1.       A single header line that has the number of vertices (called waypoints) and the number of paths (called connections). 
2.       There is a vertex section, with one line per vertex.  
         Each vertex line has a place name, delimited by space, a latitude, delimited by comma space, and a longitude.
3.       There is a path section, with one line per path.  Each path has the index of a vertex in the vertex section 
         that indicates the beginning of a path, delimited by space, the index of another vertex that indicates the 
         end of the path, delimited by space, and the path name. */


// reads Gra file
@SuppressWarnings("serial")
public class GraFile {
	int numVertex;
	int numPath;
	GrowableArray<Location> verteces;
	GrowableArray<Path> paths;

	// makes gra object from passed file
	public GraFile(File passedGra) {
		verteces = new GrowableArray<Location>();
		paths = new GrowableArray<Path>();
		
		try {
			Scanner scanner = new Scanner(passedGra);
			while (scanner.hasNextLine()) {
				String tempString = scanner.nextLine();
				//System.out.println(tempString);
				if (tempString.split(" ").length == 2) {
					numVertex = Integer.valueOf(tempString.split(" ")[0]);
					numPath = Integer.valueOf(tempString.split(" ")[1]);
				}
				else if (Character.isAlphabetic(tempString.toCharArray()[0])) {
					verteces.add(new Location(tempString));
				}
				else {
					paths.add(new Path(tempString, verteces));
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Invalid Gra file");
		}
			
	}
	
	// builds gra file from parts
	public GraFile(GrowableArray<Location> passedVerteces, GrowableArray<Path> passedPaths) {
		verteces = passedVerteces;
		paths = passedPaths;
		numVertex = verteces.size();
		numPath = paths.size();
	}
	

	public int getNumVertex() {
		return numVertex;
	}
	
	// makes string representation
	public String toString() {
		String output = "";
		output += numVertex + " " + numPath;
		for (int i=0; i<verteces.size(); i++) {
			Location tempLocation = (Location) verteces.get(i);
			output += "\n" + tempLocation;
		}
		for (int i=0; i<paths.size(); i++) {
			Path tempPath = (Path) paths.get(i);
			String tempOutput = tempPath.toString(verteces);
			output += "\n" + tempOutput;
		}
		
		return output;
	}
	
	// builds file
	public void toFile(String filename) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(filename + ".gra");
		writer.print(toString());
		writer.close();
		System.out.println("Generated " + filename + ".gra in root of project directory");
	}

	public void setNumVertex(int numVertex) {
		this.numVertex = numVertex;
	}

	public int getNumPath() {
		return numPath;
	}

	public void setNumPath(int numPath) {
		this.numPath = numPath;
	}

	public GrowableArray<Location> getVerteces() {
		return verteces;
	}

	public void setVerteces(GrowableArray<Location> verteces) {
		this.verteces = verteces;
	}

	public GrowableArray<Path> getPaths() {
		return paths;
	}

	public void setPaths(GrowableArray<Path> paths) {
		this.paths = paths;
	}
		
		
	
	
	
	
	
	
}
