package mgrabowski.instrumentacja;
import static spark.Spark.*;

import java.util.Random;

import spark.Request;

public class Main {
    public static void main(String[] args) {
        get("/power/:arg", (req, res) -> agent(req));
    }
    
    public static String agent(Request req) throws InterruptedException {
    	Random rng = new Random();
    	
    	for(int i=0; i<100; i++){
    		if (rng.nextInt()%2 == 0){
    			Thread.sleep(100L);
    		}
    	}
    	
    	return req.params(":arg");
    }
}
