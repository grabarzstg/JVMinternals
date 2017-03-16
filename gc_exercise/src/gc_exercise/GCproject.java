package gc_exercise;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GCproject {

	public static void allocate(int m, boolean random) {
		Map<Integer, Arr> map = new HashMap<Integer, Arr>();
		if (random){
			for(int i = 0; i < m; i++){
				map.put(i, new Arr(1,2048));
			}
		} else {
			for(int i = 0; i < m; i++){
				map.put(i, new Arr());
			}
		}	
	}
	
	//http://www.oracle.com/technetwork/articles/java/vmoptions-jsp-140102.html
	//HeapSize -Xmx -Xms
	
	public static void main(String[] args) {
		int allocationNumber = 0;
		Boolean random = false;
		String gc = args[1];
		String type = "";
			
		try {
			allocationNumber = Integer.parseInt(System.getenv("ALLOC"));
			random = Boolean.parseBoolean(args[0]);
		} catch (NumberFormatException e) {
			System.out.println("ALLOC env not set. Exiting...");
			System.exit(1);
		}
		
		Long startTime = System.currentTimeMillis();
		allocate(allocationNumber, false);
		Long estimatedTime =  System.currentTimeMillis() - startTime;
		
		Long tmemory = Runtime.getRuntime().totalMemory()/1000000;
		if (random){ type = "random"; } else { type = "fixed"; }
		String csvFile = System.getProperty("user.dir") + "/results.csv";
		FileWriter writer;
		try {
			writer = new FileWriter(csvFile, true);
			CSVUtils.writeLine(writer, Arrays.asList(gc, type, tmemory.toString(), estimatedTime.toString()));
	        writer.close();
		} catch (IOException e) {
			System.out.println("Error occured while writing to file.");
			e.printStackTrace();
		}
		System.out.println("done.");
	}

}
