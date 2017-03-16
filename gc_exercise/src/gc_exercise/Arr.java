package gc_exercise;

import java.lang.reflect.Array;
import java.util.concurrent.ThreadLocalRandom;

public class Arr {
	private Array[] body;
	
	public Arr(){
		this.body = new Array[1024];
	}
	public Arr(int min, int max){
		int rng = ThreadLocalRandom.current().nextInt(min, max + 1);
		this.body = new Array[rng];
	}
}
